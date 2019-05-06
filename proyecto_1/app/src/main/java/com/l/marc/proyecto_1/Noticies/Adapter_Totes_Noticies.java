package com.l.marc.proyecto_1.Noticies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.l.marc.proyecto_1.R;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter_Totes_Noticies extends RecyclerView.Adapter<Adapter_Totes_Noticies.NoticiesViewHolder>{

    List<Noticies> noticies;

    public Adapter_Totes_Noticies(List<Noticies> noticies) {
        this.noticies = noticies;
    }

    @NonNull
    @Override
    public NoticiesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        NoticiesViewHolder holder =new NoticiesViewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticiesViewHolder noticiesViewHolder, int i) {

        Noticies noticiess=noticies.get(i);

        noticiesViewHolder.autor.setText(noticiess.getAutor());
        noticiesViewHolder.titulo.setText(noticiess.getTitol());
        noticiesViewHolder.descripcio.setText(noticiess.getDescripcio());
        noticiesViewHolder.localitat.setText(noticiess.getLocalitat());
    }

    @Override
    public int getItemCount() {
        return noticies.size();
    }

    public static class NoticiesViewHolder extends RecyclerView.ViewHolder{

        TextView autor, titulo, descripcio, localitat;
        public NoticiesViewHolder(@NonNull View itemView) {
            super(itemView);

            autor=itemView.findViewById(R.id.textview_autor);
            titulo=itemView.findViewById(R.id.textview_titol);
            descripcio=itemView.findViewById(R.id.textview_descripcio);
            localitat=itemView.findViewById(R.id.textview_localitat);

        }
    }
}
