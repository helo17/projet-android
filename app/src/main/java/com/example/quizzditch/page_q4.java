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
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

public class page_q4 extends AppCompatActivity {

    private Button btn_back_p4;
    private Button btn_next_p4;

    private Switch switch_r_1_q_6;
    private Switch switch_r_2_q_6;
    private Switch switch_r_3_q_6;
    private Switch switch_r_4_q_6;

    private RatingBar ratingBar;

    public int A;
    public int B;
    public int C;
    public int D;
    private String pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_q4);

        btn_back_p4 = findViewById(R.id.btn_back_p4);
        btn_next_p4 = findViewById(R.id.btn_next_p4);

        switch_r_1_q_6 = findViewById(R.id.switch_r_1_q_6);
        switch_r_2_q_6 = findViewById(R.id.switch_r_2_q_6);
        switch_r_3_q_6 = findViewById(R.id.switch_r_3_q_6);
        switch_r_4_q_6 = findViewById(R.id.switch_r_4_q_6);

        ratingBar = findViewById(R.id.ratingBar);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null) {
            pseudo = b.getString("pseudo_uti");
            A = b.getInt("A");
            B = b.getInt("B");
            C = b.getInt("C");
            D = b.getInt("D");
        }

        btn_back_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btn_next_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ratingBar.getRating() == 0){
                    Toast.makeText(page_q4.this, "R??pondez ?? Q7",Toast.LENGTH_SHORT).show();
                }
                else if (nbSwitchChecked() != 1){
                    Toast.makeText(page_q4.this, "Donnez une r??ponse ?? Q6",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(v.getContext(), page_q5.class);
                    score();
                    intent.putExtra("A",A);
                    intent.putExtra("B",B);
                    intent.putExtra("C",C);
                    intent.putExtra("D",D);
                    intent.putExtra("pseudo_uti",pseudo);
                    vibrate(5);
                    startActivity(intent);
                }
            }
        });
    }

    public void score() {
        if (switch_r_1_q_6.isChecked()) {
            D++;
        } else if (switch_r_2_q_6.isChecked()) {
            B++;
        } else if (switch_r_3_q_6.isChecked()) {
            C++;
        } else if (switch_r_4_q_6.isChecked()) {
            A++;
        }

        if (ratingBar.getRating() <= 1.0){
            A++;
        }
        else if (ratingBar.getRating() <= 2.0){
            B++;
        }else if (ratingBar.getRating() <= 3.0){
            C++;
        }else if (ratingBar.getRating() <= 4.0){
            D++;
        }
    }

    public int nbSwitchChecked(){
        int cpt = 0;
        if (switch_r_1_q_6.isChecked()) {
            cpt++;
        }
        if (switch_r_2_q_6.isChecked()){
            cpt++;
        }
        if (switch_r_3_q_6.isChecked()) {
            cpt++;
        }
        if (switch_r_4_q_6.isChecked()){
            cpt++;
        }
        Log.d(MainActivity.TAG, "nbChipChecked: " + cpt);
        return cpt;
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
// sinon il n???y a pas de m??canisme de vibration
    }

    @Override
    protected void onStart() {
        super.onStart(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "OnStart page 4");
    }

    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onPause page 4");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onStop page 4");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent???s method
        Log.d(MainActivity.TAG, "onDestroy page 4");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onRestart page 4");
    }

    @Override
    protected void onResume() {
        super.onResume(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onResume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) { //seul Bundle est important
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(MainActivity.TAG, "onSaveInstanceState: page 4 ");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.TAG, "onRestoreInstanceState: page 4 ");

    }

}