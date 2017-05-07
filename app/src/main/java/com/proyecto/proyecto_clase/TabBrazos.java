package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.Button;

public class TabBrazos extends Fragment{
    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;
    Button boton5;
    Button boton6;
    Button boton7;
    Button boton8;
    Button boton9;
    Button boton10;
    Button boton11;
    Button boton12;
    Button boton13;
    Button boton14;

    private int[] LogoId = new int[]{R.drawable.uno_bra, R.drawable.dos_bra,
            R.drawable.tres_bra,R.drawable.cuatro_bra,
            R.drawable.cinco_bra, R.drawable.seis_bra,R.drawable.siete_bra,
            R.drawable.ocho_bra,R.drawable.nueve_bra,R.drawable.diez_bra, R.drawable.once_bra,R.drawable.doce_bra,
            R.drawable.trece_bra,R.drawable.catorce_bra};
    private String[] textos = new String[]{
            "Sentado (a), sostenga una mancuerna en cada mano.\nFlexione ambos brazos al mismo tiempo con desplazamiento exclusivo de los antebrazos.\nExtienda los brazos a su posición inicial. Recuerde mantener la espalda derecha durante todo el ejercicio.",
            "Acostado (a) en una banca inclinada y apoyando su pecho y abdomen. Sostenga una mancuerna en cada mano con las palmas de sus manos hacia adelante.\nFlexione ambos brazos con desplazamiento de los antebrazos, manteniendo los brazos fijos.\nDescienda ambas mancuernas hasta la completa extensión de los brazos.",
            "Sostenga una mancuerna con una de sus manos y apoye su brazo sobre la almohadilla del predicador.\nDescienda la mancuerna hasta la completa extensión del brazo.\nFlexione el brazo hasta la posición inicial.",
            "Sentado (a), sostenga una mancuerna con una de sus manos y apoye la otra mano en su muslo.\nDescienda la mancuerna con desplazamiento solo del antebrazo hasta la extensión completa del brazo.\nLuego flexione el brazo para elevar la carga.",
            "De pie, sostenga una barra con las manos colocadas a una separación ligeramente mayor que la anchura de sus hombros, con las palmas hacia adelante.\nFlexione ambos brazos sin impulsarse con el cuerpo.\nDescienda la barra de forma lenta. Mantenga la espalda derecha durante todo el ejercicio.",
            "Sostenga una barra con las manos colocadas a una separación igual que la anchura de sus hombros, con las palmas hacia adentro.\nExtienda ambos brazos para descender la barra.\nAscienda la carga por medio de la flexión de sus brazos.",
            "Sostengase de una barra horizontal alta con las palmas de las manos hacia atrás, quedando colgado con sus manos.\nEleve su cuerpo por medio de la flexión de ambos brazos.\nLuego descienda su cuerpo por medio de la extensión controlada de ambos brazos.",
            "Sentado (a), sostenga el extremo de una mancuerna entre sus manos y colóquela por atrás de su cabeza\nEleve la mancuerna hasta la extensión total de ambos brazos pero con movimiento exclusivo de los antebrazos.\nDescienda la mancuerna hasta la posicion inicial.",
            "Acostado (a) en una banca plana y sosteniendo una mancuerna con su mano derecha. Con su mano izquierda sostenga su brazo así como se observa en la imagen.\nDescienda la mancuerna en dirección a su cara, teniendo cuidado de no lastimarse\nLuego eleve la mancuerna hasta la extensión completa del brazo.",
            "Acostado (a) en una banca plana y sosteniendo una mancuerna con su mano derecha. El antebrazo izquierdo le servirá de apoyo, colocado como se observa en la imagen.\nFlexione el brazo hacia atrás.\nLuego eleve la mancuerna con desplazamiento exclusivo del antebrazo.",
            "Acostado en una banca plana, sostenga una barra como se observa en la imagen.\nDescienda la barra en dirección a su cabeza con movimiento exclusivo de sus antebrazos, mantiendo los brazos fijos.Descienda la barra en dirección a su cabeza con movimiento exclusivo de sus antebrazos, mantiendo los brazos fijos.\nEleve la barra hasta la completa extensión de sus brazos. Este es uno de los mejores ejercicios de masa muscular para brazos.",
            "Acostado en una banca plana, sostenga una barra con los brazos extendidos y colocando sus manos a una distancia cercana entre si \nFlexione ambos brazos para descender la barra.\nAscienda la barra a su posición inicial.",
            "Sentado, con los antebrazos apoyados sobre sus muslos. Sostenga una barra con las palmas de sus manos hacia arriba (supinación).\nDescienda la barra lo máximo posible con movimiento únicamente de sus muñecas, sin despegar los antebrazos de sus muslos.\nEleve la barra a la posición inicial.",
            "Sentado, con los antebrazos apoyados sobre sus muslos. Sostenga una barra con las palmas de sus manos hacia abajo (pronación).\nEleve la barra lo máximo posible con movimiento únicamente de sus muñecas, sin despegar los antebrazos de sus muslos.\nDescienda la barra a la posición inicial."};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frej_brazos, container, false);
        boton1 =(Button)rootView.findViewById(R.id.btbrazos1);
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[0]);
                i.putExtra("txt",textos[0]);
                startActivity(i);
            }
        });
        boton2 =(Button)rootView.findViewById(R.id.btbrazos2);
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[1]);
                i.putExtra("txt",textos[1]);
                startActivity(i);
            }
        });
        boton3 =(Button)rootView.findViewById(R.id.btbrazos3);
        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[2]);
                i.putExtra("txt",textos[2]);
                startActivity(i);
            }
        });
        boton4 =(Button)rootView.findViewById(R.id.btbrazos4);
        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[3]);
                i.putExtra("txt",textos[3]);
                startActivity(i);
            }
        });
        boton5 =(Button)rootView.findViewById(R.id.btbrazos5);
        boton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[4]);
                i.putExtra("txt",textos[4]);
                startActivity(i);
            }
        });
        boton6 =(Button)rootView.findViewById(R.id.btbrazos6);
        boton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[5]);
                i.putExtra("txt",textos[5]);
                startActivity(i);
            }
        });
        boton7 =(Button)rootView.findViewById(R.id.btbrazos7);
        boton7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[6]);
                i.putExtra("txt",textos[6]);
                startActivity(i);
            }
        });
        boton8 =(Button)rootView.findViewById(R.id.btbrazos8);
        boton8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[7]);
                i.putExtra("txt",textos[7]);
                startActivity(i);
            }
        });
        boton9 =(Button)rootView.findViewById(R.id.btbrazos9);
        boton9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[8]);
                i.putExtra("txt",textos[8]);
                startActivity(i);
            }
        });
        boton10 =(Button)rootView.findViewById(R.id.btbrazos10);
        boton10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[9]);
                i.putExtra("txt",textos[9]);
                startActivity(i);
            }
        });
        boton11 =(Button)rootView.findViewById(R.id.btbrazos11);
        boton11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[10]);
                i.putExtra("txt",textos[10]);
                startActivity(i);
            }
        });
        boton12 =(Button)rootView.findViewById(R.id.btbrazos12);
        boton12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[11]);
                i.putExtra("txt",textos[11]);
                startActivity(i);
            }
        });
        boton13 =(Button)rootView.findViewById(R.id.btbrazos13);
        boton13.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[12]);
                i.putExtra("txt",textos[12]);
                startActivity(i);
            }
        });
        boton14 =(Button)rootView.findViewById(R.id.btbrazos14);
        boton14.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[13]);
                i.putExtra("txt",textos[13]);
                startActivity(i);
            }
        });

        return rootView;
    }
}