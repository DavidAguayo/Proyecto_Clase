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

    String[] nombre = {"HIPERPROTEICA BLANDA", "Dieta2"};
    int[] img = {
            R.drawable.receta1,
            R.drawable.receta2
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
            RecetasLista recetas = new RecetasLista(nombre[i], img[i]);
            recetas_item.add(recetas);
        }
        recetasAdapter = new RecetasAdapter(recetas_item);
        drecyclerView.setAdapter(recetasAdapter);
        recetasAdapter.notifyDataSetChanged();

    }
}
