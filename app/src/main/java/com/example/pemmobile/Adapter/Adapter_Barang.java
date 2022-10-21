package com.example.pemmobile.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pemmobile.Model.m_barang;
import com.example.pemmobile.R;

import java.util.ArrayList;

public class Adapter_Barang extends RecyclerView.Adapter<Adapter_Barang.BarangViewHolder> {
    private final Context mCtx;
    private final ArrayList<m_barang> listBarang;

    public Adapter_Barang(Context mCtx, ArrayList<m_barang> listHasil) {
        this.mCtx = mCtx;
        this.listBarang = listHasil;
    }

    @NonNull
    @Override
    public Adapter_Barang.BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.list_barang, null);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Barang.BarangViewHolder holder, int position) {
        m_barang mb = listBarang.get(position);
        holder.tvNama.setText(mb.getNama_barang());
        holder.imgBarang.setImageResource(mb.getImg());
//        holder.tvNama.setText(mb.nama_barang);
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    static class BarangViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama;
        ImageView imgBarang;

        public BarangViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            imgBarang = itemView.findViewById(R.id.imgBrg);
        }
    }
}
