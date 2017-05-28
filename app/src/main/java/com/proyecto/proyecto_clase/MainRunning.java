package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainRunning extends AppCompatActivity {
    private Toolbar toolbar;
    Button btsprint, btcalent, btrun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_running);
        btsprint =(Button)findViewById(R.id.sprint);
        btsprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent inte = new Intent(MainRunning.this, MainSprint.class);
                //Iniciamos la nueva actividad
                startActivity(inte);
            }
        });
        btcalent =(Button)findViewById(R.id.calen);
        btcalent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent inte = new Intent(MainRunning.this, MainCalentamiento.class);
                //Iniciamos la nueva actividad
                startActivity(inte);
            }
        });
        btrun =(Button)findViewById(R.id.run);
        btrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent inte = new Intent(MainRunning.this, MainRun.class);
                //Iniciamos la nueva actividad
                startActivity(inte);
            }
        });
        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Running");
    }
}
