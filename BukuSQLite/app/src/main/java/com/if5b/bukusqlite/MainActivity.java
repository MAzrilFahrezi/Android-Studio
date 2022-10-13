package com.if5b.bukusqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.if5b.bukusqlite.databinding.ActivityMainBinding;
import com.if5b.bukusqlite.databinding.ActivityTambahBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    MyDatabaseHelper myDB;
    AdapterBuku adapterBuku;
    ArrayList<String> arrID, arrJudul, arrPenulis, arrTahun;
    public static int posisiData = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        myDB = new MyDatabaseHelper(MainActivity.this);

    }

    public void bukaActivityTambah(View view) {
        startActivity(new Intent(MainActivity.this, TambahActivity.class));

    }

    private void SQLiteToArrayList() {
        Cursor cursor = myDB.bacaSemuaData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                arrID.add(cursor.getString(0));
                arrJudul.add(cursor.getString(1));
                arrPenulis.add(cursor.getString(2));
                arrTahun.add(cursor.getString(3));
            }
        }
    }

    protected void onResume(){
        super.onResume();

        arrID = new ArrayList<>();
        arrJudul = new ArrayList<>();
        arrPenulis = new ArrayList<>();
        arrTahun = new ArrayList<>();

        adapterBuku = new AdapterBuku(MainActivity.this, arrID,arrJudul,arrPenulis,arrTahun);
        binding.rvBuku.setAdapter(adapterBuku);
        binding.rvBuku.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.rvBuku.smoothScrollToPosition(posisiData);

        SQLiteToArrayList();
    }
}