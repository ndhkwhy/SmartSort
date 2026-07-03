package com.example.smartsort;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BeritaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_detail);

        ImageView btnBack = findViewById(R.id.btnBackBerita);
        ImageView ivFoto = findViewById(R.id.ivFotoDetailBerita);
        TextView tvJudul = findViewById(R.id.tvJudulDetailBerita);
        TextView tvLokasiTanggal = findViewById(R.id.tvLokasiTanggal);
        TextView tvIsi = findViewById(R.id.tvIsiBerita);

        btnBack.setOnClickListener(v -> finish());

        int index = getIntent().getIntExtra("index", 0);
        List<BeritaItem> beritaList = BeritaData.getList();

        if (index >= 0 && index < beritaList.size()) {
            BeritaItem item = beritaList.get(index);
            ivFoto.setImageResource(item.fotoRes);
            tvJudul.setText(item.judul);
            tvLokasiTanggal.setText(item.lokasiTanggal);
            tvIsi.setText(item.isiLengkap);
        }
    }
}