package com.proyecto.proyecto_clase.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyecto.proyecto_clase.R;
import com.proyecto.proyecto_clase.models.RecetasLista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.ViewHolder>{
    private List<RecetasLista> recetasList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreReceta;
        public ImageView recetasImg;
        public TextView elaboracion;

        public ViewHolder(View v){
            super(v);
            nombreReceta=(TextView)v.findViewById(R.id.nomrec);
            recetasImg=(ImageView)v.findViewById(R.id.recetasimg);
            elaboracion=(TextView)v.findViewById(R.id.elabora);
        }
    }

    public RecetasAdapter(List<RecetasLista> recetasList){this.recetasList = recetasList;}

    @Override
    public RecetasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recetas_item,parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecetasAdapter.ViewHolder holder, int position) {
        RecetasLista recetas = recetasList.get(position);
        holder.nombreReceta.setText(String.valueOf(recetas.getNombre()));
        holder.recetasImg.setImageResource(recetas.getImg());
        holder.elaboracion.setText(String.valueOf(recetas.getElaborar()));
    }

    @Override
    public int getItemCount() {
        return recetasList.size();
    }

    //Para introducir la opción de búsqueda:
    public void setFilter(ArrayList<RecetasLista> newList){
        recetasList = new ArrayList<>();
        recetasList.addAll(newList);
        notifyDataSetChanged();
    }
}

