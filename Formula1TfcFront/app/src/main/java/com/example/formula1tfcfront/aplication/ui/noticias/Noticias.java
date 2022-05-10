package com.example.formula1tfcfront.aplication.ui.noticias;

import android.os.Bundle;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.databinding.FragmentNoticiasBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Noticias#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Noticias extends Fragment {

    private FragmentNoticiasBinding binding;
    private Api api;

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
        binding.listaHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return binding.getRoot();
    }

    private void obtenerNoticias(){

    }
}