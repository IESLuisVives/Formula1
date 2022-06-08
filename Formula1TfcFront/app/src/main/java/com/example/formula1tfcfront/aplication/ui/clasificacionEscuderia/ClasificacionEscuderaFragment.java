package com.example.formula1tfcfront.aplication.ui.clasificacionEscuderia;

import android.os.Bundle;
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
import com.example.formula1tfcfront.aplication.rest.model.ClasificacionEscuderia;
import com.example.formula1tfcfront.aplication.rest.model.ClasificacionPiloto;
import com.example.formula1tfcfront.aplication.ui.clasificacion.ClasificacionRecyclerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ClasificacionEscuderaFragment extends Fragment {
    List<ClasificacionEscuderia> clasificacionEscuderias = new ArrayList<>();
    ClasificacionEscuderiaRecylcerAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clasificacion_escudera,container,false);
        Api api = ApiConfig.getClient().create(Api.class);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerClasificacionEscuderias );
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        Call<List<ClasificacionEscuderia>> allClasificacion = api.obtenerClasificacionEscuderia();

        allClasificacion.enqueue(new Callback<List<ClasificacionEscuderia>>() {
            @Override
            public void onResponse(Call<List<ClasificacionEscuderia>> call, Response<List<ClasificacionEscuderia>> response) {
                clasificacionEscuderias = response.body();

                Collections.sort(clasificacionEscuderias, new Comparator<ClasificacionEscuderia>() {
                    @Override
                    public int compare(ClasificacionEscuderia o1, ClasificacionEscuderia o2) {
                        return Integer.compare(o1.getPosicion(), o2.getPosicion());
                    }
                });

                adapter = new ClasificacionEscuderiaRecylcerAdapter(clasificacionEscuderias,getActivity());
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<ClasificacionEscuderia>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}