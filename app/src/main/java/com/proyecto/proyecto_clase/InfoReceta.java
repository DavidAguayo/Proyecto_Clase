package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoReceta extends AppCompatActivity {
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_receta);

        TextView t1 = (TextView) findViewById(R.id.elaboracion) ;
        ImageView i1 = (ImageView)findViewById(R.id.plato);

        Intent i = getIntent();
        String numero = i.getStringExtra("numero");
        int pos = Integer.parseInt(numero.toString());
        String ela = i.getStringExtra("elaborar");
        int imagen = i.getIntExtra("imagen",pos);
        String nombre = i.getStringExtra("nombre");

        t1.setText(ela);
        i1.setImageResource(imagen);

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle(nombre);

    }
}
