package com.example.skripsilele;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    LinearLayout linearSortir, LinearRiwayat;
    ImageView btnBack, btnSortir, btnRiwayat;
    TextView btnBack1, btnBack2, txtSortir, txtRiwayat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnBack = findViewById(R.id.img_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(open);
            }
        });

        btnBack1 = findViewById(R.id.tv_kembali3);
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(open);
            }
        });

        btnBack2 = findViewById(R.id.tv_kembali_menu3);
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(open);
            }
        });

        btnSortir = findViewById(R.id.btn_sortir);
        btnSortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this,DataTestingActivity.class);
                startActivity(open);
            }
        });

        txtSortir = findViewById(R.id.txt_sortir);
        txtSortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this,DataTestingActivity.class);
                startActivity(open);
            }
        });

        linearSortir = findViewById(R.id.btn_penyortiran);
        linearSortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this,DataTestingActivity.class);
                startActivity(open);
            }
        });

        LinearRiwayat = findViewById(R.id.btn_history);
        LinearRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this,RiwayatActivity.class);
                startActivity(open);
            }
        });

        btnRiwayat = findViewById(R.id.btn_riwayat);
        btnRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this,RiwayatActivity.class);
                startActivity(open);
            }
        });

        txtRiwayat = findViewById(R.id.txt_riwayat);
        txtRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(HomeActivity.this,RiwayatActivity.class);
                startActivity(open);
            }
        });
    }

}