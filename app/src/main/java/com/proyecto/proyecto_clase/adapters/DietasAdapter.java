package com.proyecto.proyecto_clase.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyecto.proyecto_clase.Dietas;
import com.proyecto.proyecto_clase.R;
import com.proyecto.proyecto_clase.models.DietasLista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class DietasAdapter extends RecyclerView.Adapter<DietasAdapter.ViewHolder>{
    ArrayList<DietasLista> dietasList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreDieta;
        public ImageView dietasImg;

        public ViewHolder(View v){
            super(v);
            nombreDieta=(TextView)v.findViewById(R.id.nombre);
            dietasImg=(ImageView)v.findViewById(R.id.dietasimg);
        }
    }

    public DietasAdapter(ArrayList<DietasLista> dietasList){this.dietasList = dietasList;}

    @Override
    public DietasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dietas_item,parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DietasAdapter.ViewHolder holder, int position) {
        DietasLista dietas = dietasList.get(position);
        holder.nombreDieta.setText(String.valueOf(dietas.getNombre()));
        holder.dietasImg.setImageResource(dietas.getImg());
    }

    @Override
    public int getItemCount() {
        return dietasList.size();
    }

    //Para introducir la opción de búsqueda:
    public void setFilter(ArrayList<DietasLista> newList){
        dietasList = new ArrayList<>();
        dietasList.addAll(newList);
        notifyDataSetChanged();
    }
}
