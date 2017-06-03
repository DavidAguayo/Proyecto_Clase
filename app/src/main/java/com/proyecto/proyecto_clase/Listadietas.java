package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
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

public class Listadietas extends AppCompatActivity implements SearchView.OnQueryTextListener{
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    //Para incluir la opción de búsqueda:
    /*private ArrayList<String> array_sort = new ArrayList<String>();
    int textlength = 0;
    private String listview_array[] = {"Hiperproteica blanda", "Protección gástrica","Astringente pobre en residuos"};*/


    //Variables pra lo del recycler view
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    private ArrayList<DietasLista> dietas_item;
    private DietasAdapter dietasAdapter;

    String[] nombre = {"Hiperproteica blanda", "Protección gástrica","Astringente pobre en residuos","Dieta\nlíquida","Sin\ngluten","Ovo-lacto-vegetariana","Blanda sin lácteos","Control\ncolesterol"};

    int[] img = {
            R.drawable.hiperproteica,
            R.drawable.proteccion,
            R.drawable.astringente,
            R.drawable.dietaliquida,
            R.drawable.singluten,
            R.drawable.ovolacto,
            R.drawable.blandasinlacteos,
            R.drawable.controlcolesterol
    };

    //Variables para compartir datos entre actividades a través del intent
    String[] informacion = {"La dieta hiperproteica se caracteriza porque consiste en consumir sin límites aquellos alimentos que son ricos en proteínas, como los fiambres, las carnes, los embutidos, los lácteos y el huevo, pero prohíbe alimentos tan importantes para la salud como los cereales, el pan, las patatas, las legumbres, etc.",
            "La función principal de una dieta de protección gástrica es mantener el estómago en un estado de semireposo funcional, por lo cual se recomienda hacer comidas pequeñas, pero frecuentes, a base de alimentos blandos. En esta dieta evitaremos también ciertos alimentos irritantes de la mucosa gástrica y privilegiaremos en tanto, otros alimentos beneficiosos para el sistema gastrointestinal.",
            "",
            "Una dieta líquida es aquella que no contiene alimentos sólidos, prescritas normalmente para enfermedades gastrointestinales o antes o después de ciertos tipos de cirugía, como la cirugía oral y del tracto gastrointestinal.",
            "El único tratamiento eficaz para la Enfermedad Celiaca es una dieta sin gluten para toda la vida. El gluten es una proteína que se encuentra en la semilla de cereales como trigo, cebada, centeno y derivados y posiblemente avena. Es recomendable consumir productos naturales ya que los productos manufacturados tienen un mayor riesgo de estar contaminados o contener trazas.",
            "La dieta ovolactovegetariana, es la versión menos estricta dentro de vegetarianismo, puesto que admite el consumo de lácteos y huevos, además de los cereales, legumbres, frutas y verduras, semillas, frutos secos y aceites.",
            "La dieta blanda es un plan de alimentación de mayor o menor duración que los médicos prescriben ante diferentes enfermedades del aparato digestivo o la recuperación de una intervención quirúrgica. Su característica fundamental es que incluye alimentos fáciles de masticar y digerir, ausentes de condimentos, grasas, ácidos u otras sustancias utilizadas en su preparación que puedan causar irritación en el aparato digestivo o estimular la secreción de jugos gástricos.",
            "Para bajar los niveles de colesterol total se requiere de una buena alimentación, ejercicio y un estilo de vida saludable. En algunos casos las personas requieren de medicamentos, pero un cambio en la dieta puede disminuir el colesterol hasta en un 15%. Una disminución de 1% reduce en un 2% el riesgo de enfermedad cardiovascular."};

