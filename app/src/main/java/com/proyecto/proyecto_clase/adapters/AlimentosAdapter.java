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
import android.widget.TextView;

import com.proyecto.proyecto_clase.R;
import com.proyecto.proyecto_clase.clases.Alimento;

import java.util.ArrayList;

import static android.view.View.TEXT_ALIGNMENT_CENTER;


/**
 * Created by Jorge on 10/06/2017.
 */

public class AlimentosAdapter extends RecyclerView.Adapter<AlimentosAdapter.ViewHolder>{
    ArrayList<Alimento> comidasList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreAlimento;
        public ViewHolder(View v){
            super(v);
            nombreAlimento=(TextView)v.findViewById(R.id.nombre);
        }
    }
    public AlimentosAdapter(ArrayList<Alimento> comidasList){this.comidasList = comidasList;}

    @Override
    public AlimentosAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
       final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alimento_item,parent,false);
        AlimentosAdapter.ViewHolder vh = new AlimentosAdapter.ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(AlimentosAdapter.ViewHolder holder, int position) {
            Alimento comida = comidasList.get(position);
            holder.nombreAlimento.setText(String.valueOf(comida.getName()));
            if(position==0){
                holder.nombreAlimento.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                holder.nombreAlimento.setTextSize(18);
            }
    }
    @Override
    public int getItemCount() {
        return comidasList.size();
    }

}
