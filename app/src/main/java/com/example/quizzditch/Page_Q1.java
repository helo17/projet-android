package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    public int A = 0;
    public int B = 0;
    public int C = 0;
    public int D = 0;

    private Button btn_back_q1;

    private String pseudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_q1);

        Log.d(MainActivity.TAG, "onCreate debut " );

        btn_q1_r1 = findViewById(R.id.btn_q1_r1);
        btn_q1_r2 = findViewById(R.id.btn_q1_r2);
        btn_q1_r3 = findViewById(R.id.btn_q1_r3);
        btn_q1_r4 = findViewById(R.id.btn_q1_r4);

        radioButton_q2_r1 = findViewById(R.id.radioButton_q2_r1);
        radioButton_q2_r2 = findViewById(R.id.radioButton_q2_r2);
        radioButton_q2_r3 = findViewById(R.id.radioButton_q2_r3);
        radioButton_q2_r4 = findViewById(R.id.radioButton_q2_r4);

        btn_back_q1 = findViewById(R.id.btn_back_q1);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null) {
            Log.d(MainActivity.TAG, "onCreate: est ce null");
            pseudo = b.getString("pseudo_uti");
        }
        Log.d(MainActivity.TAG, "onCreate: " + pseudo);

        btn_back_q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_q1_r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivity.TAG, "onClick: b1 " );
                Intent intent = new Intent(v.getContext(), page_q2.class);
                A++;
                score();
                intent.putExtra("A",A);
                intent.putExtra("B",B);
                intent.putExtra("C",C);
                intent.putExtra("D",D);
                intent.putExtra("pseudo_uti",pseudo);
                startActivity(intent);
            }
        });

        btn_q1_r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivity.TAG, "onClick: b2 " );
                Intent intent = new Intent(v.getContext(), page_q2.class);
                B++;
                score();
                intent.putExtra("A",A);
                intent.putExtra("B",B);
                intent.putExtra("C",C);
                intent.putExtra("D",D);
                intent.putExtra("pseudo_uti",pseudo);
                startActivity(intent);
            }
        });

        btn_q1_r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivity.TAG, "onClick: b3 " );
                Intent intent = new Intent(v.getContext(), page_q2.class);
                C++;
                score();
                intent.putExtra("A",A);
                intent.putExtra("B",B);
                intent.putExtra("C",C);
                intent.putExtra("D",D);
                intent.putExtra("pseudo_uti",pseudo);
                startActivity(intent);
            }
        });

        btn_q1_r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), page_q2.class);
                D++;
                Log.d(MainActivity.TAG, "onClick: D " );
                score();
                intent.putExtra("A",A);
                intent.putExtra("B",B);
                intent.putExtra("C",C);
                intent.putExtra("D",D);
                Log.d(MainActivity.TAG, "onClick: test " +D);
                intent.putExtra("pseudo_uti",pseudo);
                startActivity(intent);
            }
        });
    }
    public void score() {
        if (radioButton_q2_r1.isChecked()){
            A++;
        }
        else if (radioButton_q2_r2.isChecked()){
            B++;
        }
        else if (radioButton_q2_r3.isChecked()){
            C++;
        }
        else if (radioButton_q2_r4.isChecked()){
            D++;
        }
    }
}