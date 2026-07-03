package com.example.smartsort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class EdukasiBottomSheet extends BottomSheetDialogFragment {

    private static final String ARG_KATEGORI = "kategori";

    public static EdukasiBottomSheet newInstance(String kategori) {
        EdukasiBottomSheet fragment = new EdukasiBottomSheet();
        Bundle args = new Bundle();
        args.putString(ARG_KATEGORI, kategori);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_edukasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String kategori = getArguments() != null ? getArguments().getString(ARG_KATEGORI) : "Organik";
        EdukasiData data = EdukasiData.getData(kategori);

        TextView tvJudulKategori = view.findViewById(R.id.tvJudulKategori);
        ImageView ivFoto = view.findViewById(R.id.ivFotoEdukasi);
        ImageView ivIconBadge = view.findViewById(R.id.ivIconBadge);
        TextView tvJudulApaItu = view.findViewById(R.id.tvJudulApaItu);
        TextView tvDeskripsi = view.findViewById(R.id.tvDeskripsi);
        TextView tvJudulCiri = view.findViewById(R.id.tvJudulCiri);
        TextView tvCiriCiri = view.findViewById(R.id.tvCiriCiri);
        TextView tvContoh = view.findViewById(R.id.tvContoh);
        TextView tvJudulJenis = view.findViewById(R.id.tvJudulJenis);
        TextView tvJenisJenis = view.findViewById(R.id.tvJenisJenis);

        tvJudulKategori.setText(data.judul);
        tvJudulKategori.setTextColor(data.warnaJudul);
        ivFoto.setImageResource(data.fotoRes);
        ivIconBadge.setImageResource(data.iconRes);
        tvJudulApaItu.setText(data.apaItu);
        tvDeskripsi.setText(data.deskripsi);
        tvJudulCiri.setText("Ciri-Ciri Sampah " + data.judul);
        tvCiriCiri.setText(data.ciriCiri);
        tvContoh.setText(data.contoh);
        tvJudulJenis.setText("Jenis-Jenis Sampah " + data.judul);
        tvJenisJenis.setText(data.jenisJenis);
    }
}