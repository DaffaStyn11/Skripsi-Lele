package com.example.skripsilele;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.File;

public class DataTestingActivity extends AppCompatActivity {
    private static final int REQUEST_VIDEO_CAPTURE = 1;
    private static final int REQUEST_PICK_VIDEO = 2;
    ImageView img;
    ImageView btnBack;
    TextView btnBack1;
    TextView btnBack2;
    Button btn_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_data_testing);

        btnBack = findViewById(R.id.img_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(DataTestingActivity.this,HomeActivity.class);
                startActivity(open);
            }
        });

        btnBack1 = findViewById(R.id.tv_kembali3);
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(DataTestingActivity.this,HomeActivity.class);
                startActivity(open);
            }
        });

        btnBack2 = findViewById(R.id.tv_kembali_menu3);
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(DataTestingActivity.this,HomeActivity.class);
                startActivity(open);
            }
        });

        btn_img = findViewById(R.id.btn_ambil_video);

        img = findViewById(R.id.id_dummy_picture);
        /*findViewById(R.id.btn_ambil_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,1);
            }
        });*/

        Spinner sumberVideoSpinner = findViewById(R.id.sumber_video_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sumber_video_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sumberVideoSpinner.setAdapter(adapter);
        sumberVideoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Kamera")) {
                    ambilVideoDariKamera();
                } else if (selectedItem.equals("Galeri")) {
                    ambilVideoDariGaleri();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Tidak ada tindakan yang diambil jika tidak ada item yang dipilih
            }
        });
    }

    private void ambilVideoDariKamera() {
        /*Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);*/
        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(DataTestingActivity.this, CameraActivity.class);
                startActivity(open);
            }
        });
    }

    private void ambilVideoDariGaleri() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        intent.setType("video/*");
        startActivityForResult(intent, REQUEST_PICK_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_VIDEO_CAPTURE || requestCode == REQUEST_PICK_VIDEO) {
                // Mendapatkan referensi ImageView
                ImageView imageView = findViewById(R.id.id_dummy_picture);

                // Memuat cuplikan gambar pertama dari video menggunakan Glide
                Glide.with(this)
                        .asBitmap() // Memuat gambar sebagai bitmap
                        .load(data.getData()) // Mengambil URI dari video
                        .into(imageView); // Mengisi ImageView dengan gambar pertama dari video

                // Menambahkan event listener untuk ImageView
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Membuat dialog AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(DataTestingActivity.this);

                        // Membuat VideoView
                        VideoView videoView = new VideoView(DataTestingActivity.this);
                        videoView.setVideoURI(data.getData());
                        videoView.start();

                        // Menambahkan VideoView ke dalam dialog dan menampilkannya
                        builder.setView(videoView).show();
                    }
                });
            }
        }
    }

    private void setThumbnail(String path) {
        Log.d("PATH", "setThumbnail: " + Uri.parse(path));
        ImageView gladeImg = findViewById(R.id.id_dummy_picture) ;
        Glide.with(DataTestingActivity.this)
                .asBitmap()
                .load(Uri.fromFile(new File(path)))
                .into(gladeImg);
    }
}