package com.example.formula1tfcfront.aplication.ui.noticias;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.model.Noticia;

import java.util.ArrayList;

public class NoticiaRecyclerAdapter extends RecyclerView.Adapter<NoticiaRecyclerAdapter.ViewHolder> {

    //declarar las variables
    ArrayList<Noticia> notaList;

    //generamos el constructor
    public NoticiaRecyclerAdapter(ArrayList<Noticia> notaList) {

        this.notaList = notaList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //tenemos que inflar el layout donde se muestran los elementos
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent,false); //false para que no se destruyan

        // ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Noticia elementoItem = notaList.get(position);

        holder.textViewTitulo.setText(notaList.get(position).getTitulo());
        holder.textViewDescripcion.setText(notaList.get(position).getUrl());
        Uri uri = Uri.parse(notaList.get(position).getImagen());
        holder.imageViewFoto.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        //metodo que devuelve el numero de elementos de la lista
        return notaList.size();
    }

    //elementos del layout
    public class ViewHolder extends RecyclerView.ViewHolder {

        //variables
        TextView textViewTitulo, textViewDescripcion;
        ImageView imageViewFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //instaciar los objetos
            textViewTitulo = itemView.findViewById(R.id.textView_titulo);
            textViewDescripcion = itemView.findViewById(R.id.textView_decripcion);
            imageViewFoto = itemView.findViewById(R.id.imageView2);

        }
    }

}
