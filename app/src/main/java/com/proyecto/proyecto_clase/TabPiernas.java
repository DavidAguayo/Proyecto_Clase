package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.Button;

public class TabPiernas extends Fragment{
    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;
    Button boton5;
    Button boton6;
    Button boton7;
    Button boton8;
    Button boton9;



    private int[] LogoId = new int[]{R.drawable.uno_pie, R.drawable.dos_pie,
            R.drawable.tres_pie,R.drawable.cuatro_pie,
            R.drawable.cinco_pie, R.drawable.seis_pie,R.drawable.siete_pie,
            R.drawable.ocho_pie,R.drawable.nueve_pie};
    private String[] textos = new String[]{
            "De pie, sostenga una barra con pesas sobre sus hombros.\nDescienda el cuerpo por medio de la flexión de ambas rodillas, manteniendo la espalda derecha.\nAscienda a la posición inicial.",
            "De pie, sostenga una barra con pesas sobre sus hombros.\nDescienda el cuerpo por medio de la flexión de ambas rodillas hasta que sus glúteos toquen la superficie de una banca o silla.\nAscienda inmediatamente a la posición inicial. Recuerde mantener la espalda derecha durante todo el ejercicio.",
            "De pie, sostenga una barra con pesas con el agarre hacia adentro y con los pies separados a la anchura de sus hombros.\nInclinese hacia adelante sin doblar las rodillas, llevándo las caderas hacia atrás y sintiendo la presión en los talones.\nRegrese a la posición inicial manteniendo las piernas en extensión",
            "Acostado (a) boca abajo sosteniendo una mancuerna entre sus pies.\nExtienda las piernas hacia atrás y luego flexionelas hacia adelante.",
            "De pie, sostenga una barra con pesas sobre sus hombros y con los pies separados a la anchura de sus hombros.\nRealice un paso largo hacia adelante con una de sus piernas, manteniendo la espalda derecha.\nRegrese a la posición inicial.\nRealice el mismo movimiento con la otra pierna.",
            "Sentado (a) en el carro romano, coloque sus pies sobre la plataforma separados a nivel de la caderas o ligeramente por afuera de las mismas.\nDescienda lo maximo posible por medio de la flexión de ambas piernas.\nEmpuje el peso por medio de la extensión de ambas piernas.",
            "Sentado (a), coloque el tercio anterior de ambos pies sobre un soporte con una altura suficiente para una flexión adecuada de los talones.\nAcomode una carga sobre sus muslos, la cual puede ser una barra con pesas o mancuerna.\nEleve y descienda los talones lo maximo posible y de forma continua.",
            "De pie, sostenga una barra con pesas sobre sus hombros.\nColoque el tercio anterior de sus pies sobre un soporte a una altura de unos 10 cm.\nDescienda ambos talones lo máximo posible.\nEleve su cuerpo utilizando unicamente sus pies. No doble sus rodillas durante todo el ejercicio.",
            "De pie, coloque el tercio anterior de uno de sus pies sobre un soporte con una altura suficiente para una flexión adecuada del talón.\nSostenga una mancuerna con la mano del mismo lado de la pantorrilla que va a entrenar y con la otra mano apoyese en la pared para guardar el equilibrio.\nEleve y descienda el talon lo maximo posible y de forma continua. Al finalizar cambie de pie para el entranamiento de la otra pantorrilla."
            };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frej_piernas, container, false);
        boton1 =(Button)rootView.findViewById(R.id.btpiernas1);
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[0]);
                i.putExtra("txt",textos[0]);
                startActivity(i);
            }
        });
        boton2 =(Button)rootView.findViewById(R.id.btpiernas2);
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[1]);
                i.putExtra("txt",textos[1]);
                startActivity(i);
            }
        });
        boton3 =(Button)rootView.findViewById(R.id.btpiernas3);
        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[2]);
                i.putExtra("txt",textos[2]);
                startActivity(i);
            }
        });
        boton4 =(Button)rootView.findViewById(R.id.btpiernas4);
        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[3]);
                i.putExtra("txt",textos[3]);
                startActivity(i);
            }
        });
        boton5 =(Button)rootView.findViewById(R.id.btpiernas5);
        boton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[4]);
                i.putExtra("txt",textos[4]);
                startActivity(i);
            }
        });
        boton6 =(Button)rootView.findViewById(R.id.btpiernas6);
        boton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[5]);
                i.putExtra("txt",textos[5]);
                startActivity(i);
            }
        });
        boton7 =(Button)rootView.findViewById(R.id.btpiernas7);
        boton7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[6]);
                i.putExtra("txt",textos[6]);
                startActivity(i);
            }
        });
        boton8 =(Button)rootView.findViewById(R.id.btpiernas8);
        boton8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[7]);
                i.putExtra("txt",textos[7]);
                startActivity(i);
            }
        });
        boton9 =(Button)rootView.findViewById(R.id.btpiernas9);
        boton9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i= new Intent(getActivity(), MainComunEjer.class);
                i.putExtra("logo",LogoId[8]);
                i.putExtra("txt",textos[8]);
                startActivity(i);
            }
        });

        return rootView;

    }


}