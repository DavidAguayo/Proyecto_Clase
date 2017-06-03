package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class Alimentos extends AppCompatActivity {
    TextView textView;

    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);
        //Lo que viene a continuación es para las pestañas(tabs)
        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Verduras",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Frutas",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
        //Hasta aquí es lo de las tabs

        //Lo que viene a continuación sirve para averiguar los alimentos que no
        //están seleccionados
        Button guardar = (Button) findViewById(R.id.guardarInfo);
        textView = (TextView)findViewById(R.id.prueba) ;
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprobar();
            }
        });

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Ingredientes");
    }

    public void Comprobar(){
        ArrayList<String> datos= new ArrayList<String>();
        int cnt=0;
        Switch s1 = (Switch) findViewById(R.id.switch1);
        Switch s2 = (Switch) findViewById(R.id.switch2);
        if(!s1.isChecked()){
            datos.add(String.valueOf(s1.getText()));
            cnt++;
        }
        if(!s2.isChecked()){
            datos.add(String.valueOf(s2.getText()));
            cnt++;
        }
        Intent intent = new Intent(this, Listadietas.class);
        intent.putExtra("datos",datos);
        startActivity(intent);
    }
}

/*Para hacer lo de quitar las dietas que contengan alimentos desactivados
hay que comprobar si un switch está desactivado para introducirlo todo
en un String y pasarlo al OnCreate de Listadietas.java y comprobarlo
antes de cargar el recyclerview*/