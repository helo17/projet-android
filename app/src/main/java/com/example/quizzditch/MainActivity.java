package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_dem;
    private EditText saisie_pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dem = findViewById(R.id.btn_dem);
        saisie_pseudo = findViewById(R.id.saisie_pseudo);
    }
    public void bnt_demarrer (View v){
        Intent intent = new Intent(v.getContext(), page_pseudo.class);
        startActivity(intent);
    }
}