package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainEv2 extends AppCompatActivity {
    public Button start,detener,btcorrer,btdescansar;
    public Chronometer cronometro;
    public TextView mTextField1,mTextField2;
    public CountDownTimer timer30;
    public CountDownTimer timer60;
    public int cnt=0;
    public LinearLayout fondo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ev2);
        cronometro =(Chronometer)findViewById(R.id.cronometroev2);
        fondo= (LinearLayout)findViewById(R.id.fondolayoutev2);
        start =(Button)findViewById(R.id.startev2);
        detener =(Button)findViewById(R.id.stopev2);
        btcorrer =(Button)findViewById(R.id.correrev2);
        btdescansar =(Button)findViewById(R.id.descansarev2);
        mTextField1=(TextView)findViewById(R.id.txt);
        mTextField2=(TextView)findViewById(R.id.txt4);
        btcorrer.setEnabled(false);
        btdescansar.setEnabled(false);
        detener.setEnabled(false);
        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Ejercicios de velocidad 2");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_inicio, mimenu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.configuracion){
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
    public void empezar(View vista){
        start.setEnabled(false);
        start.setVisibility(View.INVISIBLE);
        detener.setEnabled(true);
        btcorrer.setEnabled(true);
        btdescansar.setEnabled(false);
        int stoppedMilliseconds = 0;

        String chronoText = cronometro.getText().toString();
        String array[] = chronoText.split(":");
        if (array.length == 2) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
        } else if (array.length == 3) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 + Integer.parseInt(array[1]) * 60 * 1000
                    + Integer.parseInt(array[2]) * 1000;
        }

        cronometro.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
        cronometro.start();


    }
    public void correr(View vista){
        cnt++;
        btcorrer.setEnabled(false);

        timer30 = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {

                fondo.setBackgroundResource(R.drawable.run);
                mTextField1.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                mTextField1.setText("00");
                btdescansar.setEnabled(true);
                Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                v.vibrate(1500);
            }
        }.start();
    }
    public void descansar(View vista){
        cnt++;
        btdescansar.setEnabled(false);
        timer30.cancel();
        timer60 = new CountDownTimer(90000, 1000) {

            public void onTick(long millisUntilFinished) {
                fondo.setBackgroundResource(R.drawable.descanso);
                mTextField2.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField2.setText("00");
                btcorrer.setEnabled(true);
                Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                v.vibrate(1500);

            }
        }.start();
    }

    public void detenerr(View vista){
        start.setEnabled(false);
        detener.setEnabled(true);
        cronometro.setBase(SystemClock.elapsedRealtime());
        cronometro.stop();
        if (cnt==0) {
        }else {
            if (cnt%2!=0) {
                timer30.cancel();
                mTextField1.setText("00");
            }else{
                timer60.cancel();
                mTextField2.setText("00");
            }
        }


    }
}