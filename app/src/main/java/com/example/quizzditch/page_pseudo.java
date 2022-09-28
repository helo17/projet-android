package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class page_pseudo extends AppCompatActivity {

    private Button btn_val_pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_pseudo);

        btn_val_pseudo = findViewById(R.id.btn_val_pseudo);
    }
}