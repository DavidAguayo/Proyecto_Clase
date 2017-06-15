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
import com.proyecto.proyecto_clase.clases.DiaRutina;

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
 * Created by jorge.sanchez on 06/06/2017.
 */

public class TablaRutinas extends AppCompatActivity{
    private Toolbar toolbar;
    public String username;
    public String password;
    public String id;

    public DiaRutina[] diaRutinasArray;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_rutinas);

        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");
        id = i.getStringExtra("id");
        //Para incluir el Toolbar:
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
        getMenuInflater().inflate(R.menu.menu_inicio, mimenu);
        //Para introducir la opción de búsqueda;
        //MenuItem menuItem = mimenu.findItem(R.id.menu_buscar);

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


    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return diaRutinasArray.length;
        }

        @Override
        public Fragment getItem(int position) {
            return ejerciciosFragment.newInstance(username,password,diaRutinasArray[position].getId().toString());
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return diaRutinasArray[position].getName();
        }
    }


    //Peticion rest de los dias con una id de rutina

    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/diaRutina/buscarPorIdRutina";

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
                ResponseEntity<DiaRutina[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), DiaRutina[].class);
                diaRutinasArray = response.getBody();
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