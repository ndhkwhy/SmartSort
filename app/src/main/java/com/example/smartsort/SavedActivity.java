package com.example.smartsort;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartsort.db.AppDatabase;
import com.example.smartsort.db.ScanHistory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SavedActivity extends AppCompatActivity {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        ImageView btnBack = findViewById(R.id.btnBackSaved);
        btnBack.setOnClickListener(v -> finish());

        RecyclerView rvSaved = findViewById(R.id.rvSaved);
        rvSaved.setLayoutManager(new LinearLayoutManager(this));

        executor.execute(() -> {
            List<ScanHistory> savedList = AppDatabase.getInstance(this).historyDao().getSavedHistory();
            runOnUiThread(() -> {
                SavedAdapter adapter = new SavedAdapter(savedList);
                rvSaved.setAdapter(adapter);
            });
        });
    }
}