package com.example.formula1tfcfront.aplication.ui.clasificacion;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.aplication.rest.model.ClasificacionPiloto;
import com.example.formula1tfcfront.aplication.rest.model.Noticia;
import com.example.formula1tfcfront.aplication.rest.model.Piloto;
import com.example.formula1tfcfront.aplication.ui.noticias.NoticiaRecyclerAdapter;
import com.example.formula1tfcfront.aplication.ui.pilotos.Pilotos;
import com.example.formula1tfcfront.databinding.FragmentClasificacionBinding;
import com.example.formula1tfcfront.databinding.FragmentNoticiasBinding;
import com.example.formula1tfcfront.databinding.FragmentPilotosBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ClasificacionFragment extends Fragment {

    List<ClasificacionPiloto> clasificacionPilotoList = new ArrayList<>();
    ClasificacionRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clasificacion,container,false);
        Api api = ApiConfig.getClient().create(Api.class);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerClasificacionPilotos );
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Call<List<ClasificacionPiloto>> allClasificacion = api.obtenerClasificacionPilotos();

        allClasificacion.enqueue(new Callback<List<ClasificacionPiloto>>() {
            @Override
            public void onResponse(Call<List<ClasificacionPiloto>> call, Response<List<ClasificacionPiloto>> response) {
                clasificacionPilotoList = response.body();

                Collections.sort(clasificacionPilotoList, new Comparator<ClasificacionPiloto>() {
                    @Override
                    public int compare(ClasificacionPiloto o1, ClasificacionPiloto o2) {
                        return o1.getPosicion().compareTo(o2.getPosicion());
                    }
                });

                adapter = new ClasificacionRecyclerAdapter(clasificacionPilotoList,getActivity());
                recyclerView.setAdapter(adapter);


            }
            @Override
            public void onFailure(Call<List<ClasificacionPiloto>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }




}