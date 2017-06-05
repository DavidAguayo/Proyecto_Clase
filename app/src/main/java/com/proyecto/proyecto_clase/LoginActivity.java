package com.proyecto.proyecto_clase;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.proyecto_clase.clases.Usuario;

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
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    public String username;
    public String password;
    public Usuario[] arrayUsuario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View v){
        AutoCompleteTextView textEmail = (AutoCompleteTextView)findViewById(R.id.email);
        EditText textPassword = (EditText)findViewById(R.id.password);
        username = textEmail.getText().toString();
        password = textPassword.getText().toString();
        new FetchSecuredResourceTask().execute();
    }
    public void crearUsuario(View v){
        Intent intent = new Intent(LoginActivity.this, CrearUsuarioActivity.class);
        startActivity(intent);
    }
    //Metodo de metodo asyncrona al servicio rest
    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/usuario/all";

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
                ResponseEntity<Usuario[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Usuario[].class);
                arrayUsuario = response.getBody();
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
        protected void onPostExecute(String result) {
            if(result.contains("SI")){
                Intent intent =  new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);
            }else{
                Toast toast= Toast.makeText(getBaseContext(),"Usuario o Contraseña invalidos", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

}

