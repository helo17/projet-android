package com.example.quizzditch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;

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
    private Button btn_restart;

    public Set<String> houseHistory;

    // Listes des permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfin);

        text_rep = findViewById(R.id.text_rep);
        aff_pseudo = findViewById(R.id.aff_pseudo);
        img_rep = findViewById(R.id.img_rep);
        btn_back_fin = findViewById(R.id.btn_back_fin);
        btn_share = findViewById(R.id.btn_share);
        btn_restart = findViewById(R.id.btn_restart);


        vibrate(10);

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

            btn_restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

            Log.d(MainActivity.TAG, "A = "+A);
            Log.d(MainActivity.TAG, "B = "+B);
            Log.d(MainActivity.TAG, "C = "+C);
            Log.d(MainActivity.TAG, "D = "+D);

            reload_historic();
            houseHistory.add(calcul());
            display_historic();
            write_historic_in_file();
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

    public void reload_historic() {
        SharedPreferences sharedPref =  getSharedPreferences("scoreHistory", Context.MODE_MULTI_PROCESS);
        houseHistory = sharedPref.getStringSet("scoreHistory", new TreeSet<String>());
    }

    public void display_historic() {
        Log.d(MainActivity.TAG, "Historique (" + (new Date()) + ") size= " + houseHistory.size() + ":  ");
        for (String item : houseHistory) {
            Log.d(MainActivity.TAG, "\t- " + item);
        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Vérifie si nous avons les droits d'écriture
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // Aïe, il faut les demander à l'utilisateur
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void write_historic_in_file() {
        verifyStoragePermissions(P_fin.this);
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File fileout = new File(folder, "Historic_Quizz.txt");
        try (FileOutputStream fos = new FileOutputStream(fileout)) {
            PrintStream ps = new PrintStream(fos);
            reload_historic();
            ps.println("Start␣of␣my␣historic");
// TODO: YOU MUST COMPLETE HERE
            ps.println(pseudo +" : " + calcul());
            ps.close();
        } catch (FileNotFoundException e) {
            Log.e(MainActivity.TAG,"File␣not␣found",e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(MainActivity.TAG,"Error␣I/O",e);
        }
    }






    public void vibrate(long duration_ms) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(duration_ms < 1)
            duration_ms = 1;
        if(v != null && v.hasVibrator()) {
// Attention changement comportement avec API >= 26 (cf doc)
            if(Build.VERSION.SDK_INT >= 26) {
                v.vibrate(VibrationEffect.createOneShot(duration_ms,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else {
                v.vibrate(duration_ms);
            }
        }
// sinon il n’y a pas de mécanisme de vibration
    }

    @Override
    protected void onStart() {
        super.onStart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "OnStart page fin");
    }

    @Override
    protected void onPause() {
        super.onPause(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onPause page fin");
    }

    @Override
    protected void onStop() {
        super.onStop(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onStop page fin");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // ALWAYS call first the parent’s method
        Log.d(MainActivity.TAG, "onDestroy page fin");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onRestart page fin");
    }

    @Override
    protected void onResume() {
        super.onResume(); // ALWAYS call first the parent’s method!
        Log.d(MainActivity.TAG, "onResume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) { //seul Bundle est important
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(MainActivity.TAG, "onSaveInstanceState: page fin ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.TAG, "onRestoreInstanceState: page fin ");
    }


}