package com.example.formula1tfcfront.aplication.ui.circuitos;

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
import com.example.formula1tfcfront.aplication.rest.model.Circuito;

import java.util.List;

public class CircuitoRecyclerAdapter extends RecyclerView.Adapter<CircuitoRecyclerAdapter.ViewHolder> {
    List<Circuito> circuitoList;
    Context context;

    public CircuitoRecyclerAdapter(List<Circuito> circuitoList, Context context) {
        this.circuitoList = circuitoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_circuitos, parent,false); //false para que no se destruyan

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Circuito elementoItem = circuitoList.get(position);

        holder.textViewNombre.setText(elementoItem.getNombreCircuito());
        holder.textViewPais.setText(elementoItem.getPais());
        holder.textViewVueltaRapida.setText(elementoItem.getVueltaRapida());
        holder.textViewLongitud.setText(elementoItem.getLongitud());
        Glide.with(context).load(elementoItem.getImagen()).into(holder.imageViewCircuito);
    }

    @Override
    public int getItemCount() {
        return circuitoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre, textViewPais, textViewVueltaRapida, textViewLongitud;
        ImageView imageViewCircuito;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.nombreCircuitoItem);
            textViewPais = itemView.findViewById(R.id.paisCircuitoItem);
            textViewVueltaRapida = itemView.findViewById(R.id.vueltaRapidaItem);
            textViewLongitud = itemView.findViewById(R.id.longitudCircuitoItem);
            imageViewCircuito = itemView.findViewById(R.id.imagenCircuitoItem);
        }
    }
}
