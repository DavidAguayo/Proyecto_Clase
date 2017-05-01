package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import com.proyecto.proyecto_clase.adapters.RecetasAdapter;
import com.proyecto.proyecto_clase.models.RecetasLista;

import java.util.ArrayList;
import java.util.List;

public class Recetas extends AppCompatActivity {
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    private List<RecetasLista> recetas_item;
    private RecetasAdapter recetasAdapter;

    String[] nombre = {"Sopa de pescado", "Sopa de ajo"};
    int[] img = {
            R.drawable.r1,
            R.drawable.r2
    };
    String[] elaborar = {
            "Ponemos agua en un recipiente con trozos  y espinas de pescado, cebolla, " +
                    "puerro y zanahoria. Llevamos a ebullición dejando cocer 15 minutos " +
                    "para conseguir un buen caldo. Aparte ponemos a pochar en aceite de oliva " +
                    "la cebolla el puerro y la zanahoria, cuando esté hecho añadimos el tomate, " +
                    "dejándolo cocer por espacio de 10 minutos. A continuación vertimos el " +
                    "caldo, lo trituramos y  pasamos por colador chino. Lo llevamos de nuevo " +
                    "a ebullición y añadimos el pan tostado dejándolo cocer otros 10 minutos. " +
                    "Un minuto antes de retirar del fuego vertimos en la sopa el pescado " +
                    "desmigado.",
            "Cortamos el ajo en filetes, ponemos a calentar el aceite en una cazuela y " +
                    "sin dejar que se dore vertimos el pan tostado cortado en rebanadas y " +
                    "dejamos que absorba el aceite. A continuación, añadimos caldo de carne " +
                    "o en su defecto agua. Dejamos cocer 15 minutos o hasta que se haya " +
                    "desecho bien el pan. Una vez cocinado, y 1 minuto antes de retirar del " +
                    "fuego, añadimos el huevo batido pasteurizado y removemos bien para " +
                    "que no se hagan grumos."
    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);


        drecyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        if(drecyclerView != null){
            drecyclerView.setHasFixedSize(true);
        }

        dLayoutManager = new LinearLayoutManager(this);

        drecyclerView.setLayoutManager(dLayoutManager);

        recetas_item = new ArrayList<>();

        for(int i = 0; i<img.length; i++){
            RecetasLista recetas = new RecetasLista(nombre[i], img[i], elaborar[i]);
            recetas_item.add(recetas);
        }
        recetasAdapter = new RecetasAdapter(recetas_item);
        drecyclerView.setAdapter(recetasAdapter);
        recetasAdapter.notifyDataSetChanged();

    }
}
