package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_dem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dem = findViewById(R.id.btn_dem);
    }
    public void bnt_demarrer (View v){
        Intent intent = new Intent(v.getContext(), page_pseudo.class);
        startActivity(intent);
    }
}