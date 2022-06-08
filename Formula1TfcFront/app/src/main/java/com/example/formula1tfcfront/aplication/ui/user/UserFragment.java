package com.example.formula1tfcfront.aplication.ui.user;

import android.app.Dialog;
import android.content.DialogInterface;
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
import com.example.formula1tfcfront.aplication.ui.Intercambio;
import com.example.formula1tfcfront.databinding.FragmentUserBinding;



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

        binding.buttonDarseDeBajaUprofile.setBackgroundColor(Color.RED);
        binding.tvEmailUprofile.setText(Intercambio.getInstance().getUsuario().getCorreo());
        binding.tvUsernameUprofile.setText(Intercambio.getInstance().getUsuario().getUsername());

        setOnClick();

        return binding.getRoot();
    }

    private void setOnClick(){
        binding.buttonDarseDeBajaUprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });
    }

    private void alertDialog() {
        Dialog dialog = null;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Desea borrar la cuenta?")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deleteAccount();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                });
        AlertDialog alert = builder.create();

        dialog = alert;
        dialog.show();
    }

    private void deleteAccount(){
        Toast.makeText(getActivity(), "No gracias, te queremos demasiado como cliente para esta despedida tan tragica", Toast.LENGTH_LONG).show();
    }
}