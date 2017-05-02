package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        Button button2;
        Button login;
        button = (Button)findViewById(R.id.DIETAS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Listadietas.class);
                startActivity(intent);
            }
        });
        button2 = (Button)findViewById(R.id.EJERCICIOS);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Ejercicios.class);
                startActivity(intent2);
            }
        });
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent3);
            }
        });

        //Para ocultar el action bar:
        getSupportActionBar().hide();
    }
}
