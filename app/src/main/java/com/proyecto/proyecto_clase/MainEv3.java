package com.proyecto.proyecto_clase;

import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainEv3 extends AppCompatActivity {
    Button start, btcontador, btcontamenos;
    TextView txtcuenta, txtmedio,txttop,txtpreparados;
    public int cnt=0, cnt2=0;
    public CountDownTimer timer;
    public LinearLayout fondo;
    public String prueba;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ev3);
        start=(Button)findViewById(R.id.startev3);
        btcontador=(Button)findViewById(R.id.contador);
        btcontamenos=(Button)findViewById(R.id.contadormenos);
        txtcuenta=(TextView)findViewById(R.id.cuenta);
        txtmedio=(TextView)findViewById(R.id.textodistaytiem);
        txttop=(TextView)findViewById(R.id.corredesca);
        txtpreparados=(TextView)findViewById(R.id.prepa);
        fondo= (LinearLayout)findViewById(R.id.fondolayoutev3);
        btcontador.setEnabled(false);
        btcontamenos.setEnabled(false);
        btcontador.setVisibility(View.INVISIBLE);
        btcontamenos.setVisibility(View.INVISIBLE);
        txtcuenta.setVisibility(View.INVISIBLE);
        txtmedio.setVisibility(View.INVISIBLE);
        txttop.setVisibility(View.INVISIBLE);
        txtpreparados.setVisibility(View.INVISIBLE);

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Ejercicios de velocidad 3");
    }
    public void empezar(View vista){
        start.setEnabled(false);
        btcontador.setEnabled(true);
        btcontamenos.setEnabled(true);
        start.setVisibility(View.INVISIBLE);
        txtcuenta.setVisibility(View.VISIBLE);
        txtmedio.setVisibility(View.VISIBLE);
        txttop.setVisibility(View.VISIBLE);
        txtpreparados.setVisibility(View.VISIBLE);
        btcontador.setVisibility(View.VISIBLE);
        btcontamenos.setVisibility(View.VISIBLE);
        txttop.setText("Corre!!!");
        txtmedio.setText("10 M");
        txtcuenta.setText("00");
        btcontamenos.setEnabled(false);
    }

    public void metodosum(View vista){
        cnt++;
        if (cnt==3) {
            btcontador.setEnabled(false);
            btcontamenos.setEnabled(false);
        }
        if (cnt==3&&prueba=="40 M") {
            btcontador.setEnabled(false);
            btcontamenos.setEnabled(false);
            btcontador.setVisibility(View.INVISIBLE);
            btcontamenos.setVisibility(View.INVISIBLE);
            txtcuenta.setVisibility(View.INVISIBLE);
            txttop.setVisibility(View.INVISIBLE);
            txtpreparados.setVisibility(View.INVISIBLE);
            txtmedio.setText("Buen Trabajo!!");
        }
        if (cnt==1) {
            btcontamenos.setEnabled(true);
        }
        metodocontador();
        if(cnt==3&&prueba!="40 M"){
            cnt2++;
            timer = new CountDownTimer(6000, 1000) {

                public void onTick(long millisUntilFinished) {
                    txttop.setText("Descansa");
                    fondo.setBackgroundResource(R.drawable.descanso);
                    txtmedio.setText("" + millisUntilFinished / 1000);
                }
                public void onFinish() {
                    txttop.setText("Corre!!!");
                    btcontador.setEnabled(true);
                    btcontamenos.setEnabled(false);
                    fondo.setBackgroundResource(R.drawable.fondorepet);
                    cnt=0;
                    txtcuenta.setText("00");
                    if (cnt2==1) {
                        txtmedio.setText("20 M");
                    }else{
                        txtmedio.setText("40 M");
                        prueba="40 M";
                    }
                }
            }.start();

        }
    }
    public void metodores(View vista){
        cnt--;
        if (cnt==0) {
            btcontamenos.setEnabled(false);
        }
        metodocontador();
    }
    public void metodocontador(){

        txtcuenta.setText(""+cnt);
    }

}