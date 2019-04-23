package com.l.marc.proyecto_1.Recicler;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.l.marc.proyecto_1.R;

import java.util.List;

/**
 * {@link android.support.v7.widget.RecyclerView.Adapter} para la lista de elementos
 */
public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>
        implements ItemClickListener {
    private final Context context;
    private List<Course> items;


    public CourseAdapter(Context context, List<Course> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new CourseViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder viewHolder, int i) {
        // Item procesado actualmente
        Course currentItem = items.get(i);

        viewHolder.name.setText(currentItem.getName());
        viewHolder.author.setText(currentItem.getAuthor());
        viewHolder.price.setText("$" + currentItem.getPrice());
        viewHolder.rating.setRating(currentItem.getRating());
        viewHolder.students.setText(currentItem.getStudents() + " Estudiantes");
        // Cargar imagen
        Glide.with(context)
                .load(currentItem.getIdImage())
                .into(viewHolder.image);
    }

    @Override
    public void onItemClick(View view, int position) {
        // Imagen a compartir entre transiciones
        View sharedImage = view.findViewById(R.id.image);
        DetailActivity.launch(
                (Activity) context, position, sharedImage);
    }

    /**
     * View holder para reciclar elementos
     */
    public static class CourseViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Views para un curso
        public final TextView name;
        public final TextView author;
        public final TextView price;
        public final RatingBar rating;
        public final TextView students;
        public final ImageView image;

        // Interfaz de comunicación
        public ItemClickListener listener;

        public CourseViewHolder(View v, ItemClickListener listener) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            author = (TextView) v.findViewById(R.id.author);
            price = (TextView) v.findViewById(R.id.price);
            rating = (RatingBar) v.findViewById(R.id.rating);
            students = (TextView) v.findViewById(R.id.students);
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