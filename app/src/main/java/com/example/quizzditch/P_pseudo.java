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

public class P_pseudo extends AppCompatActivity {

    private Button btn_validate;
    private Button btn_back_pp;
    private EditText saisie_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppseudo);

        btn_validate = findViewById(R.id.btn_validate);
        btn_back_pp = findViewById(R.id.btn_back_pp);
        saisie_p = findViewById(R.id.saisie_p);

        btn_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Page_Q1.class);
                intent.putExtra("pseudo_uti",saisie_p.getText().toString());
                Log.d(MainActivity.TAG, "onClick: " + saisie_p.getText().toString());
                startActivity(intent);
            }
        });
        btn_back_pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "OnStart page pseudo");
    }

    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onPause page pseudo");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onStop page pseudo");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent’s method
        Log.d(MainActivity.TAG, "onDestroy page pseudo");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onRestart page pseudo");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivity.TAG, "onResume page pseudo");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) { //seul Bundle est important
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(MainActivity.TAG, "onSaveInstanceState: page pseudo");

        outState.putString("pseudo_uti",saisie_p.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.TAG, "onRestoreInstanceState: page1 ");

        if(savedInstanceState.containsKey("pseudo_uti")) {  //Toujours vérifier si existe !!
            String pseudo = savedInstanceState.getString("pseudo_uti");
            this.saisie_p.setText(pseudo);
        }
    }
}