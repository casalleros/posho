package com.l.marc.proyecto_1.Accions_Noticies;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.l.marc.proyecto_1.NavigationHost;
import com.l.marc.proyecto_1.Noticies.Noticies;
import com.l.marc.proyecto_1.Perfil.Perfil_Tab_Fragment;
import com.l.marc.proyecto_1.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Anadir_Noticia_Fragment extends Fragment {

    private Perfil_Tab_Fragment perfil_tab_fragment;

    private Spinner provincias;
    public EditText titulo;
    public EditText descripcion;
    public Button añadirNoticia;


    private FirebaseAuth mAuth;
    private DatabaseReference bbdd;


    public Anadir_Noticia_Fragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_anadir__noticia_, container, false);
        mAuth = FirebaseAuth.getInstance();
        bbdd = FirebaseDatabase.getInstance().getReference("Noticias");


        provincias=v.findViewById(R.id.spinner_provincias_añadir);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.provincias));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincias.setAdapter(adapter);
        titulo = v.findViewById(R.id.et_titol_añadir);
        descripcion = v.findViewById(R.id.ed_descripcio_añadir);
        añadirNoticia = v.findViewById(R.id.btn_añadirNoticia_añadir);

        añadirNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtTitulo = titulo.getText().toString();
                String txtDescripcion = descripcion.getText().toString();
                String txtCategoria = provincias.getSelectedItem().toString();
                añadirNuevaNoticia(txtTitulo, txtDescripcion, txtCategoria);
            }
        });

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void añadirNuevaNoticia(String titulo, String descripcion, String categoria)
    {
        if (titulo!=null && descripcion!=null && categoria!=null)
        {
            FirebaseUser userFire = mAuth.getCurrentUser();
            String uid = userFire.getUid();

            Date date = new Date();

            String usuario=bbdd.getRef().getRoot().child("usuarios").child(uid).getKey();


            Noticies noticia = new Noticies(titulo, descripcion, usuario, categoria, date);
            bbdd.child(categoria).child(uid).setValue(noticia);

            Toast.makeText(getContext(), "Creado!", Toast.LENGTH_LONG).show();

            perfil_tab_fragment = new Perfil_Tab_Fragment();
            ((NavigationHost) getActivity()).navigateTo(perfil_tab_fragment,true);
        }
        else
        {
            Toast.makeText(getContext(), "No se puede dejar espacios en blanco", Toast.LENGTH_LONG).show();
        }
    }


}
