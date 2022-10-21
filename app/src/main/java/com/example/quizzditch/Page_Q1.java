package com.example.quizzditch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
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
                vibrate(5);
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
                vibrate(5);
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
                vibrate(5);
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
                vibrate(5);
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
    @Override
    protected void onStart() {
        super.onStart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "OnStart");
    }

    public void vibrate(long duration_ms) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(duration_ms < 1)
            duration_ms = 1;
        if(v != null && v.hasVibrator()) {
// Attention changement comportement avec API >= 26 (cf doc)
            if(Build.VERSION.SDK_INT >= 26) {
                v.vibrate(VibrationEffect.createOneShot(duration_ms,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else {
                v.vibrate(duration_ms);
            }
        }
// sinon il n’y a pas de mécanisme de vibration
    }
    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onPause page1");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onStop page1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent’s method
        Log.d(MainActivity.TAG, "onDestroy page1");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onRestart page1");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) { //seul Bundle est important
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(MainActivity.TAG, "onSaveInstanceState: page1 ");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.TAG, "onRestoreInstanceState: page1 ");
    }
}