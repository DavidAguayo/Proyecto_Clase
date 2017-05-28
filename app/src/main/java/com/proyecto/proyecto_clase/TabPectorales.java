package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.Button;

public class TabPectorales extends Fragment{
    Button boton1, boton2,boton3,boton4,boton5,boton6;


    private int[] LogoId = new int[]{R.drawable.uno_pec, R.drawable.dos_pec,
            R.drawable.tres_pec,R.drawable.cuatro_pec,
            R.drawable.cinco_pec, R.drawable.seis_pec};
    private String[] textos = new String[]{
            "Acostado en una banca plana, sostenga una barra con pesas con los brazos extendidos.\nInicie el descenso de la carga por medio de la flexión de ambos miembros superiores.\nCuando la barra haya tocado su pecho, pero sin dejarla apoyado en el mismo, inicie el ascenso de la barra hasta su posición inicial.",
            "Acostado en una banca plana, sostenga una mancuerna con cada mano y extienda los brazos como se observa en la imagen.\nSepare los brazos sin doblarlos hasta que queden en linea recta.\nPor medio de la contraccion de ambos pectorales acerque ambas mancuernas sin doblar los brazos.",
            "Acostado boca abajo con las palmas de las manos apoyadas sobre el suelo y separadas a la misma distancia de los hombros.\nInicie el desplazamiento hacia arriba hasta la extensión completa de ambos brazos.\nLuego inicie el descenso hasta que su cara quede cerca del suelo. Durante todo el ejercicio manenga las piernas extendidas.",
            "Acostado de forma perpendicular sobre una banco plano y apoyando únicamente la mitad superior del tronco.\nSostenga uno de los extremos de una mancuerna con ambas manos.\nDesplace la mancuerna hacia atrás hasta que quede por encima de su cabeza y luego regrese a la posición inicial.",
            "Acostado en una banca plana, sostenga una mancuerna en cada mano y extienda los brazos hacia arriba.\nInicie la flexión de ambos brazos llevando las mancuernas a ambos lados.\nEleve las mancuernas por medio de la extension de ambos brazos.",
            "Coloque sus manos en las barras para dominadas y eleve su cuerpo como se observa en la imagen.\nDescienda por medio de la flexión de sus brazos hasta el menor nivel posible.\nLuego eleve su cuerpo al extender de forma completa sus brazos."};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frej_pectorales, container, false);
        boton1 =(Button)rootView.findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[0]);
                i.putExtra("txt",textos[0]);
                startActivity(i);
            }
        });
        boton2 =(Button)rootView.findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[1]);
                i.putExtra("txt",textos[1]);
                startActivity(i);
            }
        });
        boton3 =(Button)rootView.findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[2]);
                i.putExtra("txt",textos[2]);
                startActivity(i);
            }
        });
        boton4 =(Button)rootView.findViewById(R.id.button4);
        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[3]);
                i.putExtra("txt",textos[3]);
                startActivity(i);
            }
        });
        boton5 =(Button)rootView.findViewById(R.id.button5);
        boton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[4]);
                i.putExtra("txt",textos[4]);
                startActivity(i);
            }
        });
        boton6 =(Button)rootView.findViewById(R.id.button6);
        boton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[5]);
                i.putExtra("txt",textos[5]);
                startActivity(i);
            }
        });

        return rootView;
    }
}