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
import android.widget.ImageButton;
import android.widget.TextView;

public class page_q2 extends AppCompatActivity {

    private String pseudo;
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;

    private Button btn_back;

    public int A;
    public int B;
    public int C;
    public int D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_q2);

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        btn_back = findViewById(R.id.btn_back);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null) {
            pseudo = b.getString("pseudo_uti");
            A = b.getInt("A");
            B = b.getInt("B");
            C = b.getInt("C");
            D = b.getInt("D");
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(MainActivity.TAG, "onClick: b1 " );
            Intent intent = new Intent(v.getContext(), page_q3.class);
            A++;
            intent.putExtra("A",A);
            intent.putExtra("B",B);
            intent.putExtra("C",C);
            intent.putExtra("D",D);
            intent.putExtra("pseudo_uti",pseudo);
            vibrate(5);
            startActivity(intent);
        }
    });
    imageButton2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(MainActivity.TAG, "onClick: b2 " );
            Intent intent = new Intent(v.getContext(), page_q3.class);
            B++;
            intent.putExtra("A",A);
            intent.putExtra("B",B);
            intent.putExtra("C",C);
            intent.putExtra("D",D);
            intent.putExtra("pseudo_uti",pseudo);
            vibrate(5);
            startActivity(intent);
        }
    });
    imageButton3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(MainActivity.TAG, "onClick: b3 " );
            Intent intent = new Intent(v.getContext(), page_q3.class);
            C++;
            intent.putExtra("A",A);
            intent.putExtra("B",B);
            intent.putExtra("C",C);
            intent.putExtra("D",D);
            intent.putExtra("pseudo_uti",pseudo);
            vibrate(5);
            startActivity(intent);
        }
    });
    imageButton4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(MainActivity.TAG, "onClick: b4 " );
            Intent intent = new Intent(v.getContext(), page_q3.class);
            D++;
            intent.putExtra("A",A);
            intent.putExtra("B",B);
            intent.putExtra("C",C);
            intent.putExtra("D",D);
            intent.putExtra("pseudo_uti",pseudo);
            vibrate(5);
            startActivity(intent);
        }
    });

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
        Log.d(MainActivity.TAG, "OnStart page2");
    }

    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onPause page2");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onStop page2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent’s method
        Log.d(MainActivity.TAG, "onDestroy page2");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onRestart page2");
    }

    @Override
    protected void onResume() {
        super.onResume(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onResume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) { //seul Bundle est important
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(MainActivity.TAG, "onSaveInstanceState: page2");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.TAG, "onRestoreInstanceState: page2");
    }
}