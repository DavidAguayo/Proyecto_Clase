package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.github.snowdream.android.widget.SmartImage;
import com.github.snowdream.android.widget.SmartImageView;
import com.proyecto.proyecto_clase.clases.DiaRutina;
import com.proyecto.proyecto_clase.clases.Ejercicios;

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

public class MainComunEjer extends AppCompatActivity{
    public String username;
    public String password;
    public String id;
    public Ejercicios ejercicio;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comun_ejer);
        Intent i = getIntent();
        username = i.getStringExtra("username");
        password = i.getStringExtra("password");
        id = i.getStringExtra("id");
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        //Para activar el toolbar como barra de herramientas:
        setSupportActionBar(toolbar);
        //Para poner el título al toolbar:

        //boton de atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Para incluir la opción de búsqueda:
    }
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_sin_buscador, mimenu);
        //Para introducir la opción de búsqueda;
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

        if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new FetchSecuredResourceTask().execute();
    }

    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/ejercicios/buscarPorId";

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
                ResponseEntity<Ejercicios> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Ejercicios.class);
                ejercicio = response.getBody();
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

            String ruta = ejercicio.getFoto().split("/")[3];
            ruta = "http://80.29.167.245:8520/imagenes/" + ruta;

            SmartImageView imagen = (SmartImageView)findViewById(R.id.img);
            TextView nombre =(TextView) findViewById(R.id.nombre);
            TextView descripcion =(TextView) findViewById(R.id.descripcion);
            Rect rect = new Rect(imagen.getLeft(), imagen.getTop(), imagen.getRight(), imagen.getBottom());
            imagen.setImageUrl(ruta ,rect);
            nombre.setText(ejercicio.getName());
            descripcion.setText(ejercicio.getDescripcion());
            getSupportActionBar().setTitle(ejercicio.getName());

        }

    }
}
