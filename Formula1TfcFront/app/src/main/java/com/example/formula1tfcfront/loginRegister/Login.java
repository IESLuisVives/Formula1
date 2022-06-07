package com.example.formula1tfcfront.loginRegister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.formula1tfcfront.aplication.Home;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.aplication.rest.model.LoginEntity;
import com.example.formula1tfcfront.aplication.rest.model.Usuario;
import com.example.formula1tfcfront.databinding.FragmentLoginBinding;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.ui.Intercambio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends Fragment {

    private FragmentLoginBinding binding;
    private Api api;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean login;

    public Login() {
        // Required empty public constructor
    }

    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api= ApiConfig.getClient().create(Api.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater,container,false);

        setOnClick();

        return binding.getRoot();
    }

    private void openActivity(Class clase){
        Intent intent = new Intent(getActivity(),clase);
        startActivity(intent);
    }

    private void vaciarCampos(){
         binding.etEmailLogin.setText("");
        binding.etPasswordLogin.setText("");
    }

    private void setOnClick(){
        binding.buttonLoggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loginUsuario(binding.etEmailLogin.getText().toString(),binding.etPasswordLogin.getText().toString());

            }
        });

        binding.buttonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intercambio.getInstance().getFragmentHolder().changeFragment(new Register());
            }
        });
    }

    public void loginUsuario(String username, String password){
        LoginEntity login =  new LoginEntity(username, password);
        Call<Usuario> call = api.login(login);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getActivity(),("Code: "+response.code()+" Usuario o Contraseña Invalidos"),Toast.LENGTH_LONG).show();
                    vaciarCampos();
                }else {
                    Usuario usuario = response.body();
                    Intercambio.getInstance().setUsuario(usuario);
                    openActivity(Home.class);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getActivity(),("ERROR: " + t.getMessage()),Toast.LENGTH_LONG).show();
            }
        });
    }
}