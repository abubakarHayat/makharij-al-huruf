package com.abubakar.makhrijal_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ExamActivity extends AppCompatActivity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

    }
}