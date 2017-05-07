package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.Button;

public class TabAbdomen extends Fragment{
    Button boton6;
    Button boton7;
    Button boton8;
    Button boton9;
    Button boton10;
    Button boton11;
    Button boton12;
    Button boton13;

    private int[] LogoId = new int[]{R.drawable.uno_abd, R.drawable.dos_abd,
            R.drawable.tres_abd,R.drawable.cuatro_abd,
            R.drawable.cinco_abd, R.drawable.seis_abd,R.drawable.siete_abd,
            R.drawable.ocho_abd};
    private String[] textos = new String[]{
            "Acuestese sobre una banca, coloque ambas manos sosteniendo su cabeza.\nEleve la mitad superior del tronco por medio de la contraccion de sus abdominales.\nDescienda el tronco de forma controlada.",
            "Acostado (a) sobre una banca declinada y con los brazos entrecruzados sobre el pecho.\nEleve todo el tronco por medio de la contraccion de sus abdominales, hasta aproximadamente 45 grados, manteniendo la espalda derecha. \nDescienda el tronco de forma controlada.",
            "Sentado (a) con la espalda ligeramente inclinada hacia atrás y las piernas extendidas.\nInicie la flexion de ambas rodillas acercando sus muslos al abdomen.\nExtienda las piernas a la posición inicial.",
            "Acostado (a), con ambas manos sujetando el extremo de la banca.\nEleve ambas piernas sin doblarlas.\nDescienda las piernas de forma controlada.",
            "De pie, sostenga una mancuerna a cada lado del cuerpo con la espalda derecha.\nInicie la flexion del tronco hacia uno de los lados, hasta llegar lo más abajo posible pero sin flexionar las rodillas.\nLuego flexione el tronco al lado contrario y así sucesivamente.",
            "Acostado (a), con las piernas flexionadas como en la imagen.\nInicie el ejercicio con la extensión de ambas piernas hasta la posición horizontal.\nLuego inicie la flexión de las piernas hasta la posición inicial.",
            "Acostado (a) en una banca declinada.\nEleve el tronco con rotación hacia uno de los lados.\nLuego descienda el tronco hasta la posición inicial e inmediatamente despues realice el mismo movimiento al lado contrario.",
            "Acostado (a), con los brazos y piernas extendidos.\nToque la punta de sus pies con sus dedos, por medio de la flexión del tronco.\nRegrese a la posición inicial manteniendo la espalda sin doblar durante todo el ejercicio."};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frej_abdomen, container, false);
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
        boton10 =(Button)rootView.findViewById(R.id.button10);
        boton10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[4]);
                i.putExtra("txt",textos[4]);
                startActivity(i);
            }
        });
        boton11 =(Button)rootView.findViewById(R.id.button11);
        boton11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[5]);
                i.putExtra("txt",textos[5]);
                startActivity(i);
            }
        });
        boton12 =(Button)rootView.findViewById(R.id.button12);
        boton12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[6]);
                i.putExtra("txt",textos[6]);
                startActivity(i);
            }
        });
        boton13 =(Button)rootView.findViewById(R.id.button13);
        boton13.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[7]);
                i.putExtra("txt",textos[7]);
                startActivity(i);
            }
        });

        return rootView;

    }
}