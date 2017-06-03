package com.proyecto.proyecto_clase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDrun extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE DatosRun (clave TEXT,distancia TEXT,tiempo TEXT)";

    public BDrun(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Si no existe la base de datos la crea y ejecuta los siguientes comandos
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS DatosRun");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);

    }


}