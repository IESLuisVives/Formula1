package com.example.formula1tfcfront.aplication.ui.circuitos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.aplication.rest.model.Circuito;
import com.example.formula1tfcfront.databinding.FragmentCircuitosBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Circuitos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Circuitos extends Fragment {

    private FragmentCircuitosBinding binding;
    private ArrayAdapter<Circuito> listaCircuitos;
    private Api api;
    private List<Circuito> circuitosList;

    public Circuitos() {
        // Required empty public constructor
    }

    public static Circuito newInstance(String param1, String param2) {
        Circuito fragment = new Circuito();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = ApiConfig.getClient().create(Api.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCircuitosBinding.inflate(inflater,container,false);
        obtenerPilotos();
        return binding.getRoot();
    }

    private void obtenerPilotos(){
        Call<List<Circuito>> allCircuitos = api.obtenerCircuitos();

        allCircuitos.enqueue(new Callback<List<Circuito>>() {
            @Override
            public void onResponse(Call<List<Circuito>> call, Response<List<Circuito>> response) {
                circuitosList = response.body();
                listaCircuitos = new ArrayAdapter<Circuito>(getActivity(), android.R.layout.simple_list_item_1, circuitosList);
                binding.listaCircuitos.setAdapter(listaCircuitos);
            }

            @Override
            public void onFailure(Call<List<Circuito>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}