package com.example.formula1tfcfront;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.formula1tfcfront.aplication.rest.Api;
import com.example.formula1tfcfront.aplication.rest.ApiConfig;
import com.example.formula1tfcfront.aplication.ui.FragmentHolder;
import com.example.formula1tfcfront.aplication.ui.Intercambio;

public class MainActivity extends AppCompatActivity implements FragmentHolder {

    private FragmentTransaction transaction;
    private SharedPreferences sharedPreferences;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intercambio.getInstance().setFragmentHolder(this);
        api= ApiConfig.getClient().create(Api.class);
    }

    @Override
    public void changeFragment(Fragment f) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerLR,f);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}