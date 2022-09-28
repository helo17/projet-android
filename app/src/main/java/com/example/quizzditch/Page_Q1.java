package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Page_Q1 extends AppCompatActivity {

    private Button btn_q1_r1;
    private Button btn_q1_r2;
    private Button btn_q1_r3;
    private Button btn_q1_r4;

    private RadioButton radioButton_q2_r1;
    private RadioButton radioButton_q2_r2;
    private RadioButton radioButton_q2_r3;
    private RadioButton radioButton_q2_r4;

    private Button btn_back_q1;
    private Button btn_next_q1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_q1);

        btn_q1_r1 = findViewById(R.id.btn_q1_r1);
        btn_q1_r2 = findViewById(R.id.btn_q1_r2);
        btn_q1_r3 = findViewById(R.id.btn_q1_r3);
        btn_q1_r4 = findViewById(R.id.btn_q1_r4);

        radioButton_q2_r1 = findViewById(R.id.radioButton_q2_r1);
        radioButton_q2_r2 = findViewById(R.id.radioButton_q2_r2);
        radioButton_q2_r3 = findViewById(R.id.radioButton_q2_r3);
        radioButton_q2_r4 = findViewById(R.id.radioButton_q2_r4);

        btn_back_q1 = findViewById(R.id.btn_back_q1);
        btn_next_q1 = findViewById(R.id.btn_next_q1);
    }
    public void action_end(View v){
        finish();
    }
}