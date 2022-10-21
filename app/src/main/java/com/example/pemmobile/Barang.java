package com.example.pemmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pemmobile.Adapter.Adapter_Barang;
import com.example.pemmobile.Model.m_barang;

import java.util.ArrayList;

public class Barang extends AppCompatActivity {
    RecyclerView lvBarang;
    ArrayList<m_barang> data;
    Adapter_Barang adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        lvBarang = findViewById(R.id.lvBarang);

        dataBarang();

    }

    public void dataBarang(){
//        ArrayList<String> dataB = new ArrayList<>();
//        dataB.add("Monitor");
//        dataB.add("Mouse");
//        dataB.add("Processor");
//        dataB.add("Printer");
//
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
////                android.R.layout.simple_list_item_1, android.R.id.text1, dataB);
////
//        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, dataB);
//
//        lvBarang.setAdapter(adp);
        data = new ArrayList<>();
        data.add(new m_barang("barang 1", R.drawable.ic_bike));
        data.add(new m_barang("barang 2", R.drawable.ic_profil));
        adp = new Adapter_Barang(this, data);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvBarang.setLayoutManager(llm);
        lvBarang.setAdapter(adp);
    }

}