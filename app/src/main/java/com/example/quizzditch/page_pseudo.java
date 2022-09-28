package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class page_pseudo extends AppCompatActivity {

    private Button btn_val_pseudo;
    private EditText saisie_pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_pseudo);

        btn_val_pseudo = findViewById(R.id.btn_val_pseudo);
        saisie_pseudo = findViewById(R.id.saisie_pseudo);
    }
}