package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainRun extends AppCompatActivity {
    private Toolbar toolbar;
    Button startf, pausaf, stopf,btdatos,botonlamada;
    Chronometer cronometro2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_run);
        startf=(Button)findViewById(R.id.rstart);
        pausaf=(Button)findViewById(R.id.rpausa);
        stopf=(Button)findViewById(R.id.rfinalizar);
        cronometro2 =(Chronometer)findViewById(R.id.chronometer2);
        startf.setEnabled(true);
        pausaf.setEnabled(false);
        stopf.setEnabled(false);
        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Running");
        btdatos =(Button)findViewById(R.id.dato);
        btdatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent inte = new Intent(MainRun.this, MainDatos.class);
                Bundle b = new Bundle();
                b.putString("tiempo", cronometro2.getText().toString());
                inte.putExtras(b);
                startActivity(inte);
            }
        });
        botonlamada=(Button)findViewById(R.id.btmaps);
        botonlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                startActivity(launchIntent);
            }
        });
    }
    public void empezado(View vista){
        startf.setEnabled(false);
        pausaf.setEnabled(true);
        stopf.setEnabled(true);
        int stoppedMilliseconds = 0;

        String chronoText = cronometro2.getText().toString();
        String array[] = chronoText.split(":");
        if (array.length == 2) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
        } else if (array.length == 3) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 + Integer.parseInt(array[1]) * 60 * 1000
                    + Integer.parseInt(array[2]) * 1000;
        }

        cronometro2.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
        cronometro2.start();


    }
    public void pausado(View vista){
        startf.setEnabled(true);
        pausaf.setEnabled(false);
        stopf.setEnabled(true);
        cronometro2.stop();

    }
    public void finalizado(View vista){
        startf.setEnabled(true);
        pausaf.setEnabled(false);
        stopf.setEnabled(false);
        cronometro2.setBase(SystemClock.elapsedRealtime());
        cronometro2.stop();

    }
}