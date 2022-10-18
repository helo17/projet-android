package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

public class page_q4 extends AppCompatActivity {

    private Button btn_back_p4;
    private Button btn_next_p4;

    private Switch switch_r_1_q_6;
    private Switch switch_r_2_q_6;
    private Switch switch_r_3_q_6;
    private Switch switch_r_4_q_6;

    private RatingBar ratingBar;

    public int A;
    public int B;
    public int C;
    public int D;
    private String pseudo;
    private boolean ok=false;
    private boolean clique=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_q4);

        btn_back_p4 = findViewById(R.id.btn_back_p4);
        btn_next_p4 = findViewById(R.id.btn_next_p4);

        switch_r_1_q_6 = findViewById(R.id.switch_r_1_q_6);
        switch_r_2_q_6 = findViewById(R.id.switch_r_2_q_6);
        switch_r_3_q_6 = findViewById(R.id.switch_r_3_q_6);
        switch_r_4_q_6 = findViewById(R.id.switch_r_4_q_6);

        ratingBar = findViewById(R.id.ratingBar);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null) {
            pseudo = b.getString("pseudo_uti");
            A = b.getInt("A");
            B = b.getInt("B");
            C = b.getInt("C");
            D = b.getInt("D");
        }

        btn_back_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btn_next_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ok=true){
                    Intent intent = new Intent(v.getContext(), P_fin.class);
                    score();
                    intent.putExtra("A",A);
                    intent.putExtra("B",B);
                    intent.putExtra("C",C);
                    intent.putExtra("D",D);
                    intent.putExtra("pseudo_uti",pseudo);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(page_q4.this, "répondez",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void score() {
        if (switch_r_1_q_6.isChecked()) {
            D++;
            ok = true;
        } else if (switch_r_2_q_6.isChecked()) {
            B++;
            ok = true;
        } else if (switch_r_3_q_6.isChecked()) {
            C++;
            ok = true;
        } else if (switch_r_4_q_6.isChecked()) {
            A++;
            ok = true;
        } else {
            ok = false;
        }
    }
}