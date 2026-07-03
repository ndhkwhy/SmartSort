package com.example.smartsort.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {

    @Insert
    long insert(ScanHistory history);

    @Query("SELECT * FROM scan_history ORDER BY timestamp DESC")
    List<ScanHistory> getAllHistory();

    @Query("SELECT * FROM scan_history WHERE isSaved = 1 ORDER BY timestamp DESC")
    List<ScanHistory> getSavedHistory();

    @Query("UPDATE scan_history SET isSaved = :isSaved WHERE id = :id")
    void setSaved(int id, boolean isSaved);
}