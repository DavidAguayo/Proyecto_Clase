package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class Dietas   extends  ActionBarActivity{
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietas);

        //Para recoger la información que hemos pasado por los intent
        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String infor = i.getStringExtra("info");

        //Para usar la información recogida del intent
        TextView informacion = (TextView)findViewById(R.id.info);
        informacion.setText(infor);
        TextView des1 = (TextView)findViewById(R.id.de1);
        TextView des2 = (TextView)findViewById(R.id.de2);
        TextView des3 = (TextView)findViewById(R.id.de3);
        TextView des4 = (TextView)findViewById(R.id.de4);
        TextView des5 = (TextView)findViewById(R.id.de5);
        TextView des6 = (TextView)findViewById(R.id.de6);
        TextView des7 = (TextView)findViewById(R.id.de7);
        TextView co1 = (TextView)findViewById(R.id.co1);
        TextView co2 = (TextView)findViewById(R.id.co2);
        TextView co3 = (TextView)findViewById(R.id.co3);
        TextView co4 = (TextView)findViewById(R.id.co4);
        TextView co5 = (TextView)findViewById(R.id.co5);
        TextView co6 = (TextView)findViewById(R.id.co6);
        TextView co7 = (TextView)findViewById(R.id.co7);
        TextView me1 = (TextView)findViewById(R.id.me1);
        TextView me2 = (TextView)findViewById(R.id.me2);
        TextView me3 = (TextView)findViewById(R.id.me3);
        TextView me4 = (TextView)findViewById(R.id.me4);
        TextView me5 = (TextView)findViewById(R.id.me5);
        TextView me6 = (TextView)findViewById(R.id.me6);
        TextView me7 = (TextView)findViewById(R.id.me7);
        TextView ce1 = (TextView)findViewById(R.id.ce1);
        TextView ce2 = (TextView)findViewById(R.id.ce2);
        TextView ce3 = (TextView)findViewById(R.id.ce3);
        TextView ce4 = (TextView)findViewById(R.id.ce4);
        TextView ce5 = (TextView)findViewById(R.id.ce5);
        TextView ce6 = (TextView)findViewById(R.id.ce6);
        TextView ce7 = (TextView)findViewById(R.id.ce7);

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al tool bar:
        getSupportActionBar().setTitle(nombre);
    }

    //Lo que viene a continuación sirve para incluir el menú en la actividad e indicar las acciones
    //que ejecutan cada opción
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_sin_buscador, mimenu);
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
        if(id==R.id.atras){
            Intent i = new Intent(this, Listadietas.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);

        /*switch (opcion_menu.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(opcion_menu);
        }*/
    }
}
