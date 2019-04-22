package com.l.marc.proyecto_1.Recycler;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.l.marc.proyecto_1.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> implements ItemClickListener{


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onItemClick(View view, int position) {
        View sharedImage = view.findViewById(R.id.image);
        DetailActivity.launch(
                (Activity) context, position, sharedImage);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Views para un curso
        public final TextView name;
        public final TextView author;
        public final TextView price;
        public final RatingBar rating;
        public final TextView students;
        public final ImageView image;

        // Interfaz de comunicación
        public ItemClickListener listener;

        public RecyclerViewHolder(@NonNull View v, ItemClickListener listener) {
            super(v);
            name = (TextView) v.findViewById(R.id.detail_name);
            author = (TextView) v.findViewById(R.id.detail_author);
            price = (TextView) v.findViewById(R.id.detail_price);
            rating = (RatingBar) v.findViewById(R.id.detail_rating);
            students = (TextView) v.findViewById(R.id.de);
            image = (ImageView) v.findViewById(R.id.image);
            v.setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}
interface ItemClickListener {
    void onItemClick(View view, int position);
}
