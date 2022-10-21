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
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class page_q3 extends AppCompatActivity {

    private Chip chip_r_1_q_4;
    private Chip chip_r_2_q_4;
    private Chip chip_r_3_q_4;
    private Chip chip_r_4_q_4;

    private Button btn_back_p3;
    private Button btn_next_p3;

    private Spinner spinner;

    public int A;
    public int B;
    public int C;
    public int D;
    private String pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_q3);

        chip_r_1_q_4 = findViewById(R.id.chip_r_1_q_4);
        chip_r_2_q_4 = findViewById(R.id.chip_r_2_q_4);
        chip_r_3_q_4 = findViewById(R.id.chip_r_3_q_4);
        chip_r_4_q_4 = findViewById(R.id.chip_r_4_q_4);

        btn_back_p3 = findViewById(R.id.btn_back_p3);
        btn_next_p3 = findViewById(R.id.btn_next_p3);

        spinner = findViewById(R.id.spinner);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null) {
            pseudo = b.getString("pseudo_uti");
            A = b.getInt("A");
            B = b.getInt("B");
            C = b.getInt("C");
            D = b.getInt("D");
        }

        btn_back_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_next_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nbChipChecked() == 1){
                    Intent intent = new Intent(v.getContext(), page_q4.class);
                    score();
                    intent.putExtra("A",A);
                    intent.putExtra("B",B);
                    intent.putExtra("C",C);
                    intent.putExtra("D",D);
                    intent.putExtra("pseudo_uti",pseudo);
                    vibrate(5);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(page_q3.this, "Veuillez saisir une réponse à Q4",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void score() {
        if (chip_r_1_q_4.isChecked()){
            D++;
        }
        else if (chip_r_2_q_4.isChecked()){
            B++;
        }
        else if (chip_r_3_q_4.isChecked()){
            C++;
        }
        else if(chip_r_4_q_4.isChecked()){
            A++;
        }

        if (spinner.getSelectedItemPosition() == 0){
            A++;
        }
        else if (spinner.getSelectedItemPosition() == 1){
            B++;
        }
        else if (spinner.getSelectedItemPosition() == 2){
            C++;
        }
        else{
            D++;
        }
    }

    public int nbChipChecked(){
        int cpt = 0;
        if (chip_r_1_q_4.isChecked()) {
            cpt++;
        }
        if (chip_r_2_q_4.isChecked()){
            cpt++;
        }
        if (chip_r_3_q_4.isChecked()) {
            cpt++;
        }
        if (chip_r_4_q_4.isChecked()){
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
// sinon il n’y a pas de mécanisme de vibration
    }

    @Override
    protected void onStart() {
        super.onStart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "OnStart page 3");
    }

    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onPause page 3");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onStop page 3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent’s method
        Log.d(MainActivity.TAG, "onDestroy page 3");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onRestartpage 3");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) { //seul Bundle est important
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(MainActivity.TAG, "onSaveInstanceState: page 3 ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(MainActivity.TAG, "onRestoreInstanceState: page 3 ");
    }
}