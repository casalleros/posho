package com.l.marc.proyecto_1.Perfil;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.l.marc.proyecto_1.Accions_Noticies.Anadir_Noticia_Fragment;
import com.l.marc.proyecto_1.NavigationHost;
import com.l.marc.proyecto_1.Noticies.Noticies;
import com.l.marc.proyecto_1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Perfil_Tab_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Perfil_Tab_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perfil_Tab_Fragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Anadir_Noticia_Fragment anadir_noticia_fragment;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;

    private Button AñadirNoticia;
    private OnFragmentInteractionListener mListener;

    private List<Noticies> noticies;

    private Adapter_Propies_Noticies adapter_propies_noticies;

    public Perfil_Tab_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Perfil_Tab_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Perfil_Tab_Fragment newInstance(String param1, String param2) {
        Perfil_Tab_Fragment fragment = new Perfil_Tab_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_perfil__tab_, container, false);
        AñadirNoticia=v.findViewById(R.id.btn_añadir_noticia_perfil);
        AñadirNoticia.setOnClickListener(this);

        recyclerView=v.findViewById(R.id.recicler_propies);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        noticies=new ArrayList<>();

        adapter_propies_noticies=new Adapter_Propies_Noticies(noticies);

        recyclerView.setAdapter(adapter_propies_noticies);

        FirebaseDatabase bbdd=FirebaseDatabase.getInstance();
        bbdd.getReference().getRoot().child("Noticies").child("Asturias").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                noticies.removeAll(noticies);

                for (DataSnapshot datasnaphot:
                    dataSnapshot.getChildren() ) {

                    Noticies noticies1=datasnaphot.getValue(Noticies.class);
                    noticies.add(noticies1);
                }
                adapter_propies_noticies.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_añadir_noticia_perfil){
            anadir_noticia_fragment = new Anadir_Noticia_Fragment();
            ((NavigationHost) getActivity()).navigateTo(anadir_noticia_fragment,true);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
