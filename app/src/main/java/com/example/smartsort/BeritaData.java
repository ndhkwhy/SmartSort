package com.example.smartsort;

import java.util.ArrayList;
import java.util.List;

public class BeritaData {

    public static List<BeritaItem> getList() {
        List<BeritaItem> list = new ArrayList<>();

        list.add(new BeritaItem(
                "Implementasi Bank Sampah warga desa Sukamaju",
                "Inisiatif warga mengubah sampah rumah tangga jadi tabungan, hasilnya mengejutkan...",
                "Warga Desa Sukamaju kini punya cara baru memandang sampah rumah tangga mereka. Sejak tiga bulan lalu, kelompok ibu-ibu PKK setempat menggagas program Bank Sampah Mandiri, tempat warga bisa menabung sampah anorganik seperti botol plastik, kardus, dan kaleng untuk ditukar menjadi saldo tabungan.\n\n" +
                        "Setiap minggu, petugas bank sampah menimbang dan mencatat setoran warga ke buku tabungan masing-masing. Hasil penjualan sampah ke pengumpul daur ulang kemudian dikonversi menjadi saldo yang bisa diambil tunai atau ditukar kebutuhan pokok.\n\n" +
                        "Dalam tiga bulan pertama, program ini berhasil mengumpulkan lebih dari 800 kilogram sampah anorganik dan mengurangi volume sampah yang dibuang ke TPA secara signifikan. Warga mengaku terbantu secara ekonomi sekaligus merasa lebih sadar memilah sampah sejak rumah.\n\n" +
                        "Ke depannya, pengurus desa berencana memperluas program ini dengan menambah unit pengomposan untuk sampah organik, agar pengelolaan sampah di desa bisa lebih menyeluruh.",
                "Sukamaju, Jawa Barat / 21 Juni 2026 (Berita Fiksi)",
                R.drawable.berita_1,
                5012
        ));

        list.add(new BeritaItem(
                "SMA Harapan Baru Luncurkan Program Eco-Brick untuk Kurangi Sampah Plastik",
                "Siswa diajak mengubah sampah plastik jadi bata ramah lingkungan lewat proyek kelas...",
                "SMA Negeri Harapan Baru meluncurkan program edukasi lingkungan bertajuk \"Eco-Brick Action\" yang melibatkan seluruh siswa kelas X dan XI. Program ini mengajak siswa mengumpulkan sampah plastik sekali pakai, lalu memadatkannya ke dalam botol plastik bekas hingga menjadi bata ringan yang disebut eco-brick.\n\n" +
                        "Setiap kelas wajib mengumpulkan minimal 20 eco-brick per bulan, yang nantinya akan disusun menjadi furnitur sederhana seperti bangku taman dan pagar pembatas taman sekolah. Selain mengurangi sampah plastik yang berakhir di lingkungan, program ini juga melatih siswa memahami dampak sampah plastik terhadap ekosistem.\n\n" +
                        "Menurut pihak sekolah, sejak program ini berjalan, jumlah sampah plastik yang dibuang ke tempat pembuangan sekolah berkurang hingga 35%. Para siswa pun tampak antusias, beberapa di antaranya bahkan mengajak orang tua di rumah untuk ikut mengumpulkan sampah plastik untuk disetorkan ke sekolah.\n\n" +
                        "Program ini direncanakan akan terus berlanjut sebagai bagian dari kurikulum ekstrakurikuler peduli lingkungan di sekolah tersebut.",
                "Tunjung Sari, Jawa Tengah / 18 Juni 2026 (Berita Fiksi)",
                R.drawable.berita_2,
                3784
        ));

        list.add(new BeritaItem(
                "Pemkot Tunjung Sari Beri Insentif Bagi Warga yang Rutin Memilah Sampah",
                "Program baru pemerintah kota beri potongan retribusi bagi rumah tangga yang konsisten memilah sampah...",
                "Pemerintah Kota Tunjung Sari resmi meluncurkan program \"Pilah Sampah, Dapat Untung\" sebagai bentuk apresiasi bagi warga yang konsisten memilah sampah rumah tangga sejak dari sumbernya. Program ini memberikan potongan retribusi sampah bulanan hingga 30% bagi rumah tangga yang terbukti aktif memilah sampah organik dan anorganik secara terpisah.\n\n" +
                        "Untuk mengikuti program ini, warga cukup mendaftarkan rumah tangganya melalui kelurahan setempat, lalu petugas kebersihan akan melakukan pemantauan rutin terhadap konsistensi pemilahan sampah selama periode tertentu. Rumah tangga yang lolos verifikasi akan otomatis mendapatkan potongan pada tagihan retribusi sampah bulan berikutnya.\n\n" +
                        "Kepala Dinas Lingkungan Hidup setempat menyampaikan bahwa program ini merupakan langkah konkret untuk mendorong perubahan kebiasaan masyarakat dalam mengelola sampah, sekaligus mengurangi beban Tempat Pembuangan Akhir (TPA) yang kondisinya sudah semakin penuh.\n\n" +
                        "Sejak diluncurkan dua minggu lalu, lebih dari 1.200 rumah tangga telah mendaftar mengikuti program ini, dan pihak pemerintah kota optimis angka tersebut akan terus bertambah seiring sosialisasi yang masih berjalan di berbagai kelurahan.",
                "Tunjung Sari, Jawa Tengah / 15 Juni 2026 (Berita Fiksi)",
                R.drawable.berita_3,
                4256
        ));

        return list;
    }
}