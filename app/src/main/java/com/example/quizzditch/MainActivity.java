package com.example.quizzditch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Quizz";
    private Button btn_dem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_dem = findViewById(R.id.btn_dem);

        btn_dem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), P_pseudo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent’s method
        Log.d(MainActivity.TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onRestart");
    }

}