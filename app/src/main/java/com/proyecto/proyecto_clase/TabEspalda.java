package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.Button;

public class TabEspalda extends Fragment{
    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;
    Button boton5;
    Button boton6;
    Button boton7;
    Button boton8;

    private int[] LogoId = new int[]{R.drawable.uno_esp, R.drawable.dos_esp,
            R.drawable.tres_esp,R.drawable.cuatro_esp,
            R.drawable.cinco_esp, R.drawable.seis_esp,R.drawable.siete_esp,
            R.drawable.ocho_esp};
    private String[] textos = new String[]{
            "Sentado (a) en el equipo de poleas, sostenga la barra con los brazos extendidos.\nTire de la barra hasta que la misma toque o se acerque a la parte posterior del cuello, manteniendo la espalda derecha.\nRegrese a la posición inicial con desplazamiento controlado, hasta la completa extensión de ambos brazos.",
            "Sentado (a) en el equipo de poleas con ligera inclinación hacia atras, sostenga la barra con los brazos extendidos.\nJale la barra hasta que la misma toque o se acerque a su pecho, manteniendo la espalda sin doblar.\nRegrese a la posición inicial con desplazamiento controlado hasta la completa extensión de ambos brazos, manteniendo el mismo grado de inclinación.",
            "Sentado (a) en el equipo para remo, coloque sus manos en las agarraderas con los brazos extendidos.\nFlexione ambos brazos hasta que las muñecas esten alineadas con el pecho.\nRegrese a la posición inicial con desplazamiento controlado, hasta la completa extensión de ambos brazos.",
            "De pie, con los pies separados a la misma distancia que los hombros.\nSostenga una barra con pesas con las manos colocadas a una distancia mayor que la de los hombros y las palmas hacia abajo. Flexione ligeramente las rodillas.\nExtienda ambos brazos hacia adelante con ligera tendencia descendente.\nLuego flexione ambos brazos y acerque la barra al pecho con ligero desplazamiento ascendente.",
            "De pie, agarre una barra con pesas con las manos colocadas a una distancia similar a los hombros con las palmas hacia atras.\nEleve la barra en linea recta hacia el mentón y acerquela lo mas posible a éste.\nInicie el descenso por medio de la extensión de ambos brazos siempre en linea recta.",
            "Cuelgese de una barra para dominadas con las manos a una anchura ligeramente mayor que la de los hombros y con las palmas hacia adelante.\nFlexione ambos brazos para elevar todo su cuerpo sin impulsarse con las piernas, hasta que su cabeza o parte de la misma se encuentre por arriba de la barra.\nDescienda su cuerpo de forma controlada.",
            "Acostado apoyando su pecho sobre una banca inclinada y sosteniendo una mancuerna en cada mano.\nSepare los brazos hacia los lados.\nDescienda los brazos de forma controlada.",
            "Estando de pie, sostenga una mancuerna en cada mano.\nFlexione el tronco hacia uno de sus lados descendiendo lo maximo posible pero sin doblar sus rodillas.\nLuego regrese a la posicion inicial.\nCuando finalice las repeticiones de un lado, siga con el otro lado para completar una serie."};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frej_espalda, container, false);
        boton1 =(Button)rootView.findViewById(R.id.btespalda1);
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[0]);
                i.putExtra("txt",textos[0]);
                startActivity(i);
            }
        });
        boton2 =(Button)rootView.findViewById(R.id.btespalda2);
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[1]);
                i.putExtra("txt",textos[1]);
                startActivity(i);
            }
        });
        boton3 =(Button)rootView.findViewById(R.id.btespalda3);
        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[2]);
                i.putExtra("txt",textos[2]);
                startActivity(i);
            }
        });
        boton4 =(Button)rootView.findViewById(R.id.btespalda4);
        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[3]);
                i.putExtra("txt",textos[3]);
                startActivity(i);
            }
        });
        boton5 =(Button)rootView.findViewById(R.id.btespalda5);
        boton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[4]);
                i.putExtra("txt",textos[4]);
                startActivity(i);
            }
        });
        boton6 =(Button)rootView.findViewById(R.id.btespalda6);
        boton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[5]);
                i.putExtra("txt",textos[5]);
                startActivity(i);
            }
        });
        boton7 =(Button)rootView.findViewById(R.id.btespalda7);
        boton7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[6]);
                i.putExtra("txt",textos[6]);
                startActivity(i);
            }
        });
        boton8 =(Button)rootView.findViewById(R.id.btespalda8);
        boton8.setOnClickListener(new View.OnClickListener(){
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
