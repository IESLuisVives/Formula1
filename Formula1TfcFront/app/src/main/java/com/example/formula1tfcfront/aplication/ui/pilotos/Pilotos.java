package com.example.formula1tfcfront.aplication.ui.pilotos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.aplication.rest.model.Noticia;
import com.example.formula1tfcfront.aplication.rest.model.Piloto;
import com.example.formula1tfcfront.aplication.ui.noticias.Noticias;
import com.example.formula1tfcfront.databinding.FragmentNoticiasBinding;
import com.example.formula1tfcfront.databinding.FragmentPilotosBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pilotos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pilotos extends Fragment {

    private FragmentPilotosBinding binding;
    private ArrayAdapter<Piloto> listaPilotos;
    private Api api;
    private List<Piloto> pilotosList;

    public Pilotos() {
        // Required empty public constructor
    }

    public static Pilotos newInstance(String param1, String param2) {
        Pilotos fragment = new Pilotos();
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
        binding = FragmentPilotosBinding.inflate(inflater,container,false);
        obtenerPilotos();
        return binding.getRoot();
    }

    private void obtenerPilotos(){
        Call<List<Piloto>> allPilotos = api.obtenerPilotos();

        allPilotos.enqueue(new Callback<List<Piloto>>() {
            @Override
            public void onResponse(Call<List<Piloto>> call, Response<List<Piloto>> response) {
                pilotosList = response.body();
                listaPilotos = new ArrayAdapter<Piloto>(getActivity(), android.R.layout.simple_list_item_1,pilotosList);
                binding.listaPilotos.setAdapter(listaPilotos);
            }

            @Override
            public void onFailure(Call<List<Piloto>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}