package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.proyecto.proyecto_clase.adapters.DietasAdapter;
import com.proyecto.proyecto_clase.models.DietasLista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.R.drawable.btn_star_big_on;

/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class Listadietas extends AppCompatActivity {
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    //Para incluir la opción de búsqueda:
    /*private ArrayList<String> array_sort = new ArrayList<String>();
    int textlength = 0;
    private String listview_array[] = {"Hiperproteica blanda", "Protección gástrica","Astringente pobre en residuos"};*/


    //Variables pra lo del recycler view
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    private List<DietasLista> dietas_item;
    private DietasAdapter dietasAdapter;

    String[] nombre = {"Hiperproteica blanda", "Protección gástrica","Astringente pobre en residuos","Dieta\nlíquida"};

    int[] img = {
            R.drawable.hiperproteica,
            R.drawable.proteccion,
            R.drawable.astringente,
            R.drawable.dietaliquidaborr
    };

    //Variables para compartir datos entre actividades a través del intent
    String[] informacion = {"La dieta hiperproteica se caracteriza porque consiste en consumir sin límites aquellos alimentos que son ricos en proteínas, como los fiambres, las carnes, los embutidos, los lácteos y el huevo, pero prohíbe alimentos tan importantes para la salud como los cereales, el pan, las patatas, las legumbres, etc.",
        "La función principal de una dieta de protección gástrica es mantener el estómago en un estado de semireposo funcional, por lo cual se recomienda hacer comidas pequeñas, pero frecuentes, a base de alimentos blandos. En esta dieta evitaremos también ciertos alimentos irritantes de la mucosa gástrica y privilegiaremos en tanto, otros alimentos beneficiosos para el sistema gastrointestinal.",
        "",
        "Una dieta líquida es aquella que no contiene alimentos sólidos, prescritas normalmente para enfermedades gastrointestinales o antes o después de ciertos tipos de cirugía, como la cirugía oral y del tracto gastrointestinal."};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dietas);

        //Lo que viene a continuación sirve para hacer lo del recycler view
        drecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        if(drecyclerView != null){
            drecyclerView.setHasFixedSize(true);
        }

        dLayoutManager = new GridLayoutManager(this,2);

        drecyclerView.setLayoutManager(dLayoutManager);

        dietas_item = new ArrayList<>();

        for(int i = 0; i<nombre.length; i++){
            DietasLista dietas = new DietasLista(nombre[i], img[i]);
            dietas_item.add(dietas);
        }
        dietasAdapter = new DietasAdapter(dietas_item);
        drecyclerView.setAdapter(dietasAdapter);
        dietasAdapter.notifyDataSetChanged();

        //Lo que viene a continuación sirve para dirigir a otra actividad al pulsar sobre
        //un cardview
        drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Listadietas.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent intent = new Intent(Listadietas.this, Dietas.class);
                    intent.putExtra("nombre", nombre[0]);
                    intent.putExtra("info", informacion[0]);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(Listadietas.this, Dietas.class);
                    intent.putExtra("nombre", nombre[1]);
                    intent.putExtra("info", informacion[1]);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(Listadietas.this, NavigationDrawer.class);
                    intent.putExtra("nombre", nombre[0]);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(Listadietas.this, Dietas.class);
                    intent.putExtra("nombre", nombre[3]);
                    intent.putExtra("info", informacion[3]);
                    startActivity(intent);
                }
            }
        }));

        //ImageView im = (ImageView)findViewById(R.id.dietasimg);

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Lista de dietas");



        //Para incluir la opción de búsqueda:
        SearchView bs = (SearchView) findViewById(R.id.menu_buscar);
        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
        //rv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listview_array));


    }


    //Este método nos dirige a otra actividad
    public void ejecutar_info(View view){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }
    //Lo que viene a continuación sirve para incluir el menú en la actividad e indicar las acciones
    //que ejecutan cada opción
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_activity, mimenu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.configuracion){
            ejecutar_info(null);
            return true;
        }
        if(id==R.id.info){
            Intent i = new Intent(this, Alimentos.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.rece){
            Intent i = new Intent(this, Recetas.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.atras){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }

    //Añadimos la opción de favoritos:
    public void clickBoton1 (View v) {
        Button boton = (Button)
                findViewById(R.id.favoritos);
        boton.setBackground(Drawable.createFromPath("@android:drawable/btn_star_big_on"));
    }
}
