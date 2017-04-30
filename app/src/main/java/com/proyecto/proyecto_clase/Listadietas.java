package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.proyecto.proyecto_clase.adapters.DietasAdapter;
import com.proyecto.proyecto_clase.models.DietasLista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class Listadietas extends AppCompatActivity {
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    private List<DietasLista> dietas_item;
    private DietasAdapter dietasAdapter;

    String[] nombre = {"Dieta1", "Dieta2"};

    int[] img = {
            R.drawable.d1,
            R.drawable.d2
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dietas);

        Button diet;
        diet = (Button)findViewById(R.id.button3);
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Listadietas.this, Dietas.class);
                startActivity(intent);
            }
        });

        drecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        if(drecyclerView != null){
            drecyclerView.setHasFixedSize(true);
        }

        dLayoutManager = new LinearLayoutManager(this);

        drecyclerView.setLayoutManager(dLayoutManager);

        dietas_item = new ArrayList<>();

        for(int i = 0; i<nombre.length; i++){
            DietasLista dietas = new DietasLista(nombre[i], img[i]);
            dietas_item.add(dietas);
        }
        dietasAdapter = new DietasAdapter(dietas_item);
        drecyclerView.setAdapter(dietasAdapter);
        dietasAdapter.notifyDataSetChanged();

    }
}
