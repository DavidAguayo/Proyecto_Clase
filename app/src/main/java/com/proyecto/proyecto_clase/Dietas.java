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

import java.util.ArrayList;

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
        String d1 = i.getStringExtra("desayunos1");
        String d2 = i.getStringExtra("desayunos2");
        String d3 = i.getStringExtra("desayunos3");
        String d4 = i.getStringExtra("desayunos4");
        String d5 = i.getStringExtra("desayunos5");
        String d6 = i.getStringExtra("desayunos6");
        String d7 = i.getStringExtra("desayunos7");
        String c1 = i.getStringExtra("comidas1");
        String c2 = i.getStringExtra("comidas2");
        String c3 = i.getStringExtra("comidas3");
        String c4 = i.getStringExtra("comidas4");
        String c5 = i.getStringExtra("comidas5");
        String c6 = i.getStringExtra("comidas6");
        String c7 = i.getStringExtra("comidas7");
        String m1 = i.getStringExtra("meriendas1");
        String m2 = i.getStringExtra("meriendas2");
        String m3 = i.getStringExtra("meriendas3");
        String m4 = i.getStringExtra("meriendas4");
        String m5 = i.getStringExtra("meriendas5");
        String m6 = i.getStringExtra("meriendas6");
        String m7 = i.getStringExtra("meriendas7");
        String c_1 = i.getStringExtra("cenas1");
        String c_2 = i.getStringExtra("cenas2");
        String c_3 = i.getStringExtra("cenas3");
        String c_4 = i.getStringExtra("cenas4");
        String c_5 = i.getStringExtra("cenas5");
        String c_6 = i.getStringExtra("cenas6");
        String c_7 = i.getStringExtra("cenas7");



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

        //Cambiamos los textos con la información del intent:
        des1.setText(d1);
        des2.setText(d2);
        des3.setText(d3);
        des4.setText(d4);
        des5.setText(d5);
        des6.setText(d6);
        des7.setText(d7);
        co1.setText(c1);
        co2.setText(c2);
        co3.setText(c3);
        co4.setText(c4);
        co5.setText(c5);
        co6.setText(c6);
        co7.setText(c7);
        me1.setText(m1);
        me2.setText(m2);
        me3.setText(m3);
        me4.setText(m4);
        me5.setText(m5);
        me6.setText(m6);
        me7.setText(m7);
        ce1.setText(c_1);
        ce2.setText(c_2);
        ce3.setText(c_3);
        ce4.setText(c_4);
        ce5.setText(c_5);
        ce6.setText(c_6);
        ce7.setText(c_7);

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
            //El arraylist es para añadir la opción de quitar los alimentos
            ArrayList<String> datos= new ArrayList<String>();
            Intent i = new Intent(this, Listadietas.class);
            i.putExtra("datos",datos);
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
