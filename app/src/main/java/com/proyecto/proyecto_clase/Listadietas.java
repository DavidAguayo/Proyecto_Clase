package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.proyecto.proyecto_clase.adapters.DietasAdapter;
import com.proyecto.proyecto_clase.clases.Dieta;

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


/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class Listadietas extends AppCompatActivity implements SearchView.OnQueryTextListener{
    //Instancia de la clase Toolbar para incluirlo:
    private Toolbar toolbar;
    //Variables pra lo del recycler view
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    DietasAdapter dietasAdapter;

    public ArrayList<Dieta> dietasList = new ArrayList<>();
    public ArrayList<Dieta> aux = new ArrayList<>();
    public Dieta[] dietasArray;
    public ArrayList items;
    public String id;
    private String username;
    private String password;
    private Boolean filtro = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dietas);
        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Lista de dietas");
        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Para incluir la opción de búsqueda:
        SearchView bs = (SearchView) findViewById(R.id.menu_buscar);
        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
        //rv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listview_array));
    }
    @Override
    protected void onStart() {
        super.onStart();
        dietasList.clear();
        new FetchSecuredResourceTask().execute();
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
        if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        aux.clear();
        ArrayList<Dieta> newList = new ArrayList<>();
        for(Dieta dietas : dietasList)
        {
            String name = dietas.getName().toLowerCase();
            if(name.contains(newText)){
                newList.add(dietas);
                aux.add(dietas);
            }
        }
        dietasAdapter.setFilter(newList);
        return false;
    }


    //Metodo de metodo asyncrona al servicio rest
    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/dieta/all";

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
                ResponseEntity<Dieta[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Dieta[].class);
                dietasArray = response.getBody();
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
            drecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            if(drecyclerView != null){
                drecyclerView.setHasFixedSize(true);
            }
            dLayoutManager = new GridLayoutManager(getBaseContext(),2);
            drecyclerView.setLayoutManager(dLayoutManager);

            for(int i =0 ; i<dietasArray.length ; i++){
                dietasList.add(dietasArray[i]);
            }

            dietasAdapter = new DietasAdapter(dietasList);
            drecyclerView.setAdapter(dietasAdapter);
            dietasAdapter.notifyDataSetChanged();

            drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getBaseContext(), new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    if(filtro){
                        Intent intent = new Intent(Listadietas.this, TablaDietas.class);
                        String id = aux.get(position).getId().toString();
                        intent.putExtra("id",id);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(Listadietas.this, TablaDietas.class);
                        String id = dietasList.get(position).getId().toString();
                        intent.putExtra("id",id);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        startActivity(intent);
                    }
                }
            }));

        }

    }




}
