package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

}