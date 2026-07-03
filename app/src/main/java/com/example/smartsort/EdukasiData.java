package com.example.smartsort;

public class EdukasiData {

    public String judul;
    public int fotoRes;
    public int iconRes;
    public int warnaJudul;
    public String apaItu;
    public String deskripsi;
    public String ciriCiri;
    public String contoh;
    public String jenisJenis;

    public EdukasiData(String judul, int fotoRes, int iconRes, int warnaJudul,
                       String apaItu, String deskripsi, String ciriCiri, String contoh, String jenisJenis) {
        this.judul = judul;
        this.fotoRes = fotoRes;
        this.iconRes = iconRes;
        this.warnaJudul = warnaJudul;
        this.apaItu = apaItu;
        this.deskripsi = deskripsi;
        this.ciriCiri = ciriCiri;
        this.contoh = contoh;
        this.jenisJenis = jenisJenis;
    }

    public static EdukasiData getData(String kategori) {
        switch (kategori) {
            case "Organik":
                return new EdukasiData(
                        "Organik",
                        R.drawable.edukasi_organik,
                        R.drawable.organik,
                        0xFF4CAF50,
                        "Apa Itu Sampah Organik?",
                        "Sampah organik adalah sampah yang berasal dari makhluk hidup (tumbuhan, hewan, atau organisme lain) yang dapat terurai secara alami oleh mikroorganisme seperti bakteri dan jamur. Proses penguraian ini disebut biodegradasi.",
                        "1. Berasal dari makhluk hidup\n2. Mudah terurai secara alami\n3. Mengandung senyawa organik\n4. Umumnya memiliki kadar air tinggi",
                        "Contoh sampah organik antara lain kulit buah, sisa makanan, daun kering, sisa ikan, cangkang telur, dan sisa sayuran.",
                        "1. Sampah Organik Basah\n2. Sampah Organik Kering"
                );
            case "Anorganik":
                return new EdukasiData(
                        "Anorganik",
                        R.drawable.edukasi_anorganik,
                        R.drawable.anorganik,
                        0xFFFFA000,
                        "Apa Itu Sampah Anorganik?",
                        "Sampah anorganik adalah sampah yang berasal dari bahan-bahan non-hayati, baik berupa produk sintetis maupun hasil proses teknologi pengolahan bahan tambang. Sampah ini sulit atau membutuhkan waktu sangat lama untuk terurai secara alami.",
                        "1. Berasal dari bahan sintetis/non-hayati\n2. Sulit terurai secara alami\n3. Bersifat tahan lama (durable)\n4. Bisa didaur ulang (recyclable)",
                        "Contoh sampah anorganik antara lain botol plastik, kaleng, kaca, kertas, dan styrofoam.",
                        "1. Sampah Anorganik Logam\n2. Sampah Anorganik Plastik\n3. Sampah Anorganik Kaca"
                );
            case "B3":
                return new EdukasiData(
                        "B3",
                        R.drawable.edukasi_b3,
                        R.drawable.b3,
                        0xFFF44336,
                        "Apa Itu Sampah B3?",
                        "Sampah B3 (Bahan Berbahaya dan Beracun) adalah sisa suatu usaha/kegiatan yang mengandung bahan berbahaya dan/atau beracun, yang karena sifat, konsentrasi, jumlahnya dapat mencemarkan/merusak lingkungan dan/atau membahayakan kesehatan manusia.",
                        "1. Bersifat beracun/korosif\n2. Mudah terbakar atau meledak\n3. Berbahaya bagi kesehatan jika kontak langsung\n4. Memerlukan penanganan khusus",
                        "Contoh sampah B3 antara lain baterai bekas, lampu neon/CFL, oli bekas, cat, dan obat-obatan kedaluwarsa.",
                        "1. B3 Cair (oli, cat)\n2. B3 Padat (baterai, lampu)\n3. B3 Medis (jarum suntik, masker bekas)"
                );
            default: // Residu
                return new EdukasiData(
                        "Residu",
                        R.drawable.edukasi_residu,
                        R.drawable.residu,
                        0xFF9E9E9E,
                        "Apa Itu Sampah Residu?",
                        "Sampah residu adalah sisa sampah hasil pengolahan yang sudah tidak dapat dimanfaatkan lagi, baik melalui proses daur ulang maupun pengomposan. Sampah ini biasanya berakhir di tempat pembuangan akhir (TPA).",
                        "1. Tidak bisa didaur ulang lagi\n2. Tidak bisa dikompos\n3. Campuran berbagai material yang sulit dipisahkan\n4. Akhirnya dibuang ke TPA",
                        "Contoh sampah residu antara lain puntung rokok, popok sekali pakai, kemasan makanan multilayer, dan tisu bekas.",
                        "1. Residu Campuran\n2. Residu Sanitasi (popok, pembalut)"
                );
        }
    }
}