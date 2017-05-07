package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.Button;

public class TabPectorales extends Fragment{
    Button boton6;
    Button boton7;
    Button boton8;
    Button boton9;

    private int[] LogoId = new int[]{R.drawable.uno_abd, R.drawable.dos_abd,
            R.drawable.tres_abd,R.drawable.cuatro_abd,
            R.drawable.cinco_abd, R.drawable.seis_abd,R.drawable.siete_abd,
            R.drawable.ocho_abd};
    private String[] textos = new String[]{"Este es el primer texto, solo es una prueba cuando ya tenga todas las imagenes las pondre bien ",
            "este es otro texto, es la seguna prueba","cwienv h reuuevh ue uhv uu vuehvu kekh ui",
            "Este es el primer texto, solo es una prueba cuando ya tenga todas las imagenes las pondre bien "};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frej_pectorales, container, false);
        boton6 =(Button)rootView.findViewById(R.id.button6);
        boton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[0]);
                i.putExtra("txt",textos[0]);
                startActivity(i);
            }
        });
        boton7 =(Button)rootView.findViewById(R.id.button7);
        boton7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[1]);
                i.putExtra("txt",textos[1]);
                startActivity(i);
            }
        });
        boton8 =(Button)rootView.findViewById(R.id.button8);
        boton8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[2]);
                i.putExtra("txt",textos[2]);
                startActivity(i);
            }
        });
        boton9 =(Button)rootView.findViewById(R.id.button9);
        boton9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[3]);
                i.putExtra("txt",textos[3]);
                startActivity(i);
            }
        });

        return rootView;
    }
}