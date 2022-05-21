package com.example.formula1tfcfront.aplication.ui.noticias;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.aplication.rest.model.Noticia;
import com.example.formula1tfcfront.databinding.FragmentNoticiasBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Noticias#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Noticias extends Fragment {

    private FragmentNoticiasBinding binding;
    private ArrayAdapter<Noticia> listaNoticias;
    private Api api;
    private List<Noticia> noticiasList;

    public Noticias() {
        // Required empty public constructor
    }

    public static Noticias newInstance(String param1, String param2) {
        Noticias fragment = new Noticias();
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
        binding = FragmentNoticiasBinding.inflate(inflater,container,false);
        obtenerNoticias();
        return binding.getRoot();
    }

    private void obtenerNoticias(){
        Call<List<Noticia>> allNoticias = api.obtenerNoticias();

        allNoticias.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                noticiasList = response.body();
                listaNoticias = new ArrayAdapter<Noticia>(getActivity(), android.R.layout.simple_list_item_1,noticiasList);
                binding.listaHome.setAdapter(listaNoticias);
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo al comunicar con la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}