package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainComunEjer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comun_ejer);
        ImageView imageView = (ImageView) findViewById(R.id.imagecomun);
        TextView textview =(TextView) findViewById(R.id.textcomun);
        Intent i = getIntent();
        int FlagId = i.getIntExtra("logo",0);
        String FlagId2 = i.getStringExtra("txt");
        imageView.setImageResource(FlagId);
        textview.setText(FlagId2);

    }
}
