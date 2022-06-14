package com.example.formula1tfcfront.aplication.ui.user;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.Home;
import com.example.formula1tfcfront.aplication.ui.Intercambio;
import com.example.formula1tfcfront.databinding.FragmentUserBinding;
import com.example.formula1tfcfront.loginRegister.Login;
import com.example.formula1tfcfront.loginRegister.Register;


public class UserFragment extends Fragment {

    private FragmentUserBinding binding;
    private MediaPlayer mediaPlayer;

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentUserBinding.inflate(inflater,container,false);

        binding.tvEmailUprofile.setText(Intercambio.getInstance().getUsuario().getCorreo());
        binding.tvUsernameUprofile.setText(Intercambio.getInstance().getUsuario().getUsername());



        return binding.getRoot();
    }

}