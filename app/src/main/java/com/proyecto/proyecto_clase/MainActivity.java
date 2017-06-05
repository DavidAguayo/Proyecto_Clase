package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        Button button2;
        Button login;
        button = (Button)findViewById(R.id.DIETAS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El arraylist es para añadir la opción de quitar los alimentos
                ArrayList<String> datos= new ArrayList<String>();
                Intent intent = new Intent(MainActivity.this, Listadietas.class);
                intent.putExtra("datos",datos);
                startActivity(intent);
            }
        });
        button2 = (Button)findViewById(R.id.EJERCICIOS);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, MainEjercicios.class);
                startActivity(intent2);
            }
        });
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, SalasActivity.class);
                startActivity(intent3);
            }
        });

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("GoodEaTraining");
    }
    //Lo que viene a continuación sirve para incluir el menú en la actividad e indicar las acciones
    //que ejecutan cada opción
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_inicio, mimenu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.configuracion){
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
}
