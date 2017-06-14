package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.proyecto.proyecto_clase.clases.Dia;

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

import java.util.Collections;

/**
 * Created by jorge.sanchez on 05/06/2017.
 */

public class TablaDietas extends AppCompatActivity {
    private Toolbar toolbar;
    public String username;
    public String password;
    public String id;
    public Dia[] diaArray;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_dietas);
        //Cargar los intent
        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");
        id = i.getStringExtra("id");

        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:
        getSupportActionBar().setTitle("Calendario");
        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onStart() {
        super.onStart();
        new FetchSecuredResourceTask().execute();
    }
    //metodos para implementar el menu
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_sin_buscador, mimenu);

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
            i.putExtra("username", username);
            i.putExtra("password", password);
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


    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return diaArray.length;
        }

        @Override
        public Fragment getItem(int position) {
            return diasFragment.newInstance(username,password,diaArray[position].getName().toString(),id);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return diaArray[position].getName();
        }
    }

    //Peticion rest de los dias con una id de rutina

    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/dia/buscarPorIdDieta";

            // Populate the HTTP Basic Authentitcation header with the username and password
            HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAuthorization(authHeader);
            requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            requestHeaders.add("id",id);
            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            try {
                // Make the network request
                ResponseEntity<Dia[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Dia[].class);
                diaArray = response.getBody();
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