package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.OptionalInt;

public class P_fin extends AppCompatActivity {

    private TextView text_rep;
    private TextView aff_pseudo;
    private String pseudo;
    public int A;
    public int B;
    public int C;
    public int D;

    private ImageView img_rep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfin);

        text_rep = findViewById(R.id.text_rep);
        aff_pseudo = findViewById(R.id.aff_pseudo);
        img_rep = findViewById(R.id.img_rep);


        //extras.getString("D")

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null){
            pseudo=(String)b.get("pseudo_uti");
            A = Integer.parseInt(b.get("A").toString());
            B = Integer.parseInt(b.get("B").toString());
            C = Integer.parseInt(b.get("C").toString());
            D = Integer.parseInt(b.get("D").toString());
            Log.d(MainActivity.TAG, "onCreate: " + (b.get("A").toString()));


            setTextRep();

            aff_pseudo.setText(pseudo);

        }

    }
    public void setTextRep() {
        text_rep.setText(calcul());
    }

    public String calcul(){
        int tab[] = {A,B,C,D};
        OptionalInt val = Arrays.stream(tab).max();
        Log.d(MainActivity.TAG, "calcul: " + tab[0]+tab[1]+tab[2]+tab[3]);
        Log.d(MainActivity.TAG, "calcul: " + A);

        Log.d(MainActivity.TAG, "calcul: " + val.getAsInt());

            if (val.getAsInt() == A){
                return "Serpentard";
            }
            else if (val.getAsInt() == B){
                return "Poufsouffle";
            }
            else if (val.getAsInt() == C){
                return "Gryffondor";
            }
            else{
                return "Serdaigle";
            }
    }



}