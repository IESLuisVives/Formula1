package com.example.formula1tfcfront.aplication.ui.circuitos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.aplication.rest.model.Circuito;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class Circuitos extends Fragment {

    List<Circuito> circuitoList = new ArrayList<>();
    CircuitoRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circuitos,container,false);
        Api api = ApiConfig.getClient().create(Api.class);
        RecyclerView recyclerView = view.findViewById(R.id.listaCircuitosRecycler);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Call<List<Circuito>> allCircuitos = api.obtenerCircuitos();

        allCircuitos.enqueue(new Callback<List<Circuito>>() {
            @Override
            public void onResponse(Call<List<Circuito>> call, Response<List<Circuito>> response) {
                circuitoList = response.body();
                adapter = new CircuitoRecyclerAdapter(circuitoList,getActivity());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Circuito>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }




}