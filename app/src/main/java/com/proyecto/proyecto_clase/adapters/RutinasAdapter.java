package com.proyecto.proyecto_clase.adapters;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.snowdream.android.widget.SmartImageView;
import com.proyecto.proyecto_clase.R;
import com.proyecto.proyecto_clase.clases.Rutina;

import java.util.ArrayList;

/**
 * Created by jorge.sanchez on 06/06/2017.
 */


public class RutinasAdapter extends RecyclerView.Adapter<RutinasAdapter.ViewHolder>{
    ArrayList<Rutina> rutinasList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreRutina;
        public SmartImageView rutinaImg;
        public CardView cardRutina;

        public ViewHolder(View v){
            super(v);
            nombreRutina=(TextView)v.findViewById(R.id.nombre);
            rutinaImg= (SmartImageView)v.findViewById(R.id.rutinasimg);
            cardRutina = (CardView)v.findViewById(R.id.card_view);
        }
    }

    public RutinasAdapter(ArrayList<Rutina> rutinasList){this.rutinasList = rutinasList;}

    @Override
    public RutinasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rutinas_item,parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RutinasAdapter.ViewHolder holder, int position) {
        Rutina rutinas = rutinasList.get(position);

        String ruta = rutinas.getImagen().split("/")[3];
        ruta = "http://80.29.167.245:8520/imagenes/" + ruta;

        Rect rect = new Rect(holder.rutinaImg.getLeft(), holder.rutinaImg.getTop(), holder.rutinaImg.getRight(), holder.rutinaImg.getBottom());
        holder.nombreRutina.setText(String.valueOf(rutinas.getName()));
        holder.rutinaImg.setImageUrl(ruta, rect);
        switch (rutinas.getDificultad()){
            case 1 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#00ff00"));
            break;
            case 2 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#47ff00"));
            break;
            case 3 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#84ff00"));
            break;
            case 4 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#b2ff00"));
            break;
            case 5 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#f2ff00"));
            break;
            case 6 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#ffc700"));
            break;
            case 7 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#ff9700"));
            break;
            case 8 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#ff6600"));
            break;
            case 9 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#ff3600"));
            break;
            case 10 :
                holder.cardRutina.setCardBackgroundColor(Color.parseColor("#ff3600"));
            break;
            default:
            break;
        }

    }

    @Override
    public int getItemCount() {
        return rutinasList.size();
    }

    //Para introducir la opción de búsqueda:
    public void setFilter(ArrayList<Rutina> newList){
        rutinasList = new ArrayList<>();
        rutinasList.addAll(newList);
        notifyDataSetChanged();
    }
}
