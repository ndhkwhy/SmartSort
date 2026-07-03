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

public class HistoryActivity extends AppCompatActivity {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ImageView btnBack = findViewById(R.id.btnBackHistory);
        btnBack.setOnClickListener(v -> finish());

        RecyclerView rvHistory = findViewById(R.id.rvHistory);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));

        executor.execute(() -> {
            List<ScanHistory> historyList = AppDatabase.getInstance(this).historyDao().getAllHistory();
            runOnUiThread(() -> {
                HistoryAdapter adapter = new HistoryAdapter(historyList);
                rvHistory.setAdapter(adapter);
            });
        });
    }
}