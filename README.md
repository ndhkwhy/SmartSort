Mobile Programming

Andhika Wahyu Novianto Hidayat
2410501041
Kelas B

====== SmartSort ======
Aplikasi Android untuk mengklasifikasikan kategori sampah melalui foto menggunakan Google Gemini AI.

====== Tentang Aplikasi ======
SmartSort membantu pengguna mengenali jenis sampah hanya dengan memotret objek tersebut. Sistem akan secara otomatis mengidentifikasi kategori sampah beserta informasi lengkapnya menggunakan AI dari Google Gemini API.

====== Fitur ======
- **Scan Sampah** — Ambil foto sampah, sistem otomatis mengklasifikasikan ke kategori Organik, Anorganik, B3, atau Residu
- **Detail Hasil** — Menampilkan nama, kategori, keterangan, karakteristik, dan pemanfaatan sampah
- **Riwayat Scan** — Menyimpan seluruh hasil pemindaian secara otomatis
- **Bookmark** — Simpan hasil scan favorit untuk dilihat kembali
- **Edukasi Kategori** — Informasi lengkap setiap kategori sampah dalam bentuk bottom sheet
- **Berita & Edukasi** — Artikel seputar pengelolaan sampah

====== Teknologi ======
| Komponen | Teknologi |
|---|---|
| Bahasa | Java (Android Native) |
| IDE | Android Studio |
| AI / API | Google Gemini API (gemini-2.5-flash) |
| Database | Room Database (SQLite) |
| Networking | Retrofit + Gson Converter |
| UI | Material Components, RecyclerView, CardView |<img width="1080" height="2400" alt="Screenshot_20260703_122236" src="https://github.com/user-attachments/assets/c83e2a56-e198-4fab-b244-95fdcbdf0b09" />


====== Cara Menjalankan ======
1. Clone repository ini
```bash
   git clone https://github.com/ndhkwhy/SmartSort.git
```
2. Buka project di Android Studio
3. Dapatkan API key Gemini di [aistudio.google.com](https://aistudio.google.com)/ Create API key - Copy Key 
4. Buka `MainActivity.java`, ganti baris berikut:
```
   private static final String API_KEY = "API_KEY_AI";
```
   dengan API key kamu.
5. Run aplikasi ke perangkat Android (minimum API 24 / Android 7.0)

====== Catatan ======
- Aplikasi membutuhkan koneksi internet untuk fitur klasifikasi sampah
- API key Gemini gratis tersedia di [Google AI Studio](https://aistudio.google.com)
- Jangan share API key secara publik
- Aplikasi membutuhkan akses kamera (izinkan)
- Aplikasi hanya tersedia mode terang (Light Mode)

** Project ini dibuat untuk keperluan tugas kuliah Pemrograman Mobile. **

====== ScreenShot ======
<img width="1080" height="2400" alt="Screenshot_20260703_122236" src="https://github.com/user-attachments/assets/504875e5-9da8-4fef-8fdd-a259a9bae368" />
<img width="1080" height="2400" alt="Screenshot_20260703_122252" src="https://github.com/user-attachments/assets/cd718273-4b5a-4f72-a098-bf31e9162cb2" />
<img width="1080" height="2400" alt="Screenshot_20260703_122303" src="https://github.com/user-attachments/assets/f58e83a2-3352-451e-8458-1288b9fde736" />


