package com.l.marc.proyecto_1.Perfil;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.l.marc.proyecto_1.Noticies.Adapter_Totes_Noticies;
import com.l.marc.proyecto_1.Noticies.Noticies;
import com.l.marc.proyecto_1.R;

import java.util.List;

public class Adapter_Propies_Noticies extends RecyclerView.Adapter<Adapter_Propies_Noticies.propies_Noticies_ViewHolder>{

    List<Noticies> noticies_propies;

    public Adapter_Propies_Noticies(List<Noticies> noticies_propies) {
        this.noticies_propies = noticies_propies;
    }

    @NonNull
    @Override
    public propies_Noticies_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_propies,viewGroup,false);
        propies_Noticies_ViewHolder holder =new propies_Noticies_ViewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull propies_Noticies_ViewHolder propies_noticies_viewHolder, int i) {

        Noticies noticiess=noticies_propies.get(i);

        propies_noticies_viewHolder.titulo.setText(noticiess.getTitol());
        propies_noticies_viewHolder.descripcio.setText(noticiess.getDescripcio());
        propies_noticies_viewHolder.localitat.setText(noticiess.getLocalitat());
    }

    @Override
    public int getItemCount() {
        return noticies_propies.size();
    }

    public static class propies_Noticies_ViewHolder extends RecyclerView.ViewHolder{

        TextView titulo, descripcio, localitat;

        public propies_Noticies_ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo=itemView.findViewById(R.id.textview_titol_propies);
            descripcio=itemView.findViewById(R.id.textview_descripcio_propies);
            localitat=itemView.findViewById(R.id.textview_localitat_propies);
        }
    }
}
