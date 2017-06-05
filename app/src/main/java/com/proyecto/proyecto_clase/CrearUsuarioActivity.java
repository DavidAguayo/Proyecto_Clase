package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.proyecto.proyecto_clase.clases.Usuario;

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

public class CrearUsuarioActivity extends AppCompatActivity {
    Usuario usuario = new Usuario();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_nuevo);
    }
    public void crearUsuario(View v) {
        new FetchSecuredResourceTask().execute();
    }
        private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {
            //Los datos del usuario
            private String name;
            private String lastName;
            private String email;
            private String password;
            private String address;
            private String fechaNacimiento;
            private String peso;
            private String altura;
            //se ejecuta antes del background
            @Override
            protected void onPreExecute() {
                EditText texto = (EditText)findViewById(R.id.name);
                name = texto.getText().toString();
                texto = (EditText)findViewById(R.id.lastName);
                lastName = texto.getText().toString();
                texto = (EditText)findViewById(R.id.email);
                email = texto.getText().toString();
                texto = (EditText)findViewById(R.id.password);
                password = texto.getText().toString();
                texto = (EditText)findViewById(R.id.address);
                address = texto.getText().toString();
                texto = (EditText)findViewById(R.id.fechaNacimiento);
                fechaNacimiento = texto.getText().toString();
                texto = (EditText)findViewById(R.id.peso);
                peso = texto.getText().toString();
                texto = (EditText)findViewById(R.id.altura);
                altura = texto.getText().toString();
            }

            @Override
            protected String doInBackground(Void... params) {
                final String url = "http://80.29.167.245:8520/usuario/add";

                // Populate the HTTP Basic Authentitcation header with the username and password
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                // Create a new RestTemplate instance
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                requestHeaders.add("name",name);
                requestHeaders.add("lastName",lastName);
                requestHeaders.add("email",email);
                requestHeaders.add("password",password);
                requestHeaders.add("rol", "ROLE_USER");
                requestHeaders.add("address",address);
                requestHeaders.add("fechaNacimiento",fechaNacimiento);
                requestHeaders.add("peso",peso);
                requestHeaders.add("altura",altura);


                try {
                    // Make the network request
                    ResponseEntity<Usuario> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<Object>(requestHeaders), Usuario.class);
                    usuario = response.getBody();
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
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                Toast toast = Toast.makeText(getBaseContext(),"Usuario " + usuario.getName()+" creado",Toast.LENGTH_LONG);
                toast.show();
                startActivity(intent);
            }

        }
    }