    //En el siguiente array de dos dimensiones, van todos los desayunos:
    String[][] desayunos = {{"Leche, azúcar\nClara huevo\nTostadas\nJamón York","Leche, azúcar\nClara huevo\nTostadas\nJamón York","Leche, azúcar\nClara huevo\nTostadas\nJamón York","Leche, azúcar\nClara huevo\nTostadas\nJamón York","Leche, azúcar\nClara huevo\nTostadas\nJamón York","Leche, azúcar\nClara huevo\nTostadas\nJamón York","Leche, azúcar\nClara huevo\nTostadas\nJamón York"},
            {"Leche, azúcar\nGalletas\nMantequilla, mermelada","Leche, azúcar\nGalletas\nMantequilla, mermelada","Leche, azúcar\nGalletas\nMantequilla, mermelada","Leche, azúcar\nGalletas\nMantequilla, mermelada","Leche, azúcar\nGalletas\nMantequilla, mermelada","Leche, azúcar\nGalletas\nMantequilla, mermelada","Leche, azúcar\nGalletas\nMantequilla, mermelada"},
            {""},
            {"Café con leche","Café con leche","Café con leche","Café con leche","Café con leche","Café con leche","Café con leche"},
            {"Leche, azúcar\nTostadas sin gluten\nMermelada","Leche, azúcar\nTostadas sin gluten\nMermelada","Leche, azúcar\nTostadas sin gluten\nMermelada","Leche, azúcar\nTostadas sin gluten\nMermelada","Leche, azúcar\nTostadas sin gluten\nMermelada","Leche, azúcar\nTostadas sin gluten\nMermelada","Leche, azúcar\nTostadas sin gluten\nMermelada"},
            {"Café con leche\nPan\nMantequilla-mermelada","Café con leche\nPan\nMantequilla-mermelada","Café con leche\nPan\nMantequilla-mermelada","Café con leche\nPan\nMantequilla-mermelada","Café con leche\nPan\nMantequilla-mermelada","Café con leche\nPan\nMantequilla-mermelada","Café con leche\nPan\nMantequilla-mermelada"},
            {"Té con azúcar\nPan\nMermelada","Té con azúcar\nPan\nMermelada","Té con azúcar\nPan\nMermelada","Té con azúcar\nPan\nMermelada","Té con azúcar\nPan\nMermelada","Té con azúcar\nPan\nMermelada","Té con azúcar\nPan\nMermelada"},
            {"Leche descafeinada con azúcar\nPan\nMermelada","Leche descafeinada con azúcar\nPan\nMermelada","Leche descafeinada con azúcar\nPan\nMermelada","Leche descafeinada con azúcar\nPan\nMermelada","Leche descafeinada con azúcar\nPan\nMermelada","Leche descafeinada con azúcar\nPan\nMermelada","Leche descafeinada con azúcar\nPan\nMermelada"}};

    //Array para las comidas:
    String[][] comidas = {{"Puré de lentejas\nPescado con verduritas\nYogurt natural","Arroz con verduras\nSalmón\nYogurt natural","Crema de legumbres\nTernera asada con champiñones\nArroz con leche","Paella\nAlbóndigas\nCompota de manzana","Crema de alubias\nMuslo de pollo asado\nCompota de manzana","Menestra de verduras\nPescado en salsa verde\nCompota de manzana","Judías verdes con patatas\nConejo a la cazadora\nFlan"},
            {"Puré de patata\nPollo asado desgrasado\nYogurt natural","Arroz con verduras\nMerluza cocida\nYogurt natural","Macarrones con queso\nTernera asada con champiñones\nArroz con leche","Sopa de estrellas\nPescado al horno\nCompota de manzana","Puré de patata\nPollo asado desgrasado\nCompota de manzana","Sopa de estrellas\nPescado en salsa verde\nNatillas","Puré de patata\nMerluza cocida\nFlan"},
            {""},
            {"Caldo","Caldo","Caldo","Caldo","Caldo","Caldo","Caldo"},
            {"Lentejas sin gluten\nPollo asado sin gluten\nFruta","Porrusalda\nSalmón con patatas al vapor sin gluten\nYogurt natural","Crema de legumbres\nFilete con patatas sin gluten\nArroz con leche","Ensalada sin gluten\nGallo con patatas sin gluten\nYogurt natural","Crema de alubias\nPollo asado desgrasado\nYogurt natural","Menestra sin gluten\nMerluza a la plancha sin gluten\nFruta","Judías verdes con patatas\nFilete son patatas sin gluten\nFruta"},
            {"Ensalada vegetariana\nLentejas estofadas\nNatillas","Porrusalda\nPanaché de verduras\nYogurt natural","Ensalada vegetariana\nGarbanzos con espinacas\nArroz con leche","Patatas en salsa verde\nGarbanzos con arroz\nPera en almíbar","Crema de alubias\nTallarines con tomate\nCompota de manzana","Ensalada vegetariana\nPanaché de verduras\nManzana asada","Judías verdes con patatas\nPaella vegetal\nPera en almíbar"},
            {"Puré de lentejas\nPollo asado con patatas fritas\nFruta","Arroz con verduras\nSalmón al vapor\nCompota de manzana","Crema de legumbres\nTernera asada\nFruta","Patatas en salsa verde\nAlbóndigas\nFruta","Crema de alubias\nPollo asado desgrasado\nCompota de manzana","Menestra de verduras\nPescado en salsa verde\nFruta","Judías verdes con patatas\nConejo a la cazadora\nFruta"},
            {"Lentejas\nPollo asado\nFruta","Porrusalda\nSalmón\nFruta","Macarrones con tomate\nTernera asada\nFruta","Patatas en salsa verde\nPescado al horno\nYogurt natural descremado","Crema de alubias\nPollo asado desgrasado\nCompota de manzana","Menestra de verduras\nPescado en salsa verde\nFruta","Crema de alubias\nPollo asado desgrasado\nCompota de manzana","Menestra de verduras\nPescado en salsa verde\nFruta","Judías verdes con patatas\nConejo a la cazadora\nFruta"}};

