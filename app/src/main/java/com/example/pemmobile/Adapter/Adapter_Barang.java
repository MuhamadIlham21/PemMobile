package com.example.pemmobile.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pemmobile.Detail_barang;
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
        holder.tvHarga.setText(String.valueOf(mb.getHarga()));
        holder.tvSatuan.setText(mb.getSatuan());
        holder.imgBarang.setImageResource(mb.getImg());

//        holder.imgBarang.setOnClickListener(view -> {
//            view.getContext().startActivity(new Intent(mCtx, Detail_barang.class));
//        });

    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    static class BarangViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama,tvHarga,tvSatuan;
        ImageView imgBarang;

        public BarangViewHolder(View itemView) {
            super(itemView);
            tvSatuan = itemView.findViewById(R.id.tvSatuan);
            tvNama = itemView.findViewById(R.id.tvBarang);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            imgBarang = itemView.findViewById(R.id.imgBrg);
        }
    }
}
