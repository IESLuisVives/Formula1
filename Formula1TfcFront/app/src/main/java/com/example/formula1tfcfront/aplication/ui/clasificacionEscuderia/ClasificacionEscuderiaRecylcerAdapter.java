package com.example.formula1tfcfront.aplication.ui.clasificacionEscuderia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.model.ClasificacionEscuderia;
import com.example.formula1tfcfront.aplication.rest.model.ClasificacionPiloto;
import com.example.formula1tfcfront.aplication.ui.clasificacion.ClasificacionRecyclerAdapter;
import org.jetbrains.annotations.NotNull;

import java.time.temporal.Temporal;
import java.util.List;

public class ClasificacionEscuderiaRecylcerAdapter extends RecyclerView.Adapter<ClasificacionEscuderiaRecylcerAdapter.ViewHolder> {
    List<ClasificacionEscuderia> escuderiasList;
    Context context;

    public ClasificacionEscuderiaRecylcerAdapter(List<ClasificacionEscuderia> escuderiasList, Context context) {
        this.escuderiasList = escuderiasList;
        this.context = context;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_clasificacion_escuderias, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClasificacionEscuderia escuderiaItem = escuderiasList.get(position);
        holder.textViewPuntos.setText(String.valueOf(escuderiaItem.getPuntos()));
        holder.textViewEscuderia.setText(escuderiaItem.getNombreEscuderia());
        holder.textViewPosicion.setText(String.valueOf(escuderiaItem.getPosicion()));
    }

    @Override
    public int getItemCount() {
        return escuderiasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPosicion, textViewEscuderia, textViewPuntos;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewPosicion = itemView.findViewById(R.id.tituloItemPosicionClasificacion);
            textViewEscuderia = itemView.findViewById(R.id.tituloItemEscuderiaClasificacion);
            textViewPuntos = itemView.findViewById(R.id.tituloItemPuntosEscuderiaClasificacion);
        }
    }
}
