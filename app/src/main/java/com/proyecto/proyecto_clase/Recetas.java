package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.proyecto.proyecto_clase.adapters.RecetasAdapter;
import com.proyecto.proyecto_clase.models.RecetasLista;

import java.util.ArrayList;
import java.util.List;

public class Recetas extends AppCompatActivity implements SearchView.OnQueryTextListener{
    //Para incluir la búsqueda:
    public ArrayList<RecetasLista> recetasList = new ArrayList<>();
    public ArrayList<RecetasLista> aux = new ArrayList<>();
    private Boolean filtro = false;

    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    private List<RecetasLista> recetas_item;
    private RecetasAdapter recetasAdapter;

    String[] numero={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
    String[] nombre = {"Sopa de pescado", "Sopa de ajo","Sopa minestrone","Sopa de pasta",
        "Sopa de verduras","Sopa de ave","Puré de alubias","Crema de calabacín",
        "Crema de zanahoria","Panaché de verduras","Porrusalda","Patatas en salsa verde",
        "Huevos con champiñones a la crema","Marmitako","Bacalao ajoarriero"};
    int[] img = {
            R.drawable.r1,
            R.drawable.r2,
            R.drawable.r3,
            R.drawable.r4,
            R.drawable.r5,
            R.drawable.r6,
            R.drawable.r7,
            R.drawable.r8,
            R.drawable.r9,
            R.drawable.r10,
            R.drawable.r11,
            R.drawable.r12,
            R.drawable.r13,
            R.drawable.r14,
            R.drawable.r15
    };
    String[] elaborar = {
            "Ponemos agua en un recipiente con trozos  y espinas de pescado, cebolla, " +
                    "puerro y zanahoria. Llevamos a ebullición dejando cocer 15 minutos " +
                    "para conseguir un buen caldo. Aparte ponemos a pochar en aceite de oliva " +
                    "la cebolla el puerro y la zanahoria, cuando esté hecho añadimos el tomate, " +
                    "dejándolo cocer por espacio de 10 minutos. A continuación vertimos el " +
                    "caldo, lo trituramos y  pasamos por colador chino. Lo llevamos de nuevo " +
                    "a ebullición y añadimos el pan tostado dejándolo cocer otros 10 minutos. " +
                    "Un minuto antes de retirar del fuego vertimos en la sopa el pescado " +
                    "desmigado.",
            "Cortamos el ajo en filetes, ponemos a calentar el aceite en una cazuela y " +
                    "sin dejar que se dore vertimos el pan tostado cortado en rebanadas y " +
                    "dejamos que absorba el aceite. A continuación, añadimos caldo de carne " +
                    "o en su defecto agua. Dejamos cocer 15 minutos o hasta que se haya " +
                    "desecho bien el pan. Una vez cocinado, y 1 minuto antes de retirar del " +
                    "fuego, añadimos el huevo batido pasteurizado y removemos bien para " +
                    "que no se hagan grumos.",
            "Ponemos el agua a hervir y cuando llegue a ebullición  vertimos todos los " +
                    "ingredientes vegetales dejándolo cocer por espacio de 20 minutos. A continuación, " +
                    "añadimos la pasta, dejándo cocer todo el conjunto por espacio de 5 minutos.",
            "Una vez elaborado el caldo con los componentes correspondientes, se cuela " +
                    "y se añade la pasta, dejándola hervir 5 minutos.  A continuación, " +
                    "vertimos los trocitos de ave y damos un hervor.",
            "Ponemos agua a hervir y cuando llegue a ebullición añadimos todas las verduras " +
                    "cortadas en juliana (tiras finas y alargadas). Cuando esté todo cocido " +
                    "añadimos el tomate que previamente habremos salteado en una sartén " +
                    "con aceite de oliva durante 10 minutos.",
            "Una vez elaborado el caldo con los componentes correspondientes, se cuela y " +
                    "se añade la pasta dejándola hervir 5 minutos. A continuación vertimos " +
                    "los trocitos de ave y damos un hervor.",
            "Ponemos a cocer las alubias con la zanahoria, el puerro y la patata. " +
                    "Aproximadamente, 4 partes de agua por una del resto de componentes. " +
                    "Una vez todo cocido, trituramos y pasamos por colador chino. " +
                    "Lo llevamos de nuevo a ebullición y le añadimos el aceite de oliva en crudo.",
            "Ponemos a pochar la cebolla con la mantequilla y algo de aceite, cuando esté " +
                    "tierna,  añadimos el calabacín y la patata, lo rehogamos, vertimos el " +
                    "agua y la leche y lo llevamos a punto de ebullición dejándolo cocer " +
                    "por espacio de 15 minutos o hasta que la patata esté cocinada, la " +
                    "trituramos y pasamos por colador chino.",
            "Ponemos todo los componentes a cocer. Retiramos parte del agua de la cocción " +
                    "añadimos aceite de oliva, trituramos y pasamos por colador chino " +
                    "dándole un pequeño hervor final.",
            "Ponemos a hervir agua abundante. Cuando llegue al punto de ebullición " +
                    "añadimos la zanahoria y el guisante. Cuando vuelva a romper a " +
                    "hervir, y pasados cinco minutos, añadimos el resto de verduras. " +
                    "Una vez cocidas, las escurrimos bien y añadimos el aceite de " +
                    "oliva en crudo.",
            "Ponemos en una cazuela agua y llevamos a ebullición. A continuación, " +
                    "añadimos la zanahoria. Cuando vuelva a hervir añadiremos las" +
                    " patatas y el puerro. Una vez que todo esté cocido, freímos " +
                    "a fuego muy lento  el ajo en aceite de oliva, teniendo cuidado " +
                    "de que no se ponga dorado, y se lo añadimos a las verduras. " +
                    "Este plato debe quedar caldoso",
            "Salteamos el ajo con aceite de oliva. A continuación vertimos las patatas" +
                    " y las rehogamos, una vez rehogadas vertimos el caldo y dejamos" +
                    " cocer por espacio de 20 minutos. Cuando estén hechas espolvoreamos " +
                    "con perejil.",
            "Cocemos los huevos durante 12 minutos, los pelamos y cortamos por la mitad. " +
                    "Aparte, salteamos los champiñones y reservamos. En una sartén se " +
                    "deslee la harina y a continuación vertimos la leche caliente, " +
                    "dejando cocer 10 minutos. Le añadimos los champiñones dejando " +
                    "cocer 2 minutos y luego napamos los huevos.",
            "Ponemos a pochar en una cazuela la verdura en aceite de oliva. " +
                    "Una vez tierna, añadimos la patata y rehogamos. A continuación" +
                    " vertimos caldo de pescado, o en su defecto agua, y dejamos cocer " +
                    "por espacio de 20 minutos. Tres minutos antes de retirar del " +
                    "fuego añadimos los trozos de atún.",
            "Ponemos a pochar en aceite de oliva la cebolla, los ajos, los pimientos. " +
                    "Una vez cocinados añadimos la patata previamente pochada, luego " +
                    "el tomate y las láminas de bacalao rehogando todo junto por " +
                    "espacio de 3 minutos. Espolvoreamos con perejil."
    };

    String[] resumen = {
            "Ponemos agua en un recipiente con trozos  y espinas de pescado, cebolla, " +
                    "puerro y zanahoria. Llevamos a ebullición dejando cocer 15 minutos " +
                    "para conseguir...",
            "Cortamos el ajo en filetes, ponemos a calentar el aceite en una cazuela y " +
                    "sin dejar que se dore vertimos el pan tostado cortado en rebanadas y " +
                    "dejamos que...",
            "Ponemos el agua a hervir y cuando llegue a ebullición  vertimos todos los...",
            "Una vez elaborado el caldo con los componentes correspondientes, se cuela " +
                    "y..",
            "Ponemos agua a hervir y cuando llegue a ebullición añadimos todas las verduras " +
                    "cortadas en juliana (tiras finas y alargadas). Cuando esté todo cocido...",
            "Una vez elaborado el caldo con los componentes correspondientes, se cuela y " +
                    "se añade...",
            "Ponemos a cocer las alubias con la zanahoria, el puerro y la patata. " +
                    "Aproximadamente, 4 partes de agua por..",
            "Ponemos a pochar la cebolla con la mantequilla y algo de aceite, cuando esté " +
                    "tierna,  añadimos el calabacín y la...",
            "Ponemos todo los componentes a cocer. Retiramos parte del agua de la cocción " +
                    "añadimos aceite de..",
            "Ponemos a hervir agua abundante. Cuando llegue al punto de ebullición " +
                    "añadimos la zanahoria y el guisante. Cuando...",
            "Ponemos en una cazuela agua y llevamos a ebullición. A continuación, " +
                    "añadimos la zanahoria. Cuando vuelva a...",
            "Salteamos el ajo con aceite de oliva. A continuación vertimos las patatas" +
                    " y las rehogamos, una vez rehogadas...",
            "Cocemos los huevos durante 12 minutos, los pelamos y cortamos por la mitad. " +
                    "Aparte, salteamos los...",
            "Ponemos a pochar en una cazuela la verdura en aceite de oliva. " +
                    "Una vez tierna, añadimos...",
            "Ponemos a pochar en aceite de oliva la cebolla, los ajos, los pimientos. " +
                    "Una vez cocinados añadimos la patata previamente.."
    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);


        drecyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        if(drecyclerView != null){
            drecyclerView.setHasFixedSize(true);
        }

        dLayoutManager = new LinearLayoutManager(this);

        //Si queremos usar un gridlayoutmanager
        //dLayoutManager = new GridLayoutManager(this,2);

        drecyclerView.setLayoutManager(dLayoutManager);

        recetas_item = new ArrayList<>();

        for(int i = 0; i<img.length; i++){
            RecetasLista recetas = new RecetasLista(nombre[i], img[i], resumen[i]);
            recetas_item.add(recetas);
        }
        recetasAdapter = new RecetasAdapter(recetas_item);
        drecyclerView.setAdapter(recetasAdapter);
        recetasAdapter.notifyDataSetChanged();


        //Lo que viene a continuación sirve para dirigir a otra actividad al pulsar sobre
        //un cardview
        drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            redirigir(position);
            }
        }));

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al tool bar:
        getSupportActionBar().setTitle("Recetas");
        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void redirigir(int position){
        Intent intent = new Intent(Recetas.this, InfoReceta.class);
        intent.putExtra("numero",numero[position]);
        intent.putExtra("imagen", img[position]);
        intent.putExtra("nombre", nombre[position]);
        intent.putExtra("elaborar", elaborar[position]);
        startActivity(intent);
    }
    //Métodos para el menú
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_ruti, mimenu);
        //Para introducir la opción de búsqueda;
        MenuItem menuItem = mimenu.findItem(R.id.menu_buscar);
        SearchView searchView =(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.configuracion){
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
    //Para opcion de búsqueda
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        aux.clear();
        ArrayList<RecetasLista> newList = new ArrayList<>();
        for(RecetasLista recetas : recetas_item)
        {
            String name = recetas.getNombre().toLowerCase();
            if(name.contains(newText)){
                newList.add(recetas);
                filtro = true;
                aux.add(recetas);
            }
        }
        recetasAdapter.setFilter(newList);

        return false;
    }
}
