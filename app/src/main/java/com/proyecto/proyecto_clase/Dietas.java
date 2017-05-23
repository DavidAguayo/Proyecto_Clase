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

public class Dietas   extends  ActionBarActivity{
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietas);

        //Variables para poder colocar las imágenes que obtenemos en el intent
        //en los imageview correspondientes
        //ImageView im1 = (ImageView)findViewById(R.id.imageView3);
        //Para recoger la información que hemos pasado por los intent
        Intent i = getIntent();
        int imagen = i.getIntExtra("imagen", 0);
        String nombre = i.getStringExtra("nombre");

        //Lo que viene a continuación es para las pestañas(tabs)
        /*Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("LUNES",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("MARTES",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("MIERCOLES",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("JUEVES",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("VIERNES",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab6");
        spec.setContent(R.id.tab6);
        spec.setIndicator("SABADO",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab7");
        spec.setContent(R.id.tab7);
        spec.setIndicator("DOMINGO",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);*/
        //Hasta aquí es lo de las tabs

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al tool bar:
        getSupportActionBar().setTitle(nombre);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Para poner las imágenes que hemos obtenido del intent
        //im1.setImageResource(imagen);
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
