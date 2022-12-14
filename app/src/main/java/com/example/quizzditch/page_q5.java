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
import android.widget.CheckBox;
import android.widget.Toast;

public class page_q5 extends AppCompatActivity {

    private Button btn_back_p5;
    private Button btn_next_p5;

    private CheckBox checkBox_q_8_r_1;
    private CheckBox checkBox_q_8_r_2;
    private CheckBox checkBox_q_8_r_3;
    private CheckBox checkBox_q_8_r_4;

    public int A;
    public int B;
    public int C;
    public int D;
    private String pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_q5);

        btn_back_p5 = findViewById(R.id.btn_back_p5);
        btn_next_p5 = findViewById(R.id.btn_next_p5);

        checkBox_q_8_r_1 = findViewById(R.id.checkBox_q_8_r_1);
        checkBox_q_8_r_2 = findViewById(R.id.checkBox_q_8_r_2);
        checkBox_q_8_r_3 = findViewById(R.id.checkBox_q_8_r_3);
        checkBox_q_8_r_4 = findViewById(R.id.checkBox_q_8_r_4);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null) {
            pseudo = b.getString("pseudo_uti");
            A = b.getInt("A");
            B = b.getInt("B");
            C = b.getInt("C");
            D = b.getInt("D");
        }

        btn_back_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_next_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nbCChecked() != 0){
                    Intent intent = new Intent(v.getContext(), P_fin.class);
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
                    Toast.makeText(page_q5.this, "Veuillez saisir au moins une r??ponse ?? Q8",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void score() {
        if (checkBox_q_8_r_1.isChecked()) {
            A++;
        } if (checkBox_q_8_r_2.isChecked()) {
            B++;
        } if (checkBox_q_8_r_3.isChecked()) {
            C++;
        } if (checkBox_q_8_r_4.isChecked()) {
            D++;
        }
    }

    public int nbCChecked(){
        int cpt = 0;
        if (checkBox_q_8_r_1.isChecked()) {
            cpt++;
        }
        if (checkBox_q_8_r_2.isChecked()){
            cpt++;
        }
        if (checkBox_q_8_r_3.isChecked()) {
            cpt++;
        }
        if (checkBox_q_8_r_4.isChecked()){
            cpt++;
        }
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
        Log.d(MainActivity.TAG, "OnStart page 5");
    }

    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onPause page 5");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onStop page 5");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent???s method
        Log.d(MainActivity.TAG, "onDestroy page 5");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onRestart page 5");
    }

    @Override
    protected void onResume() {
        super.onResume(); // ALWAYS call first the parent???s method!
        Log.d(MainActivity.TAG, "onResume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) { //seul Bundle est important
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(MainActivity.TAG, "onSaveInstanceState: page 5");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.TAG, "onRestoreInstanceState: page 5");
    }

}