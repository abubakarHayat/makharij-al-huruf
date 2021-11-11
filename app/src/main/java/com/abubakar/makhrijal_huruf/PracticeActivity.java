package com.abubakar.makhrijal_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class PracticeActivity extends AppCompatActivity {

    int counterPr =0;
    int scorePr = 0;
    int randNoPr = 0;
    RadioGroup radioGroupPractice;
    RadioButton radioBtnPractice;
    TextView txtViewQsPractice;
    TextView txtViewScorePractice;
    String[][] qsArr1 = {
            {"Base of Tongue which is near Uvula touching the mouth roof","ق","ج","ک","ش"},
            {"Portion of Tongue near its base touching the roof of mouth","ط","ج", "ق","ک"},
            {"Tongue touching the center of the mouth roof","ج ش ی","ض","ش","ل"},
            {"Rounded tip of the tongue touching the base of the frontal 6 teeth","ج","ی","ق","ن"},
            {"Tip of the tongue touching the base of the front 2 teeth","ت د ط", "ی ج ق","ل","ج ن" },
            {"Tip of the tongue touching the tip of the frontal 2 teeth","ظ ذ ث","ت د ط","ج ش ی","ی ج ق"},
            {"Tip of the tongue comes between the front top and bottom teeth","ظ ذ ث","ص ز س","ج ن","ج ش ی"},
            {"Bring the vibration to the nose while pronouncing the ending sound of:","ت د","م ن","ز س","ظ ذ"},
            {"Tip of the two upper jaw teeth touches the inner part of the lower lip","ظ","د","س","ف"},
            {"Inner part of the both lips touch each other","ی","ظ","ض" ,"ب"},
            {"Outer part of both lips touch each other:", "ی","ث","م","ض"},
            {"Rounding both lips and not closing the mouth:","ث","م","و","ب"},
            {"End of throat:","أ ہ","م","و","ب"},
            {"Middle of throat","أ ہ","غ خ","ع ح" ,"م و"},
            {"Start of throat","أ ہ","غ خ","ع ح","م و"}};
    String[] ans1 = {"ق","ک","ج ش ی","ن","ت د ط","ظ ذ ث","ص ز س","م ن","ف","ب","م","و","أ ہ","ع ح","غ خ"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        Random rand = new Random();
        randNoPr = rand.nextInt(ans1.length);

        txtViewQsPractice = findViewById(R.id.txtVQsPractice);
        //setting question in text view

        txtViewQsPractice.setText(getQuestion(randNoPr));
        //getting radio group
        radioGroupPractice = findViewById(R.id.radioGroupOptionsPractice);
        //setting each radio button text
        for(int i =0;i<radioGroupPractice.getChildCount();i++){
            ((RadioButton)radioGroupPractice.getChildAt(i)).setText(getOptions(i));
        }
        counterPr = counterPr +1;
        txtViewScorePractice = findViewById(R.id.textViewScorePractice);
        //txtViewScorePractice.setText(String.format("Correct: %s, Wrong: %s", scorePr,counterPr - scorePr -1));
        Button btnNextQ = findViewById(R.id.btnNextQsPractice);
        btnNextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randNoPr = rand.nextInt(ans1.length);
                radioGroupPractice.clearCheck();
                counterPr = counterPr + 1;
                txtViewQsPractice = findViewById(R.id.txtVQsPractice);

                //setting question in text view
                txtViewQsPractice.setText(getQuestion(randNoPr));
                //getting radio group
                radioGroupPractice = findViewById(R.id.radioGroupOptionsPractice);
                //setting each radio button text
                for (int i = 0; i < radioGroupPractice.getChildCount(); i++) {
                    radioBtnPractice = (RadioButton) radioGroupPractice.getChildAt(i);
                    radioBtnPractice.setText(getOptions(i));
                    radioBtnPractice.setTextColor(Color.BLACK);
                    radioBtnPractice.setEnabled(true);
                }
            }
        });

        Button btnEndPr = findViewById(R.id.btnEndPractice);
        btnEndPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void checkButtonPractice(View view){
        int radioId = radioGroupPractice.getCheckedRadioButtonId();
        radioBtnPractice = findViewById(radioId);
        String strAns = radioBtnPractice.getText().toString();
        if (strAns.equals(getCorrectAns(randNoPr))){
            radioBtnPractice.setTextColor(Color.GREEN);
            scorePr = scorePr + 1;
        }else{
            radioBtnPractice.setTextColor(Color.RED);
        }
        counterPr = counterPr + 1;
        for(int i =0;i<radioGroupPractice.getChildCount();i++){
            radioBtnPractice = (RadioButton)radioGroupPractice.getChildAt(i);
            if(!radioBtnPractice.isChecked()){
                radioBtnPractice.setEnabled(false);
            }
        }
    }

    protected String getQuestion(int i ){
        return qsArr1[i][0];
    }
    protected String getOptions(int i ){
        return qsArr1[randNoPr][i+1];
    }
    protected String getCorrectAns(int i ) {
        return ans1[i];
    }

}