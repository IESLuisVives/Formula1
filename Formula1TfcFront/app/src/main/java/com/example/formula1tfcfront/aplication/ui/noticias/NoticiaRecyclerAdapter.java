package com.example.formula1tfcfront.aplication.ui.noticias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.model.Noticia;
import com.bumptech.glide.Glide;
import java.util.List;

public class NoticiaRecyclerAdapter extends RecyclerView.Adapter<NoticiaRecyclerAdapter.ViewHolder> {

    //declarar las variables
    List<Noticia> noticiaList;
    Context context;

    //generamos el constructor

    public NoticiaRecyclerAdapter(List<Noticia> noticiaList, Context context) {
        this.noticiaList = noticiaList;
        this.context = context;
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


        Noticia elementoItem = noticiaList.get(position);

        holder.textViewTitulo.setText(elementoItem.getTitulo());
        Glide.with(context)
                .load(elementoItem.getImagen())
                .into(holder.imageViewFoto);
    }

    @Override
    public int getItemCount() {
        //metodo que devuelve el numero de elementos de la lista
        return noticiaList.size();
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
            imageViewFoto = itemView.findViewById(R.id.imageView2);

        }
    }

}
