package com.proyecto.proyecto_clase.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Switch;
import android.widget.TextView;

import com.proyecto.proyecto_clase.R;
import com.proyecto.proyecto_clase.clases.Alimento;
import com.proyecto.proyecto_clase.clases.Dieta;

import java.util.ArrayList;

import static android.view.View.TEXT_ALIGNMENT_CENTER;


/**
 * Created by Jorge on 10/06/2017.
 */

public class IngredientesAdapter extends RecyclerView.Adapter<IngredientesAdapter.ViewHolder>{
    ArrayList<Alimento> alimentosList;



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreAlimento;
        public Switch aSwitch;
        public ViewHolder(View v){
            super(v);
            nombreAlimento=(TextView)v.findViewById(R.id.nombre);
            aSwitch=(Switch)v.findViewById(R.id.activado);
        }
    }
    public IngredientesAdapter(ArrayList<Alimento> alimentosList){this.alimentosList = alimentosList;}

    @Override
    public IngredientesAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alimentos_item,parent,false);
        IngredientesAdapter.ViewHolder vh = new IngredientesAdapter.ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(IngredientesAdapter.ViewHolder holder, int position) {
        Alimento comida = alimentosList.get(position);
        holder.nombreAlimento.setText(String.valueOf(comida.getName()));
        if(position==0){
            holder.nombreAlimento.setTextAlignment(TEXT_ALIGNMENT_CENTER);
            holder.nombreAlimento.setTextSize(18);
        }
        if(Boolean.valueOf(comida.getDescripcion().equals("Activado")==true)){
            holder.aSwitch.setChecked(true);
        }
        if(Boolean.valueOf(comida.getDescripcion().equals("Desactivado")==true)){
            holder.aSwitch.setChecked(false);
        }
    }
    @Override
    public int getItemCount() {
        return alimentosList.size();
    }
    //Para introducir la opción de búsqueda:
    public void setFilter(ArrayList<Alimento> newList){
        alimentosList = new ArrayList<>();
        alimentosList.addAll(newList);
        notifyDataSetChanged();
    }
}
