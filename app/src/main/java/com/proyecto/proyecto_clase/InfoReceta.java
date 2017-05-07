package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoReceta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_receta);

        TextView t1 = (TextView) findViewById(R.id.elaboracion) ;

        Intent i = getIntent();
        String ela = i.getStringExtra("elaborar");
        int imagen = i.getIntExtra("imagen", 0);
        String nombre = i.getStringExtra("nombre");

        t1.setText(ela);


        getSupportActionBar().setTitle(nombre);
    }
}
