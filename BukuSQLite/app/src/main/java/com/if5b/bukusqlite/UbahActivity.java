package com.if5b.bukusqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.if5b.bukusqlite.databinding.ActivityMainBinding;
import com.if5b.bukusqlite.databinding.ActivityUbahBinding;

public class UbahActivity extends AppCompatActivity {
    private ActivityUbahBinding binding;
    private String getId, getJudul, getPenulis, getTahun;
    private int getPosisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUbahBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent terima = getIntent();
        getId = terima.getStringExtra("VarID");
        getJudul = terima.getStringExtra("VarJudul");
        getPenulis = terima.getStringExtra("VarPenulis");
        getTahun = terima.getStringExtra("VarTahun");
        getPosisi = terima.getIntExtra("VarPosisi", -1);

        binding.etJudul.setText(getJudul);
        binding.etPenulis.setText(getPenulis);
        binding.etTahun.setText(getTahun);

        binding.btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtJudul = binding.etJudul.getText().toString();
                String txtPenulis = binding.etPenulis.getText().toString();
                String  txtTahun = binding.etTahun.getText().toString();

                if (txtJudul.trim().equals("")){
                    binding.etJudul.setError("Judul Tidak Boleh Kosong");
                }
                else if (txtPenulis.trim().equals("")){
                    binding.etPenulis.setError("Nama Penulis Tidak Boleh Kosong");
                }
                else if (txtTahun.trim().equals("")){
                    binding.etTahun.setError("Tahun Tidak Boleh Kosong");
                }else {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(UbahActivity.this);
                    long eksekusi = myDB.ubahBuku(getId, txtJudul, txtPenulis, Integer.valueOf(txtTahun));

                    if (eksekusi == -1){
                        Toast.makeText(UbahActivity.this, "Gagal Mengubah Data", Toast.LENGTH_SHORT).show();
                        binding.etJudul.requestFocus();
                    }
                    else {
                        Toast.makeText(UbahActivity.this, "Berhasil Mengubah Data", Toast.LENGTH_SHORT).show();
                        MainActivity.posisiData = getPosisi;
                        finish();
                    }

                }

            }
        });
    }
}