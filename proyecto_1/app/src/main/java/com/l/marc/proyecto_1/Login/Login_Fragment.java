package com.l.marc.proyecto_1.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.l.marc.proyecto_1.NavigationHost;
import com.l.marc.proyecto_1.R;
import com.l.marc.proyecto_1.Registro.Registro1;
import com.l.marc.proyecto_1.ViewPager.ViewPagerFragment;

public class Login_Fragment extends Fragment implements View.OnClickListener {
    private FirebaseAuth mAuth;

    private Button btn_autenticar_login;
    private Button btn_registrar_login;

    private EditText et_correu_login;
    private EditText et_pass_login;

    String correo;
    String contraseña;

    private Registro1 Registre_Fragment;
    private ViewPagerFragment viewPagerFragment;


    public Login_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login_, container, false);

        mAuth = FirebaseAuth.getInstance();

        btn_autenticar_login=v.findViewById(R.id.btn_autenticar_login);
        btn_registrar_login=v.findViewById(R.id.btn_registrar_login);

        et_correu_login=v.findViewById(R.id.et_correu_login);
        et_pass_login=v.findViewById(R.id.et_pass_login);

        btn_autenticar_login.setOnClickListener(this);
        btn_registrar_login.setOnClickListener(this);


        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_autenticar_login:
                correo = et_correu_login.getText().toString();
                contraseña = et_pass_login.getText().toString();

                autentificacionUser(correo, contraseña);
                break;
            case R.id.btn_registrar_login:
                registro();
                break;
        }
    }

    private void autenticar() {
        viewPagerFragment = new ViewPagerFragment();
        ((NavigationHost) getActivity()).navigateTo(viewPagerFragment,true);//Que fasil!
    }

    private void registro() {
        Registre_Fragment = new Registro1();
        ((NavigationHost) getActivity()).navigateTo(Registre_Fragment,true);//Que fasil!
    }

    private void autentificacionUser(String email, String contraseña)
    {
        mAuth.signInWithEmailAndPassword(email, contraseña)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            autenticar();
                        } else {
                            Toast.makeText(getContext(), "Comprueba de que has introducido correctamente los datos", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
