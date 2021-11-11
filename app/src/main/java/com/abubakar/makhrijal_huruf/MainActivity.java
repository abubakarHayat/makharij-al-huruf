package com.abubakar.makhrijal_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTakeExam;
    Button btnPracticeNew;
    Button btnGotoRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTakeExam = findViewById(R.id.btnTakeExam);
        btnTakeExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentExam = new Intent(MainActivity.this,ExamActivity.class);
                startActivity(intentExam);
            }
        });
        btnPracticeNew = findViewById(R.id.btnPractice);
        btnPracticeNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPractice = new Intent(MainActivity.this,PracticeActivity.class);
                startActivity(intentPractice);
            }
        });
        Button btnRepo = findViewById(R.id.btnGotoRepo);
        btnRepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repoIntent = new Intent(Intent.ACTION_VIEW);
                repoIntent.setData(Uri.parse("https://github.com/abubakarHayat/makharij-al-huruf"));
                startActivity(repoIntent);
            }
        });
    }
}