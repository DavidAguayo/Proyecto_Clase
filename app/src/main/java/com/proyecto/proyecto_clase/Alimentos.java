package com.proyecto.proyecto_clase;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;

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
        textView = (TextView)findViewById(R.id.prueba) ;
        Switch s1 = (Switch) findViewById(R.id.switch1);
        Boolean resp1 = s1.isChecked();
        Cambios(resp1);

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Ingredientes");
    }
    public void Cambios(Boolean resp1){
        if(resp1==true){
            textView.setText("Acedera");
        }
    }
}

/*Para hacer lo de quitar las dietas que contengan alimentos desactivados
hay que comprobar si un switch está desactivado para introducirlo todo
en un String y pasarlo al OnCreate de Listadietas.java y comprobarlo
antes de cargar el recyclerview*/