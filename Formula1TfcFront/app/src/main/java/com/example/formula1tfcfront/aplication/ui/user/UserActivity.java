package com.example.formula1tfcfront.aplication.ui.user;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.Home;
import com.example.formula1tfcfront.aplication.ui.FragmentHolder;
import com.example.formula1tfcfront.aplication.ui.Intercambio;
import com.example.formula1tfcfront.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity implements FragmentHolder {

    private ActivityUserBinding binding;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserBinding.inflate(getLayoutInflater());
        Intercambio.getInstance().setFragmentHolder(this);
        setContentView(binding.getRoot());
    }

    @Override
    public void changeFragment(Fragment f) {
        transaction = getSupportFragmentManager().beginTransaction();
        //transaction.replace(R.id.fragmentContainerView3,f);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent home = new Intent(this, Home.class);
        startActivity(home);
        finish();
    }
}