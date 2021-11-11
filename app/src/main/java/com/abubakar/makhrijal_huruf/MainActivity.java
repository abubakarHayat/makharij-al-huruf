package com.abubakar.makhrijal_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTakeExam;
    Button btnPractice;
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
    }
}