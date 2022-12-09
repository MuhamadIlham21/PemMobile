package com.example.pemmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pemmobile.Adapter.Adapter_Barang;
import com.example.pemmobile.Model.m_barang;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Objects;

public class Barang extends AppCompatActivity {
    RecyclerView lvBarang;
    ArrayList<m_barang> data;
    Adapter_Barang adp;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        lvBarang = findViewById(R.id.lvBarang);
        db = FirebaseFirestore.getInstance();

        dataBarang();

    }

    public void dataBarang(){
        data = new ArrayList<>();

        ProgressDialog p = new ProgressDialog(this);
        p.setTitle("Loading");
        p.setMessage("Mohon tunggu sebentar...");
        p.show();
        db.collection("barang")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Data ", document.getId() + " => " + document.getData().get("nama_barang"));
                                data.add(
                                        new m_barang(
                                        document.getId().toString(),
                                        Objects.requireNonNull(document.getData().get("nama_barang")).toString(),
                                        R.drawable.ic_bike,
                                        Objects.requireNonNull(document.getData().get("harga")).toString(),
                                        Objects.requireNonNull(document.getData().get("satuan")).toString()
                                    )
                                );
                            }
                            adp = new Adapter_Barang(getApplicationContext(), data);
                            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                            llm.setOrientation(LinearLayoutManager.VERTICAL);
                            lvBarang.setLayoutManager(llm);
                            lvBarang.setAdapter(adp);
                        } else {
                            Toast.makeText(getApplicationContext(), "Gagal load!", Toast.LENGTH_SHORT).show();
                            // Log.w(TAG, "Error getting documents.", task.getException());
                        }
                        p.hide();
                    }
                });
    }

    private String format_rupiah(double idr){
        DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("");
        dfs.setMonetaryDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        String hsl = "Rp. " + df.format(idr);
        return hsl;
    }

}