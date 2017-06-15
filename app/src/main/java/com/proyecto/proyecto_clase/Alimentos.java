package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.proyecto.proyecto_clase.adapters.IngredientesAdapter;
import com.proyecto.proyecto_clase.clases.Alimento;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

public class Alimentos extends AppCompatActivity implements SearchView.OnQueryTextListener{
    //Para realizar el filtro por alimentos:
    private Button btfiltrar;
    public ArrayList<String> datos= new ArrayList<String>();
    public ArrayList<String> desactivados = new ArrayList<>();
    private Boolean coincide=false;

    //Variables pra lo del recycler view
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;

    IngredientesAdapter alimentos;
    public ArrayList<Alimento> alimentosList = new ArrayList<>();
    public ArrayList<Alimento> aux = new ArrayList<>();
    public Alimento[] alimentosArray;
    public String id="";
    private String username;
    private String password;
    private Boolean filtro = false;

    //Variables para realizar el POST
    private Boolean cambios=false;
    private String estado="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);
        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Ingredientes");
        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onStart() {
        super.onStart();
        alimentosList.clear();
        new Alimentos.FetchSecuredResourceTask().execute();
    }
    //Metodo de metodo asyncrona al servicio rest
    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {


                final String url = "http://80.29.167.245:8520/alimentos/all";

                // Populate the HTTP Basic Authentitcation header with the username and password
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setAuthorization(authHeader);
                requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                // Create a new RestTemplate instance
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                try {
                    // Make the network request
                    ResponseEntity<Alimento[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Alimento[].class);
                    alimentosArray = response.getBody();
                    return "SI";
                } catch (HttpClientErrorException e) {
                    Log.e("SalasActivity", e.getMessage(), e);
                    return "NO";
                } catch (Exception e) {
                    Log.e("SalasActivity", e.getMessage(), e);
                    return "NO";
                }

        }
        //SE ejecuta despues de la peticion a spring
        @Override
        protected void onPostExecute(String result){
            //Aqui crearemos el recycler view
            drecyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
            if(drecyclerView != null){
                drecyclerView.setHasFixedSize(true);
            }
            dLayoutManager = new GridLayoutManager(getBaseContext(),2);
            drecyclerView.setLayoutManager(dLayoutManager);

            for(int i =0 ; i<alimentosArray.length ; i++){
                if(!alimentosArray[i].getTipo().equalsIgnoreCase("Plato"))
                    alimentosList.add(alimentosArray[i]);
            }

            alimentos = new IngredientesAdapter(alimentosList);
            drecyclerView.setAdapter(alimentos);
            alimentos.notifyDataSetChanged();

            drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getBaseContext(), new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    if(!filtro) {
                        if (alimentosList.get(position).getDescripcion().equalsIgnoreCase("Activado")) {
                            id = alimentosList.get(position).getId().toString();
                            Alimento mLog = new Alimento();
                            mLog.setId(Integer.parseInt(id));
                            mLog.setName(alimentosList.get(position).getName());
                            mLog.setTipo(alimentosList.get(position).getTipo());
                            mLog.setDescripcion("Desactivado");
                            alimentosList.set(position, mLog);
                            //aux.clear();
                            ArrayList<Alimento> newList = new ArrayList<>();
                            for (Alimento alimento : alimentosList) {
                                newList.add(alimento);
                            }
                            alimentos.setFilter(newList);
                            estado = "Desactivado";

                            //Añade el elemento desactivado al ArrayList
                            desactivados.add(alimentosList.get(position).getName());

                        } else {
                            id = alimentosList.get(position).getId().toString();
                            Alimento mLog = new Alimento();
                            mLog.setId(Integer.parseInt(id));
                            mLog.setName(alimentosList.get(position).getName());
                            mLog.setTipo(alimentosList.get(position).getTipo());
                            mLog.setDescripcion("Activado");
                            alimentosList.set(position, mLog);
                            //aux.clear();
                            ArrayList<Alimento> newList = new ArrayList<>();
                            for (Alimento alimento : alimentosList) {
                                newList.add(alimento);
                            }

                            //Elimina el elemento desactivado del ArrayList
                            for(int i=0; i<desactivados.size(); i++){
                                if(desactivados.get(i).equalsIgnoreCase(alimentosList.get(position).getName())){
                                    desactivados.remove(i);
                                }
                            }

                            alimentos.setFilter(newList);
                            estado = "Activado";
                        }
                    }
                    else{
                        if (aux.get(position).getDescripcion().equalsIgnoreCase("Activado")) {
                            id = aux.get(position).getId().toString();
                            Alimento mLog = new Alimento();
                            mLog.setId(Integer.parseInt(id));
                            mLog.setName(aux.get(position).getName());
                            mLog.setTipo(aux.get(position).getTipo());
                            mLog.setDescripcion("Desactivado");
                            aux.set(position, mLog);
                            //aux.clear();
                            ArrayList<Alimento> newList = new ArrayList<>();
                            for (Alimento alimento : aux) {
                                newList.add(alimento);
                                //aux.add(alimento);
                            }
                            alimentos.setFilter(newList);
                            estado = "Desactivado";
                            //Añade el elemento desactivado al ArrayList
                            desactivados.add(alimentosList.get(position).getName());

                        } else {
                            id = aux.get(position).getId().toString();
                            Alimento mLog = new Alimento();
                            mLog.setId(Integer.parseInt(id));
                            mLog.setName(aux.get(position).getName());
                            mLog.setTipo(aux.get(position).getTipo());
                            mLog.setDescripcion("Activado");
                            aux.set(position, mLog);
                            //aux.clear();
                            ArrayList<Alimento> newList = new ArrayList<>();
                            for (Alimento alimento : aux) {
                                newList.add(alimento);
                                //aux.add(alimento);
                            }
                            //Elimina el elemento desactivado del ArrayList
                            for(int i=0; i<desactivados.size(); i++){
                                if(desactivados.get(i).equalsIgnoreCase(alimentosList.get(position).getName())){
                                    desactivados.remove(i);
                                }
                            }
                            alimentos.setFilter(newList);
                            estado = "Activado";
                        }
                    }
                    cambios=true;
                    Toast.makeText(Alimentos.this, "ID: "+id, Toast.LENGTH_SHORT).show();
                }
            }));
        }
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

    //Para opcion de busqueda
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        aux.clear();
        ArrayList<Alimento> newList = new ArrayList<>();
        for(Alimento alimento : alimentosList)
        {
            String name = alimento.getName().toLowerCase();
            if(name.contains(newText)){
                newList.add(alimento);
                filtro = true;
                aux.add(alimento);
            }
        }
        alimentos.setFilter(newList);

        return false;
    }


    //Método para realizar el filtro
    public void Comprobar(View view){
        String[][] dietas={{"39","Gambas","Acelga","Ajo","Alubias","Arroz","Azucar",
            "Bacalao", "Berza","Cabracho","Calabacin","Cebolla","Esparragos",
            "Huevo","Guisantes","Lenguado","Lentejas","Judias verdes","Manzana","Merluza","Naranja",
            "Patata","Pavo","Pimiento","Pollo","Tomate","Champiñones"}, //Dieta Hiperproteica blanda
                {"88"}, //Dieta liquida
                {"40","Ajo","Arroz","Azucar","Esparragos",
                        "Calabacin","Cebolla","Esparragos",
                        "Huevo","Lenguado","Judias verdes",
                        "Manzana","Merluza","Naranja",
                        "Patata","Pollo","Tomate","Champiñones"}, //Proteccion gastrica
                {"89","Ajo","Alubias","Arroz","Azucar",
                        "Bacalao", "Berza","Calabacin","Cebolla","Huevo",
                        "Guisantes","Lenguado","Lentejas","Manzana","Merluza",
                        "Naranja","Patata","Pollo","Tomate"}, //Sin gluten
                {"90","Acelga","Ajo","Alubias","Arroz",
                        "Berza","Brocoli","Calabacin","Cebolla","Esparragos",
                        "Guisantes","Lentejas","Judias verdes","Patata",
                        "Pimiento","Tomate"}, //Ovo-lacto
                {"91","Acelga","Ajo","Alubias","Arroz","Azucar",
                        "Berza","Cebolla","Esparragos","Huevo","Lenguado",
                        "Merluza","Patata","Pavo","Pimiento","Tomate","Champiñones"}, //Blanda sin lacteos
                {"92","Acelga","Ajo","Azucar",
                        "Bacalao", "Berza","Cabracho","Calabacin","Cebolla",
                        "Guisantes","Lentejas","Manzana","Merluza","Patata",
                        "Pimiento","Pollo","Tomate","Champiñones"}}; //Control colesterol
        //Boton para filtrar
        btfiltrar=(Button)findViewById(R.id.btfiltrar);
        if(desactivados.size()>0){
            for(int i=0; i<dietas.length; i++){
                for(int a=0; a<dietas[i].length; a++){
                    for(int e=0; e<desactivados.size(); e++){
                        if(desactivados.get(e).toLowerCase().equalsIgnoreCase(dietas[i][a].toLowerCase())){
                            datos.add(dietas[i][0]);
                        }
                    }
                }
            }
            Intent intent = new Intent(this, Listadietas.class);
            intent.putExtra("datos",datos);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            startActivity(intent);
        }
        finish();
    }
}

/*Para hacer lo de quitar las dietas que contengan alimentos desactivados
hay que comprobar si un switch está desactivado para introducirlo todo
en un String y pasarlo al OnCreate de Listadietas.java y comprobarlo
antes de cargar el recyclerview*/