package com.example.formula1tfcfront.aplication.ui;

import com.example.formula1tfcfront.aplication.rest.model.Usuario;


public class Intercambio {
    private static Intercambio instance;
    private Intercambio(){}

    public static Intercambio getInstance(){
        if(instance==null){
            instance = new Intercambio();
        }
        return instance;
    }

    private FragmentHolder fragmentHolder;

    private Usuario usuario;

    public FragmentHolder getFragmentHolder() {
        return fragmentHolder;
    }

    public void setFragmentHolder(FragmentHolder fragmentHolder) {
        this.fragmentHolder = fragmentHolder;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
