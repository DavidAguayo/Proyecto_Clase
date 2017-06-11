package com.proyecto.proyecto_clase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainDatos extends AppCompatActivity implements View.OnClickListener {

    Button insertar;
    EditText editText;
    SQLiteDatabase db;
    Button consultar;
    TextView textView,tv1,clave;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_datos);
        insertar = (Button)findViewById(R.id.insertar);
        editText = (EditText)findViewById(R.id.editText);
        consultar = (Button)findViewById(R.id.consultar);
        textView = (TextView)findViewById(R.id.resultado);
        tv1 = (TextView)findViewById(R.id.textView12);
        clave = (TextView)findViewById(R.id.clave);
        insertar.setOnClickListener(this);
        consultar.setOnClickListener(this);
        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
//Construimos el mensaje a mostrar
        tv1.setText(bundle.getString("tiempo"));



        //Abrimos la base de datos 'BDrun' en modo escritura
        BDrun dat =
                new BDrun(this, "BDrun", null, 1);

        db = dat.getWritableDatabase();

//Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Datos Guardados");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertar:
                insertar.setEnabled(false);
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                //Insertar un registro
                db.execSQL("INSERT INTO DatosRun(clave,distancia,tiempo) VALUES ('" + clave.getText() + "','" + editText.getText() + "','" + tv1.getText() + "') ");
                break;

            case R.id.consultar:
                InputMethodManager inputMethodManager2 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager2.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                String[] args = new String[] {clave.getText().toString()};
                Cursor c = db.rawQuery(" SELECT * FROM DatosRun WHERE clave=?",args);
                if (c.moveToFirst()) {
                    textView.setText(""); // Vacio el textview
                    //Recorremos el cursor hasta que no haya más registros
                    do {

                        String distancia= c.getString(1);
                        String tiempo = c.getString(2);
                        textView.append(" Distancia: " + distancia+"m" + " Tiempo: " + tiempo + "\n");
                    } while(c.moveToNext());
                }

                break;

            default:

                break;
        }
    }
}