    //Array para las meriendas:
    String[][] meriendas = {{"Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas"},
            {"Leche, azúcar\nGalletas","Leche, azúcar\nGalletas","Leche, azúcar\nGalletas","Leche, azúcar\nGalletas","Leche, azúcar\nGalletas","Leche, azúcar\nGalletas","Leche, azúcar\nGalletas"},
            {""},
            {"Café con leche","Café con leche","Café con leche","Café con leche","Café con leche","Café con leche","Café con leche"},
            {"Café con leche desnatada\nSacarina\nGalletas dietéticas\nFruta","Café con leche desnatada\nSacarina\nGalletas dietéticas\nFruta","Café con leche desnatada\nSacarina\nGalletas dietéticas\nFruta","Café con leche desnatada\nSacarina\nGalletas dietéticas\nFruta","Café con leche desnatada\nSacarina\nGalletas dietéticas\nFruta","Café con leche desnatada\nSacarina\nGalletas dietéticas\nFruta","Café con leche desnatada\nSacarina\nGalletas dietéticas\nFruta"},
            {"Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas","Café con leche\nGalletas"},
            {"Té con azúcar\nTostadas\nFruta","Té con azúcar\nTostadas\nFruta","Té con azúcar\nTostadas\nFruta","Té con azúcar\nTostadas\nFruta","Té con azúcar\nTostadas\nFruta","Té con azúcar\nTostadas\nFruta","Té con azúcar\nTostadas\nFruta"},
            {"Leche descafeinada con azúcar\nFruta","Leche descafeinada con azúcar\nFruta","Leche descafeinada con azúcar\nFruta","Leche descafeinada con azúcar\nFruta","Leche descafeinada con azúcar\nFruta","Leche descafeinada con azúcar\nFruta","Leche descafeinada con azúcar\nFruta"}};

