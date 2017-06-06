package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by jorge.sanchez on 06/06/2017.
 */

public class TablaRutinas extends AppCompatActivity {
    public String username;
    public String password;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");
        setContentView(R.layout.activity_tabla_rutinas);
        TextView text = (TextView) findViewById(R.id.textView31);
        String id = i.getStringExtra("id");
        text.setText(id);
    }
}