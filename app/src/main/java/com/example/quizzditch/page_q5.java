package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                if (nbCChecked() == 1){
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
                    Toast.makeText(page_q5.this, "Veuillez saisir une réponse à Q8",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void score() {
        if (checkBox_q_8_r_1.isChecked()) {
            A++;
        } else if (checkBox_q_8_r_2.isChecked()) {
            B++;
        } else if (checkBox_q_8_r_3.isChecked()) {
            C++;
        } else if (checkBox_q_8_r_4.isChecked()) {
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

}