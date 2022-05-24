package com.example.formula1tfcfront.aplication.ui.clasificacion;

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
import com.example.formula1tfcfront.aplication.rest.model.ClasificacionPiloto;
import com.example.formula1tfcfront.aplication.rest.model.Piloto;
import com.example.formula1tfcfront.aplication.ui.pilotos.Pilotos;
import com.example.formula1tfcfront.databinding.FragmentClasificacionBinding;
import com.example.formula1tfcfront.databinding.FragmentNoticiasBinding;
import com.example.formula1tfcfront.databinding.FragmentPilotosBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClasificacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClasificacionFragment extends Fragment {

    private FragmentClasificacionBinding binding;
    private ArrayAdapter<ClasificacionPiloto> listaPilotos;
    private Api api;
    private List<ClasificacionPiloto> pilotosList;
    public ClasificacionFragment(){

    }

    public static ClasificacionFragment newInstance() {

        ClasificacionFragment fragment = new ClasificacionFragment();
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
        binding = FragmentClasificacionBinding.inflate(inflater,container,false);
        obtenerClasificacion();
        return binding.getRoot();
    }

    private void obtenerClasificacion() {
        Call<List<ClasificacionPiloto>> allClasificacion = api.obtenerClasificacionPilotos();

        allClasificacion.enqueue(new Callback<List<ClasificacionPiloto>>() {
            @Override
            public void onResponse(Call<List<ClasificacionPiloto>> call, Response<List<ClasificacionPiloto>> response) {
                pilotosList = response.body();
                listaPilotos = new ArrayAdapter<ClasificacionPiloto>(getActivity(), android.R.layout.simple_list_item_1,pilotosList);
                binding.listaPilotosClasificacion.setAdapter(listaPilotos);
            }

            @Override
            public void onFailure(Call<List<ClasificacionPiloto>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}