package com.abubakar.makhrijal_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishExamActivity extends AppCompatActivity {

    Button btnShare;
    TextView txtVScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_exam);
        String score = getIntent().getStringExtra("score");
        String data = "Hi, My score is " + score + " on Makhārij Al-Hurūf App";
        txtVScore = findViewById(R.id.textViewScore);
        txtVScore.setText(score);
        btnShare = findViewById(R.id.btnShareResult);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, data);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
            }
        });
    }
}