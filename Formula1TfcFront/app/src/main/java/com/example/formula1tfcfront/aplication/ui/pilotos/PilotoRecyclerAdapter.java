package com.example.formula1tfcfront.aplication.ui.pilotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.model.Piloto;

import java.util.List;

public class PilotoRecyclerAdapter extends RecyclerView.Adapter<PilotoRecyclerAdapter.ViewHolder> {
    List<Piloto> pilotosList;
    Context context;

    public PilotoRecyclerAdapter(List<Piloto> pilotosList, Context context) {
        this.pilotosList = pilotosList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_pilotos, parent,false); //false para que no se destruyan

        // ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Piloto elementoItem = pilotosList.get(position);
        holder.textViewNombre.setText(elementoItem.getNombre());
        holder.textViewEdad.setText(elementoItem.getEdad());
        holder.textViewEscuderia.setText(elementoItem.getEscuderia());

        Glide.with(context).load(elementoItem.getImagen()).into(holder.imageViewPiloto);
    }

    @Override
    public int getItemCount() {
        return pilotosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNombre, textViewEdad, textViewEscuderia;
        ImageView imageViewPiloto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.nombrePilotoItem);
            textViewEdad = itemView.findViewById(R.id.edadPilotoItem);
            textViewEscuderia = itemView.findViewById(R.id.escuderiaPilotoItem);
            imageViewPiloto = itemView.findViewById(R.id.imagenPilotoItem);

        }
    }
}
