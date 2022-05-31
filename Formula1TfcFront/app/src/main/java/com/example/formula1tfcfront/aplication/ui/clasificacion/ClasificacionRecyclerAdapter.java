package com.example.formula1tfcfront.aplication.ui.clasificacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.formula1tfcfront.R;
import com.example.formula1tfcfront.aplication.rest.model.ClasificacionPiloto;
import com.example.formula1tfcfront.aplication.rest.model.Piloto;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ClasificacionRecyclerAdapter extends RecyclerView.Adapter<ClasificacionRecyclerAdapter.ViewHolder>{

    List<ClasificacionPiloto> pilotosList;
    Context context;

    public ClasificacionRecyclerAdapter(List<ClasificacionPiloto> pilotosList, Context context) {
        this.pilotosList = pilotosList;
        this.context = context;
    }


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_clasificacion, parent,false); //false para que no se destruyan

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ClasificacionRecyclerAdapter.ViewHolder holder, int position) {
        ClasificacionPiloto elementoItem = pilotosList.get(position);

        holder.textViewPosicion.setText(elementoItem.getPosicion());
        holder.textViewNombre.setText(elementoItem.getNombrePiloto());
        holder.textViewEscuderia.setText(elementoItem.getEscuderia());
        holder.textViewBandera.setText(elementoItem.getBandera());
        holder.textViewPuntos.setText(elementoItem.getPuntos());

    }

    @Override
    public int getItemCount() {
        return pilotosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPosicion, textViewNombre, textViewEscuderia, textViewBandera, textViewPuntos;
        public ViewHolder(@NonNull @NotNull View itemView) {

            super(itemView);
            textViewPosicion = itemView.findViewById(R.id.textPosicion3);
            textViewNombre = itemView.findViewById(R.id.textNombre3);
            textViewEscuderia = itemView.findViewById(R.id.textEscuderia3);
            textViewBandera = itemView.findViewById(R.id.textBandera3);
            textViewPuntos = itemView.findViewById(R.id.textPuntos3);

        }
    }
}