    //Array para las cenas:
    String[][] cenas = {{"Crema de zanahorias\nTortilla de jamón york\nCompota de manzana", "Sopa de estrellas\nMerluza al horno\nCompota de manzana","Sopa de verduras\nLenguado menier\nNatillas","Crema de guisantes\nBacalao ajoarriero\nYogur natural","Sopa de pescado\nPescado al horno con guarnición\nNatillas","Sopa de ajo\nLomos de cabracho\nYogur de sabores","Crema de calabacín\nPavo en salsa\nYogur natural"},
            {"Crema de zanahorias\nTortilla de jamón de york\nManzana asada","Sopa de estrellas\nMerluza al horno\nCompota de manzana","Puré de patata\nLenguado cocido\nNatillas","Sopa de ave\nTortilla francesa\nYogurt natural","Sopa de estrellas\nHuevos cocidos con crema de champiñones\nYogurt natural","Sopa minestrone\nPollo cocido\nYogurt natural","Crema de calabacín\nJamón york\nYogurt natural"},
            {""},
            {"Caldo","Caldo","Caldo","Caldo","Caldo","Caldo","Caldo"},
            {"Sopa de estrellas\nHuevos cocidos con pisto\nYogurt natural","Sopa de estrellas\nPollo estofado con champiñones\nCompota de manzana","Sopa de verduras\nPescado menier\nYogurt natural","Sopa de ave\nLomo en su jugo\nYogurt natural descremado","Espinacas salteadas\nPescado al horno con guarnición\nYogurt natural","Sopa minestrone\nTortilla de patata\nYogurt natural","Crema de calabacín\nMerluza a la americana\nFlan de frutas sin azúcar"},
            {"Ensalada vegetariana\nPanaché de verduras\nFruta","Ensalada vegetariana\nTortilla francesa\nCompota de manzana","Ensalada vegetariana\nArroz con champiñones\nFruta","Crema de guisantes\nTortilla francesa\nFlan","Ensalada vegetariana\nEspinacas con bechamel\nFruta","Sopa minestrone\nTortilla de patata\nFruta","Crema de calabacín\nTortilla francesa\nFruta"},
            {"Sopa de estrellas\nTortilla de jamón york\nManzana asada","Sopa de estrellas\nMerluza al horno\nFruta","Sopa de verduras\nLenguado rebozado\nCompota de manzana","Sopa de ave\nLomo en su jugo\nFruta","Espinacas salteadas\nPescado al horno con guarnición\nFruta","Sopa minestrone\nLomos de cabracho\nCompota de manzana","Sopa de estrellas\nPavo en salsa\nCompota de manzana"},
            {"Sopa de estrellas\nBacalao a la vizcaína\nManzana asada","Crema de verdura\nMerluza al horno\nCompota de manzana","Crema de puerro y patata\nPescado menier\nFruta","Crema de guisantes\nBacalao ajoarriero\nFruta","Espinacas salteadas\nPescado a la plancha\nFruta","Sopa minestrone\nLomos de cabracho\nManzana asada","Crema de calabacín\nPescado a la plancha\nFruta"}};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dietas);

        //Para recoger la información de los alimentos
        ArrayList<String> datos = (ArrayList<String>) getIntent().getSerializableExtra("datos");

        //Lo que viene a continuación sirve para hacer lo del recycler view
        drecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        if(drecyclerView != null){
            drecyclerView.setHasFixedSize(true);
        }

        dLayoutManager = new GridLayoutManager(this,2);

        drecyclerView.setLayoutManager(dLayoutManager);

        dietas_item = new ArrayList<>();

        //Para comprobar con la información de los alimentos:
        if(!datos.isEmpty()) {
            for (int i = 0; i < datos.size(); i++){
                if(datos.get(i).equals("Acedera")){
                    DietasLista dietas = new DietasLista(nombre[i], img[i]);
                    dietas_item.add(dietas);
                }
            }
        }
        else if(datos.isEmpty()){
            for(int i = 0; i<nombre.length; i++){
                DietasLista dietas = new DietasLista(nombre[i], img[i]);
                dietas_item.add(dietas);}
        }

        /*for(int i = 0; i<nombre.length; i++){
            DietasLista dietas = new DietasLista(nombre[i], img[i]);
            dietas_item.add(dietas);
        }*/
        dietasAdapter = new DietasAdapter(dietas_item);
        drecyclerView.setAdapter(dietasAdapter);
        dietasAdapter.notifyDataSetChanged();

        //Lo que viene a continuación sirve para dirigir a otra actividad al pulsar sobre
        //un cardview
        drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Listadietas.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();
                CrearIntent(position);
                /*if(position==0){
                    CrearIntent(position);
                }
                if(position==1){
                    CrearIntent(position);
                }
                if(position==2){
                    Intent intent = new Intent(Listadietas.this, NavigationDrawer.class);
                    intent.putExtra("nombre", nombre[0]);
                    startActivity(intent);
                }
                if(position==3){
                    CrearIntent(position);
                }
                if(position==4){
                    CrearIntent(position);
                }*/
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


    //Lo que viene a continuación sirve para incluir el menú en la actividad e indicar las acciones
    //que ejecutan cada opción
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_activity, mimenu);
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



    public void CrearIntent(int i){
        Intent intent = new Intent(Listadietas.this, Dietas.class);
        intent.putExtra("nombre", nombre[i]);
        intent.putExtra("info", informacion[i]);
        intent.putExtra("desayunos1", desayunos[i][0]);
        intent.putExtra("desayunos2", desayunos[i][1]);
        intent.putExtra("desayunos3", desayunos[i][2]);
        intent.putExtra("desayunos4", desayunos[i][3]);
        intent.putExtra("desayunos5", desayunos[i][4]);
        intent.putExtra("desayunos6", desayunos[i][5]);
        intent.putExtra("desayunos7", desayunos[i][6]);
        intent.putExtra("comidas1", comidas[i][0]);
        intent.putExtra("comidas2", comidas[i][1]);
        intent.putExtra("comidas3", comidas[i][2]);
        intent.putExtra("comidas4", comidas[i][3]);
        intent.putExtra("comidas5", comidas[i][4]);
        intent.putExtra("comidas6", comidas[i][5]);
        intent.putExtra("comidas7", comidas[i][6]);
        intent.putExtra("meriendas1", meriendas[i][0]);
        intent.putExtra("meriendas2", meriendas[i][1]);
        intent.putExtra("meriendas3", meriendas[i][2]);
        intent.putExtra("meriendas4", meriendas[i][3]);
        intent.putExtra("meriendas5", meriendas[i][4]);
        intent.putExtra("meriendas6", meriendas[i][5]);
        intent.putExtra("meriendas7", meriendas[i][6]);
        intent.putExtra("cenas1", cenas[i][0]);
        intent.putExtra("cenas2", cenas[i][1]);
        intent.putExtra("cenas3", cenas[i][2]);
        intent.putExtra("cenas4", cenas[i][3]);
        intent.putExtra("cenas5", cenas[i][4]);
        intent.putExtra("cenas6", cenas[i][5]);
        intent.putExtra("cenas7", cenas[i][6]);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<DietasLista> newList = new ArrayList<>();
        for(DietasLista dietas : dietas_item)
        {
            String name = dietas.getNombre().toLowerCase();
            if(name.contains(newText)){
                newList.add(dietas);
            }
        }
        dietasAdapter.setFilter(newList);
        return false;
    }


    //Añadimos la opción de favoritos:
    /*public void clickBoton1 (View v) {
        Button boton = (Button)
                findViewById(R.id.favoritos);
        boton.setBackground(Drawable.createFromPath("@android:drawable/btn_star_big_on"));
    }*/
}