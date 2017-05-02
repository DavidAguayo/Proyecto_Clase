package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.proyecto.proyecto_clase.adapters.DietasAdapter;
import com.proyecto.proyecto_clase.models.DietasLista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class Listadietas extends AppCompatActivity {
    //Variables pra lo del recycler view
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    private List<DietasLista> dietas_item;
    private DietasAdapter dietasAdapter;

    String[] nombre = {"HIPERPROTEICA BLANDA", "Dieta2"};

    int[] img = {
            R.drawable.d1,
            R.drawable.d2
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dietas);

        //Lo que viene a continuación sirve para hacer lo del recycler view
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

        //Lo que viene a continuación sirve para dirigir a otra actividad al pulsar sobre
        //un cardview
        drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Listadietas.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent intent = new Intent(Listadietas.this, Dietas.class);
                    startActivity(intent);
                }
            }
        }));

        //Para poner el título al action bar:
        getSupportActionBar().setTitle("Lista de dietas");
    }


    //Este método nos dirige a otra actividad
    public void ejecutar_info(View view){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }
    //Lo que viene a continuación sirve para incluir el menú en la actividad e indicar las acciones
    //que ejecutan cada opción
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_activity, mimenu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.configuracion){
            ejecutar_info(null);
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
    }
}
