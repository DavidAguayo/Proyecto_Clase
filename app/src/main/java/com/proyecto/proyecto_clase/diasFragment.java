package com.proyecto.proyecto_clase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyecto.proyecto_clase.adapters.AlimentosAdapter;
import com.proyecto.proyecto_clase.clases.Alimento;
import com.proyecto.proyecto_clase.clases.AlimentosComida;
import com.proyecto.proyecto_clase.clases.Comidas;
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
 * Created by Jorge on 10/06/2017.
 */

public class diasFragment extends Fragment {

    //declaramos un recycler por cada comida del dia asi mismo un array y un arrayList
    private RecyclerView drecyclerView;
    private RecyclerView drecyclerView2;
    private RecyclerView drecyclerView3;
    private RecyclerView drecyclerView4;

    public AlimentosComida[] desayunoArray;
    public AlimentosComida[] comidaArray;
    public AlimentosComida[] meriendaArray;
    public AlimentosComida[] cenaArray;

    public ArrayList<Alimento> desayunoList = new ArrayList<>();
    public ArrayList<Alimento> comidaList = new ArrayList<>();
    public ArrayList<Alimento> meriendaList = new ArrayList<>();
    public ArrayList<Alimento> cenaList = new ArrayList<>();

    //el LayoutMandager y el Adapter para el recycle
    private RecyclerView.LayoutManager dLayoutManager;
    AlimentosAdapter alimentosAdapter;
    //valores que nos entraran y debemos setear para poder utilizar en todo el fragment
    public String username;
    public String password;
    public String id_dieta;
    public String dia;


    //Recogida de datos al crear la instancia y metiendolos en los argumentos del fragment
    public static diasFragment newInstance(String username, String password, String dia, String id_dieta) {
        Bundle args = new Bundle();
        args.putString("id", dia);
        args.putString("username",username);
        args.putString("password",password);
        args.putString("id_dieta",id_dieta);
        diasFragment fragment = new diasFragment();
        fragment.setArguments(args);
        return fragment;
    }
    //Seteamos los datos pasados a traves del Bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getArguments().getString("username");
        password = getArguments().getString("password");
        dia = getArguments().getString("id");
        id_dieta = getArguments().getString("id_dieta");
    }

    //Creamos la vista (aqui llamaremos a nustra petición asincrona)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_comidas, container, false);
        new FetchSecuredResourceTask().execute();
        return view;
    }
    //Peticion asincrona
    private class FetchSecuredResourceTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params){
            //endpoint de la peticion REST
            final String url = "http://80.29.167.245:8520/alimentosComidas/buscarPorDieta";

            // HTTP Basic Authentitcation header del nombre y la contraseña
            HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAuthorization(authHeader);
            requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            //headers necesarios para la peticion
            requestHeaders.add("dieta_id",id_dieta);
            requestHeaders.add("dia",dia);
            requestHeaders.add("comida","Desayuno");
            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            try {
                // Make the network request, estamos haciendo una peticion por cada comida que tenemos
                ResponseEntity<AlimentosComida[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), AlimentosComida[].class);
                desayunoArray = response.getBody();
                desayunoList.clear();
                Alimento desayuno = new Alimento();
                desayuno.setName("Desayuno");
                desayunoList.add(desayuno);
                for(int i = 0 ; i < desayunoArray.length ; i++){
                    desayunoList.add(desayunoArray[i].getAlimento());
                }

                requestHeaders.remove("comida");
                requestHeaders.add("comida","Comida");
                response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), AlimentosComida[].class);
                comidaArray = response.getBody();
                comidaList.clear();
                Alimento comida = new Alimento();

                comida.setName("Comida");
                comidaList.add(comida);
                for(int i = 0 ; i < comidaArray.length ; i++){
                    comidaList.add(comidaArray[i].getAlimento());
                }
                requestHeaders.remove("comida");
                requestHeaders.add("comida","Merienda");
                response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), AlimentosComida[].class);
                meriendaArray = response.getBody();
                meriendaList.clear();
                Alimento merienda = new Alimento();
                merienda.setName("Merienda");
                meriendaList.add(merienda);
                for(int i = 0 ; i < meriendaArray.length ; i++){
                    meriendaList.add(meriendaArray[i].getAlimento());
                }
                requestHeaders.remove("comida");
                requestHeaders.add("comida","Cena");
                response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), AlimentosComida[].class);
                cenaArray = response.getBody();
                cenaList.clear();
                Alimento cena = new Alimento();
                cena.setName("Cena");
                cenaList.add(cena);
                for(int i = 0 ; i < cenaArray.length ; i++){
                    cenaList.add(cenaArray[i].getAlimento());
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
            //Aqui crearemos el recycler view ( tenemos tambien uno por cada comida que tengamos)
            drecyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view_desayuno);
            if(drecyclerView != null){
                drecyclerView.setHasFixedSize(true);
            }
            dLayoutManager = new GridLayoutManager(getContext(),1);
            drecyclerView.setLayoutManager(dLayoutManager);
            alimentosAdapter = new AlimentosAdapter(desayunoList);
            drecyclerView.setAdapter(alimentosAdapter);


            drecyclerView2 = (RecyclerView)getView().findViewById(R.id.recycler_view_comida);
            if(drecyclerView2 != null){
                drecyclerView2.setHasFixedSize(true);
            }
            dLayoutManager = new GridLayoutManager(getContext(),1);
            drecyclerView2.setLayoutManager(dLayoutManager);
            alimentosAdapter = new AlimentosAdapter(comidaList);
            drecyclerView2.setAdapter(alimentosAdapter);

            drecyclerView3 = (RecyclerView)getView().findViewById(R.id.recycler_view_merienda);
            if(drecyclerView3 != null){
                drecyclerView3.setHasFixedSize(true);
            }
            dLayoutManager = new GridLayoutManager(getContext(),1);
            drecyclerView3.setLayoutManager(dLayoutManager);
            alimentosAdapter = new AlimentosAdapter(meriendaList);
            drecyclerView3.setAdapter(alimentosAdapter);

            drecyclerView4 = (RecyclerView)getView().findViewById(R.id.recycler_view_cena);
            if(drecyclerView4 != null){
                drecyclerView4.setHasFixedSize(true);
            }
            dLayoutManager = new GridLayoutManager(getContext(),1);
            drecyclerView4.setLayoutManager(dLayoutManager);
            alimentosAdapter = new AlimentosAdapter(cenaList);
            drecyclerView4.setAdapter(alimentosAdapter);




        }
    }

}
