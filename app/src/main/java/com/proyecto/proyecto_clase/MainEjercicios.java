package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainEjercicios extends AppCompatActivity {
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;
    private String username;
    private String password;
    Button BEjercicios;
    Button BWorkout;
    Button BRuning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ejercicios);
        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");
        BEjercicios = (Button)findViewById(R.id.BEjercicios);
        BWorkout = (Button)findViewById(R.id.BWorkout);
        BRuning =(Button)findViewById(R.id.BRuning);

        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Ejercicios");
        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        BEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intentEjer = new Intent(MainEjercicios.this, MEjercicios.class);
                intentEjer.putExtra("username", username);
                intentEjer.putExtra("password", password);
                //Iniciamos la nueva actividad
                startActivity(intentEjer);
            }
        });

        BWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intentEjer = new Intent(MainEjercicios.this, Listarutinas.class);
                intentEjer.putExtra("username", username);
                intentEjer.putExtra("password", password);
                //Iniciamos la nueva actividad
                startActivity(intentEjer);
            }
        });
        BRuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intentEjer = new Intent(MainEjercicios.this, MainRunning.class);
                //Iniciamos la nueva actividad
                startActivity(intentEjer);
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_sin_buscador, mimenu);
        //Para introducir la opción de búsqueda;
        MenuItem menuItem = mimenu.findItem(R.id.menu_buscar);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.configuracion){
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        if(id==R.id.info){
            Intent i = new Intent(this, Alimentos.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.rece){
            Intent i = new Intent(this, Recetas.class);
            startActivity(i);
            return true;
        }
        if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
}
