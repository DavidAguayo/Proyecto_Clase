package com.proyecto.proyecto_clase;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;

public class Alimentos extends AppCompatActivity {
    TextView textView;

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

        //Lo que viene a continuación sirve para avriguar los alimentos que no
        //están seleccionados
        textView = (TextView)findViewById(R.id.prueba) ;
        Switch s1 = (Switch) findViewById(R.id.switch1);
        Boolean resp1 = s1.isChecked();
        if(s1.isChecked()==false){
            textView.setText("Acedera");
        }

        //Para poner el título al action bar:
        getSupportActionBar().setTitle("Ingredientes");
    }
}
