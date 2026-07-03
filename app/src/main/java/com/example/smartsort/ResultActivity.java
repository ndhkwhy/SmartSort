package com.example.smartsort;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartsort.db.AppDatabase;

import java.util.concurrent.Executors;

public class ResultActivity extends AppCompatActivity {

    private boolean isSaved = false;
    private int historyId = -1;
    private ImageView btnBookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView btnBack = findViewById(R.id.btnBack);
        btnBookmark = findViewById(R.id.btnBookmark);
        ImageView ivIconHasil = findViewById(R.id.ivIconHasil);
        FrameLayout circleContainer = findViewById(R.id.circleIconContainer);

        TextView tvNama = findViewById(R.id.tvNama);
        TextView tvKategori = findViewById(R.id.tvKategori);
        TextView tvKeterangan = findViewById(R.id.tvKeterangan);
        TextView tvKarakteristik = findViewById(R.id.tvKarakteristik);
        TextView tvPemanfaatan = findViewById(R.id.tvPemanfaatan);

        btnBack.setOnClickListener(v -> finish());

        historyId = getIntent().getIntExtra("id", -1);
        isSaved = getIntent().getBooleanExtra("isSaved", false);

        String nama = getIntent().getStringExtra("nama");
        String kategori = getIntent().getStringExtra("kategori");
        String keterangan = getIntent().getStringExtra("keterangan");
        String karakteristik = getIntent().getStringExtra("karakteristik");
        String pemanfaatan = getIntent().getStringExtra("pemanfaatan");

        tvNama.setText(nama != null ? nama : "-");
        tvKategori.setText(kategori != null ? kategori : "-");
        tvKeterangan.setText(keterangan != null ? keterangan : "-");
        tvKarakteristik.setText(karakteristik != null ? karakteristik : "-");
        tvPemanfaatan.setText(pemanfaatan != null ? pemanfaatan : "-");

        String kategoriLower = kategori != null ? kategori.toLowerCase() : "";
        if (kategoriLower.contains("organik") && !kategoriLower.contains("anorganik")) {
            circleContainer.setBackgroundResource(R.drawable.border_circle_organik);
            ivIconHasil.setImageResource(R.drawable.organik);
        } else if (kategoriLower.contains("anorganik")) {
            circleContainer.setBackgroundResource(R.drawable.border_circle_anorganik);
            ivIconHasil.setImageResource(R.drawable.anorganik);
        } else if (kategoriLower.contains("b3")) {
            circleContainer.setBackgroundResource(R.drawable.border_circle_b3);
            ivIconHasil.setImageResource(R.drawable.b3);
        } else {
            circleContainer.setBackgroundResource(R.drawable.border_circle_residu);
            ivIconHasil.setImageResource(R.drawable.residu);
        }

        updateBookmarkIcon();

        btnBookmark.setOnClickListener(v -> toggleSaved());
    }

    private void updateBookmarkIcon() {
        btnBookmark.setImageResource(isSaved ? R.drawable.ic_save_filled : R.drawable.ic_save);
    }

    private void toggleSaved() {
        if (historyId == -1) return;

        isSaved = !isSaved;
        updateBookmarkIcon();

        boolean finalIsSaved = isSaved;
        Executors.newSingleThreadExecutor().execute(() ->
                AppDatabase.getInstance(getApplicationContext()).historyDao().setSaved(historyId, finalIsSaved)
        );
    }
}