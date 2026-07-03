package com.example.smartsort;

public class BeritaItem {
    public String judul;
    public String ringkasan;
    public String isiLengkap;
    public String lokasiTanggal;
    public int fotoRes;
    public int jumlahView;

    public BeritaItem(String judul, String ringkasan, String isiLengkap, String lokasiTanggal, int fotoRes, int jumlahView) {
        this.judul = judul;
        this.ringkasan = ringkasan;
        this.isiLengkap = isiLengkap;
        this.lokasiTanggal = lokasiTanggal;
        this.fotoRes = fotoRes;
        this.jumlahView = jumlahView;
    }
}