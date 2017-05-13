package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

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
                Intent intent = new Intent(MainActivity.this, Listadietas.class);
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
                Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent3);
            }
        });

        //Lo que viene a continuación sirve para incluir el menú en la actividad e indicar las acciones
        //que ejecutan cada opción
        /*@Override
        public boolean onCreateOptionsMenu(Menu mimenu){
            getMenuInflater().inflate(R.menu.menu_en_activity, mimenu);
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
            return super.onOptionsItemSelected(opcion_menu);
        }*/

        //Para ocultar el action bar:
        //getSupportActionBar().hide();
    }
}
