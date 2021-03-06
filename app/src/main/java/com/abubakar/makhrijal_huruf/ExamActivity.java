package com.abubakar.makhrijal_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ExamActivity extends AppCompatActivity {

    int counter =0;
    int score = 0;
    RadioGroup radioGroup;
    RadioButton radioBtn;
    TextView txtViewQs;
    String[][] qsArr = {
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
    String[] ans = {"ق","ک","ج ش ی","ن","ت د ط","ظ ذ ث","ص ز س","م ن","ف","ب","م","و","أ ہ","ع ح","غ خ"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        txtViewQs = findViewById(R.id.textViewQuestion);
        //setting question in text view
        txtViewQs.setText(getQuestion(counter));
        //getting radio group
        radioGroup = findViewById(R.id.radioGroupOptions);
        //setting each radio button text
        for(int i =0;i<radioGroup.getChildCount();i++){
            ((RadioButton)radioGroup.getChildAt(i)).setText(getOptions(i));
        }
        counter = counter +1;
        Button btnNextQ = findViewById(R.id.btnNextQs);
        btnNextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter == (qsArr.length-1)) {
                    btnNextQ.setText("Finish Exam");
                    counter = counter +1;
                }else if(counter == qsArr.length){
                    Intent finishExamIntent = new Intent(ExamActivity.this,FinishExamActivity.class);
                    finishExamIntent.putExtra("score",+score+ " out of " + qsArr.length);
                    startActivity(finishExamIntent);
                }else{
                    radioGroup.clearCheck();
                    //Log.d("ExamActivity","Counter: "+ counter);
                    counter = counter + 1;
                    //Log.d("ExamActivity","Counter: "+ counter);
                    txtViewQs = findViewById(R.id.textViewQuestion);

                    //setting question in text view
                    txtViewQs.setText(getQuestion(counter));
                    //getting radio group
                    radioGroup = findViewById(R.id.radioGroupOptions);
                    //setting each radio button text
                    for (int i = 0; i < radioGroup.getChildCount(); i++) {
                        radioBtn = (RadioButton) radioGroup.getChildAt(i);
                        radioBtn.setText(getOptions(i));
                        radioBtn.setTextColor(Color.BLACK);
                        radioBtn.setEnabled(true);
                    }
                }

            }
        });

    }

    public void checkButton(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioBtn = findViewById(radioId);
        String strAns = radioBtn.getText().toString();
        if (strAns.equals(getCorrectAns(counter))){
            radioBtn.setTextColor(Color.GREEN);
            score+=1;
        }else{
            radioBtn.setTextColor(Color.RED);
        }
        for(int i =0;i<radioGroup.getChildCount();i++){
            radioBtn = (RadioButton)radioGroup.getChildAt(i);
            if(!radioBtn.isChecked()){
                radioBtn.setEnabled(false);
            }
        }
    }

    protected String getQuestion(int i ){
        return qsArr[i][0];
    }
    protected String getOptions(int i ){
        return qsArr[counter][i+1];
    }
    protected String getCorrectAns(int i ){
        return ans[i];
    }
}