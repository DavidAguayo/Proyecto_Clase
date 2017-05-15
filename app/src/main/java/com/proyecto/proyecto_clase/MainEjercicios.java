package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainEjercicios extends AppCompatActivity {
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    Button BEjercicios;
    Button BWorkout;
    Button BRuning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ejercicios);
        BEjercicios = (Button)findViewById(R.id.BEjercicios);
       // BWorkout = (Button)findViewById(R.id.BWorkout);
        // BRuning =(Button)findViewById(R.id.BRuning);

        BEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intentEjer = new Intent(MainEjercicios.this, MEjercicios.class);
                //Iniciamos la nueva actividad
                startActivity(intentEjer);
            }
        });
        /*
        BWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intentEjer = new Intent(MainEjercicios.this, MainWorkout.class);
                //Iniciamos la nueva actividad
                startActivity(intentEjer);
            }
        });
        BRuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intentEjer = new Intent(MainEjercicios.this, MainRuning.class);
                //Iniciamos la nueva actividad
                startActivity(intentEjer);
            }
        });*/

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para ocultar el toolbar:
        getSupportActionBar().setTitle("Tipos de ejercicios");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
