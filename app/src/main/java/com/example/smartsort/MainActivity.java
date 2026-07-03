package com.example.smartsort;

import android.content.Intent;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartsort.api.ApiClient;
import com.example.smartsort.api.GeminiApiService;
import com.example.smartsort.model.GeminiRequest;
import com.example.smartsort.model.GeminiResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.smartsort.db.AppDatabase;
import com.example.smartsort.db.ScanHistory;

import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    // API AI GEMINI
    private static final String API_KEY = "API_KEY_AI";

    private ActivityResultLauncher<Void> cameraLauncher;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupKategoriItems();
        setupBeritaItems();

        FloatingActionButton fabScan = findViewById(R.id.fabScan);

        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.TakePicturePreview(),
                bitmap -> {
                    if (bitmap != null) {
                        kirimFotoKeAPI(bitmap);
                    }
                }
        );

        fabScan.setOnClickListener(v -> cameraLauncher.launch(null));

        ImageView btnHistory = findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });

        ImageView btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SavedActivity.class);
            startActivity(intent);
        });
    }

    private void setupBeritaItems() {
        LinearLayout listBerita = findViewById(R.id.listBerita);
        List<BeritaItem> beritaList = BeritaData.getList();

        for (int i = 0; i < beritaList.size(); i++) {
            BeritaItem item = beritaList.get(i);
            View itemView = LayoutInflater.from(this).inflate(R.layout.item_berita, listBerita, false);

            ImageView ivFoto = itemView.findViewById(R.id.ivFotoBerita);
            TextView tvJudul = itemView.findViewById(R.id.tvJudulBerita);
            TextView tvRingkasan = itemView.findViewById(R.id.tvRingkasanBerita);
            TextView tvViews = itemView.findViewById(R.id.tvViewsBerita);

            ivFoto.setImageResource(item.fotoRes);
            tvJudul.setText(item.judul);
            tvRingkasan.setText(item.ringkasan);
            tvViews.setText(String.valueOf(item.jumlahView));

            int index = i;
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, BeritaDetailActivity.class);
                intent.putExtra("index", index);
                startActivity(intent);
            });

            listBerita.addView(itemView);
        }
    }

    private void setupKategoriItems() {
        setKategori(findViewById(R.id.catOrganik), R.drawable.organik, "Organik");
        setKategori(findViewById(R.id.catAnorganik), R.drawable.anorganik, "Anorganik");
        setKategori(findViewById(R.id.catB3), R.drawable.b3, "B3");
        setKategori(findViewById(R.id.catResidu), R.drawable.residu, "Residu");
    }

    private void setKategori(View itemView, int iconRes, String nama) {
        ImageView icon = itemView.findViewById(R.id.ivIconKategori);
        TextView nameText = itemView.findViewById(R.id.tvNamaKategori);
        icon.setImageResource(iconRes);
        nameText.setText(nama);

        itemView.setOnClickListener(v -> {
            EdukasiBottomSheet bottomSheet = EdukasiBottomSheet.newInstance(nama);
            bottomSheet.show(getSupportFragmentManager(), "EdukasiBottomSheet");
        });
    }
    private void kirimFotoKeAPI(Bitmap bitmap) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Menganalisis foto...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        byte[] imageBytes = baos.toByteArray();
        String base64Image = Base64.encodeToString(imageBytes, Base64.NO_WRAP);

        GeminiRequest request = new GeminiRequest();
        GeminiRequest.Content content = new GeminiRequest.Content();
        content.parts = new ArrayList<>();

        GeminiRequest.Part textPart = new GeminiRequest.Part();
        textPart.text = "Analisis foto sampah ini dan jawab PERSIS dengan format berikut tanpa tambahan apapun:\n" +
                "Nama: [nama benda]\n" +
                "Kategori: [Organik/Anorganik/B3/Residu]\n" +
                "Keterangan: [1-3 kalimat penjelasan jenis sampah diawali dengan nama barang merupakan sampah (kategori) karena]\n" +
                "Karakteristik: [1-3 kalimat karakteristik kategori sampah, gabungkan sampah dengan (sampah sejenisnya)]\n" +
                "Pemanfaatan: [daftar pemanfaatan yang bisa dilakukan, pisahkan dengan koma]";

        GeminiRequest.Part imagePart = new GeminiRequest.Part();
        imagePart.inline_data = new GeminiRequest.InlineData();
        imagePart.inline_data.mime_type = "image/jpeg";
        imagePart.inline_data.data = base64Image;

        content.parts.add(textPart);
        content.parts.add(imagePart);

        request.contents = new ArrayList<>();
        request.contents.add(content);

        GeminiApiService apiService = ApiClient.getApiService();
        Call<GeminiResponse> call = apiService.classifyImage(API_KEY, request);

        call.enqueue(new Callback<GeminiResponse>() {
            @Override
            public void onResponse(Call<GeminiResponse> call, Response<GeminiResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        String hasilText = response.body().candidates.get(0).content.parts.get(0).text;
                        tampilkanHasilScan(hasilText);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Gagal membaca hasil.", Toast.LENGTH_SHORT).show();
                    }
                } else if (response.code() == 429) {
                    Toast.makeText(MainActivity.this, "Terlalu banyak request, tunggu sebentar lalu coba scan lagi.", Toast.LENGTH_LONG).show();
                } else if (response.code() == 503) {
                    Toast.makeText(MainActivity.this, "Server Gemini sedang sibuk, coba lagi sebentar.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GeminiResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Gagal koneksi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tampilkanHasilScan(String hasilText) {
        String nama = "-", kategori = "-", keterangan = "-", karakteristik = "-", pemanfaatan = "-";

        String[] lines = hasilText.split("\n");
        for (String line : lines) {
            if (line.startsWith("Nama:")) {
                nama = line.replace("Nama:", "").trim();
            } else if (line.startsWith("Kategori:")) {
                kategori = line.replace("Kategori:", "").trim();
            } else if (line.startsWith("Keterangan:")) {
                keterangan = line.replace("Keterangan:", "").trim();
            } else if (line.startsWith("Karakteristik:")) {
                karakteristik = line.replace("Karakteristik:", "").trim();
            } else if (line.startsWith("Pemanfaatan:")) {
                pemanfaatan = line.replace("Pemanfaatan:", "").trim();
            }
        }

        String finalNama = nama, finalKategori = kategori, finalKeterangan = keterangan,
                finalKarakteristik = karakteristik, finalPemanfaatan = pemanfaatan;

        Executors.newSingleThreadExecutor().execute(() -> {
            ScanHistory history = new ScanHistory(finalNama, finalKategori, finalKeterangan,
                    finalKarakteristik, finalPemanfaatan, System.currentTimeMillis(), false);
            long insertedId = AppDatabase.getInstance(getApplicationContext()).historyDao().insert(history);

            runOnUiThread(() -> {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("id", (int) insertedId);
                intent.putExtra("nama", finalNama);
                intent.putExtra("kategori", finalKategori);
                intent.putExtra("keterangan", finalKeterangan);
                intent.putExtra("karakteristik", finalKarakteristik);
                intent.putExtra("pemanfaatan", finalPemanfaatan);
                intent.putExtra("isSaved", false);
                startActivity(intent);
            });
        });
    }
}