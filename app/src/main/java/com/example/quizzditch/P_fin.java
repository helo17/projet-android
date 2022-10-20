package com.example.quizzditch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button btn_back_fin;
    private Button btn_share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfin);

        text_rep = findViewById(R.id.text_rep);
        aff_pseudo = findViewById(R.id.aff_pseudo);
        img_rep = findViewById(R.id.img_rep);
        btn_back_fin = findViewById(R.id.btn_back_fin);
        btn_share = findViewById(R.id.btn_share);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null){
            pseudo=(String)b.get("pseudo_uti");
            A = Integer.parseInt(b.get("A").toString());
            B = Integer.parseInt(b.get("B").toString());
            C = Integer.parseInt(b.get("C").toString());
            D = Integer.parseInt(b.get("D").toString());


            setTextRep();

            aff_pseudo.setText(pseudo);

            btn_back_fin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }

    }
    public void setTextRep() {
        text_rep.setText(calcul());
    }

    public String calcul(){
        int tab[] = {A,B,C,D};
        OptionalInt val = Arrays.stream(tab).max();

        if (val.getAsInt() == A){
            img_rep.setImageResource(R.drawable.img_serpentard);
            return "Serpentard";
        }
        else if (val.getAsInt() == B){
            img_rep.setImageResource(R.drawable.img_pouf);
            return "Poufsouffle";
        }
        else if (val.getAsInt() == C){
            img_rep.setImageResource(R.drawable.img_gri);
            return "Gryffondor";
        }
        else{
            img_rep.setImageResource(R.drawable.img_ser);
            return "Serdaigle";
        }
    }

    public void envoie (View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Congrats, you are a member of "+ calcul() +" ! Share the app to know in which house your fiends are !");
        startActivity(Intent.createChooser(intent, "share"));
    }


}