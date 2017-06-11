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

import com.proyecto.proyecto_clase.adapters.RutinasAdapter;
import com.proyecto.proyecto_clase.clases.Rutina;

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
 * Created by jorge.sanchez on 06/06/2017.
 */

public class Listarutinas extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    //Variables pra lo del recycler view
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;

    RutinasAdapter rutinasAdapter;

    public ArrayList<Rutina> rutinasList = new ArrayList<>();
    public ArrayList<Rutina> aux = new ArrayList<>();
    public Rutina[] rutinasArray;
    public ArrayList items;
    public String id;
    private String username;
    private String password;
    private Boolean filtro = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_rutinas);
        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");

        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Lista de rutinas");
        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Para incluir la opción de búsqueda:
        SearchView bs = (SearchView) findViewById(R.id.menu_buscar);
        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
        //rv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listview_array))
    }
    @Override
    protected void onStart() {
        super.onStart();
        rutinasList.clear();
        new FetchSecuredResourceTask().execute();
    }

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
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        aux.clear();
        ArrayList<Rutina> newList = new ArrayList<>();
        for(Rutina rutinas : rutinasList)
        {
            String name = rutinas.getName().toLowerCase();
           if(name.contains(newText)){
               newList.add(rutinas);
               filtro = true;
               aux.add(rutinas);
            }
        }
        rutinasAdapter.setFilter(newList);

        return false;
    }

    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/rutina/all";

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
                ResponseEntity<Rutina[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Rutina[].class);
                rutinasArray = response.getBody();
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

            for(int i = 0 ; i < rutinasArray.length ; i++){
                rutinasList.add(rutinasArray[i]);
            }

            rutinasAdapter = new RutinasAdapter(rutinasList);
            drecyclerView.setAdapter(rutinasAdapter);
            rutinasAdapter.notifyDataSetChanged();

            drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getBaseContext(), new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    if(filtro) {
                        Intent intent = new Intent(Listarutinas.this, TablaRutinas.class);
                        String id = aux.get(position).getId().toString();
                        intent.putExtra("id", id);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(Listarutinas.this, TablaRutinas.class);
                        String id = rutinasList.get(position).getId().toString();
                        intent.putExtra("id", id);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        startActivity(intent);
                    }
                }
            }));

        }

    }



}
