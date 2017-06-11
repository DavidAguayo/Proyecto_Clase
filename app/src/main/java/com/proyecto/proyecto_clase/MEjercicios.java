package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.proyecto.proyecto_clase.clases.Ejercicios;
import com.proyecto.proyecto_clase.clases.GrupoMuscular;

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

public class MEjercicios extends AppCompatActivity {


    private Toolbar toolbar;
    public String username;
    public String password;
    public String id;
    public ArrayList<Ejercicios> ejerciciosArrayList = new ArrayList<>();
    public GrupoMuscular[] grupoArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejercicios);

        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");
        ejerciciosArrayList = (ArrayList<Ejercicios>) i.getSerializableExtra("ejercicios");

        id = i.getStringExtra("id");
        //Para incluir el Toolbar:
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Grupos Musculares");
        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onStart() {
        super.onStart();
        new FetchSecuredResourceTask().execute();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_sin_buscador, mimenu);
        //Para introducir la opción de búsqueda;
        MenuItem menuItem = mimenu.findItem(R.id.menu_buscar);
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
    //COnfiguracion de las tabs
    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return grupoArray.length;
        }

        @Override
        public Fragment getItem(int position) {
            return gruposFragment.newInstance(username,password,grupoArray[position].getId().toString());
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return grupoArray[position].getName();
        }
    }
    //Petticion rest

    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/grupoMuscular/all";

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
                ResponseEntity<GrupoMuscular[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), GrupoMuscular[].class);
                grupoArray = response.getBody();
                return "SI";
            } catch (HttpClientErrorException e) {
                Log.e("SalasActivity", e.getMessage(), e);
                return "NO";
            } catch (Exception e) {
                Log.e("SalasActivity", e.getMessage(), e);
                return "NO";
            }
        }
        //Se ejecuta despues de la peticion a spring
        @Override
        protected void onPostExecute(String result){
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
            viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));

            PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
            tabsStrip.setViewPager(viewPager);
        }

    }

}
