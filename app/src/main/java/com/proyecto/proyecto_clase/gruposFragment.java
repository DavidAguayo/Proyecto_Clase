package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyecto.proyecto_clase.adapters.EjerciciosAdapter;
import com.proyecto.proyecto_clase.clases.Ejercicios;
import com.proyecto.proyecto_clase.clases.EjerciciosGrupo;

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
 * Created by Jorge on 08/06/2017.
 */

public class gruposFragment extends Fragment {
    private RecyclerView drecyclerView;
    private RecyclerView.LayoutManager dLayoutManager;
    EjerciciosAdapter ejerciciosAdapter;
    public ArrayList<Ejercicios> EjerciciosList = new ArrayList<>();
    public EjerciciosGrupo[] ejerciciosGruposArray;
    public String username;
    public String password;
    public String id;

    public static gruposFragment newInstance(String username, String password, String id) {
        Bundle args = new Bundle();
        args.putString("id", id);
        args.putString("username",username);
        args.putString("password",password);
        gruposFragment fragment = new gruposFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getArguments().getString("username");
        password = getArguments().getString("password");
        id = getArguments().getString("id");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_ejercicios, container, false);
        EjerciciosList.clear();
        new FetchSecuredResourceTask().execute();
        return view;
    }

    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            final String url = "http://80.29.167.245:8520/ejerciciosGrupo/buscarPorIdGrupo";

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
                ResponseEntity<EjerciciosGrupo[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), EjerciciosGrupo[].class);
                ejerciciosGruposArray = response.getBody();

                for(int i = 0 ; i < ejerciciosGruposArray.length ; i++){
                    EjerciciosList.add(ejerciciosGruposArray[i].getEjercicio());
                }
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
            drecyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view);
            if(drecyclerView != null){
                drecyclerView.setHasFixedSize(true);
            }
            dLayoutManager = new GridLayoutManager(getContext(),1);
            drecyclerView.setLayoutManager(dLayoutManager);

            ejerciciosAdapter = new EjerciciosAdapter(EjerciciosList);
            drecyclerView.setAdapter(ejerciciosAdapter);
            ejerciciosAdapter.notifyDataSetChanged();

            drecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(getActivity(), MainComunEjer.class);
                    intent.putExtra("id", EjerciciosList.get(position).getId().toString());
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }));

        }
    }

}
