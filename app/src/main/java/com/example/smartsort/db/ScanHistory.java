package com.example.smartsort.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scan_history")
public class ScanHistory {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nama;
    public String kategori;
    public String keterangan;
    public String karakteristik;
    public String pemanfaatan;
    public long timestamp;
    public boolean isSaved;

    public ScanHistory(String nama, String kategori, String keterangan, String karakteristik,
                       String pemanfaatan, long timestamp, boolean isSaved) {
        this.nama = nama;
        this.kategori = kategori;
        this.keterangan = keterangan;
        this.karakteristik = karakteristik;
        this.pemanfaatan = pemanfaatan;
        this.timestamp = timestamp;
        this.isSaved = isSaved;
    }
}