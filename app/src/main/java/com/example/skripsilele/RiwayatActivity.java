package com.example.skripsilele;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RiwayatActivity extends AppCompatActivity {
    ImageView btnBack;
    TextView btnBack1, btnBack2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_riwayat_perhitungan);

        btnBack = findViewById(R.id.img_back_riwayat);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(RiwayatActivity.this,HomeActivity.class);
                startActivity(open);
            }
        });

        btnBack1 = findViewById(R.id.tv_kembali3);
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(RiwayatActivity.this,HomeActivity.class);
                startActivity(open);
            }
        });

        btnBack2 = findViewById(R.id.tv_kembali_menu3);
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(RiwayatActivity.this,HomeActivity.class);
                startActivity(open);
            }
        });
    }
}