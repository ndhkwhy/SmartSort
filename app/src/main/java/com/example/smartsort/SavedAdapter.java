package com.example.smartsort;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartsort.db.ScanHistory;

import java.util.List;

public class SavedAdapter extends RecyclerView.Adapter<SavedAdapter.SavedViewHolder> {

    private final List<ScanHistory> savedList;

    public SavedAdapter(List<ScanHistory> savedList) {
        this.savedList = savedList;
    }

    @NonNull
    @Override
    public SavedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved, parent, false);
        return new SavedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedViewHolder holder, int position) {
        ScanHistory item = savedList.get(position);

        holder.tvNama.setText(item.nama);
        holder.tvKategori.setText(item.kategori);

        String kategoriLower = item.kategori != null ? item.kategori.toLowerCase() : "";
        if (kategoriLower.contains("organik") && !kategoriLower.contains("anorganik")) {
            holder.iconContainer.setBackgroundResource(R.drawable.border_card_organik);
            holder.ivIcon.setImageResource(R.drawable.organik);
            holder.tvKategori.setTextColor(0xFF4CAF50);
        } else if (kategoriLower.contains("anorganik")) {
            holder.iconContainer.setBackgroundResource(R.drawable.border_card_anorganik);
            holder.ivIcon.setImageResource(R.drawable.anorganik);
            holder.tvKategori.setTextColor(0xFFFFA000);
        } else if (kategoriLower.contains("b3")) {
            holder.iconContainer.setBackgroundResource(R.drawable.border_card_b3);
            holder.ivIcon.setImageResource(R.drawable.b3);
            holder.tvKategori.setTextColor(0xFFF44336);
        } else {
            holder.iconContainer.setBackgroundResource(R.drawable.border_card_residu);
            holder.ivIcon.setImageResource(R.drawable.residu);
            holder.tvKategori.setTextColor(0xFF9E9E9E);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ResultActivity.class);
            intent.putExtra("id", item.id);
            intent.putExtra("isSaved", true);
            intent.putExtra("nama", item.nama);
            intent.putExtra("kategori", item.kategori);
            intent.putExtra("keterangan", item.keterangan);
            intent.putExtra("karakteristik", item.karakteristik);
            intent.putExtra("pemanfaatan", item.pemanfaatan);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return savedList.size();
    }

    static class SavedViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvKategori;
        ImageView ivIcon;
        FrameLayout iconContainer;

        SavedViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaSaved);
            tvKategori = itemView.findViewById(R.id.tvKategoriSaved);
            ivIcon = itemView.findViewById(R.id.ivIconSaved);
            iconContainer = itemView.findViewById(R.id.iconContainerSaved);
        }
    }
}