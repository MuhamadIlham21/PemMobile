package com.example.pemmobile.Model;

public class m_barang {
    String id_barang;
    String nama_barang;
    int img;
    String harga;
    String satuan;

    public m_barang(String id_barang, String nama_barang, int img, String harga, String satuan) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.img = img;
        this.harga = harga;
        this.satuan = satuan;
    }

    public m_barang(String nama_barang, int img, String harga, String satuan) {
        this.nama_barang = nama_barang;
        this.img = img;
        this.harga = harga;
        this.satuan = satuan;
    }

    public m_barang(String nama_barang, int img, String harga) {
        this.nama_barang = nama_barang;
        this.img = img;
        this.harga = harga;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
