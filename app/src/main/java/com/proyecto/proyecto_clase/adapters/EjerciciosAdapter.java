package com.proyecto.proyecto_clase.adapters;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.snowdream.android.widget.SmartImageView;
import com.proyecto.proyecto_clase.R;
import com.proyecto.proyecto_clase.clases.Dieta;
import com.proyecto.proyecto_clase.clases.Ejercicios;

import java.util.ArrayList;

/**
 * Created by jorge.sanchez on 06/06/2017.
 */

public class EjerciciosAdapter extends RecyclerView.Adapter<EjerciciosAdapter.ViewHolder>{
    ArrayList<Ejercicios> ejerciciosList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreEjercicio;

        public ViewHolder(View v){
            super(v);
            nombreEjercicio=(TextView)v.findViewById(R.id.nombre);
        }
    }
    public EjerciciosAdapter(ArrayList<Ejercicios> ejerciciosList){this.ejerciciosList = ejerciciosList;}

    @Override
    public EjerciciosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ejercicios_item,parent,false);
        EjerciciosAdapter.ViewHolder vh = new EjerciciosAdapter.ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(EjerciciosAdapter.ViewHolder holder, int position) {
      Ejercicios ejercicios = ejerciciosList.get(position);
        holder.nombreEjercicio.setText(String.valueOf(ejercicios.getName()));
    }
    @Override
    public int getItemCount() {
        return ejerciciosList.size();
    }

    //Para introducir la opción de búsqueda:
    public void setFilter(ArrayList<Ejercicios> newList){
        ejerciciosList = new ArrayList<>();
        ejerciciosList.addAll(newList);
        notifyDataSetChanged();
    }
}
