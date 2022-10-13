package com.if5b.bukusqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.if5b.bukusqlite.databinding.ActivityMainBinding;
import com.if5b.bukusqlite.databinding.ActivityTambahBinding;

public class TambahActivity extends AppCompatActivity {
    private ActivityTambahBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTambahBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getJudul = binding.etJudul.getText().toString();
                String getPenulis = binding.etPenulis.getText().toString();
                String  getTahun = binding.etTahun.getText().toString();

                if (getJudul.trim().equals("")){
                    binding.etJudul.setError("Judul Tidak Boleh Kosong");
                }
                else if (getPenulis.trim().equals("")){
                    binding.etPenulis.setError("Nama Penulis Tidak Boleh Kosong");
                }
                else if (getTahun.trim().equals("")){
                    binding.etTahun.setError("Tahun Tidak Boleh Kosong");
                }
                else{
                    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);
                    long eksekusi =  myDB.tambahBuku(getJudul, getPenulis, Integer.valueOf(getTahun));

                    if (eksekusi == -1){
                        Toast.makeText(TambahActivity.this, "Gagal Menambah Data !", Toast.LENGTH_SHORT).show();
                        binding.etJudul.requestFocus();
                    }
                    else {
                        Toast.makeText(TambahActivity.this, "Tambah Data Berhasil", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}