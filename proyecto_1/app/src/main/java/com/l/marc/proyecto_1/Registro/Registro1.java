package com.l.marc.proyecto_1.Registro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.l.marc.proyecto_1.Login.Login_Fragment;
import com.l.marc.proyecto_1.NavigationHost;
import com.l.marc.proyecto_1.R;

public class Registro1 extends Fragment implements View.OnClickListener{
    private Login_Fragment login_fragment;
    private Registro2 registro2;

    private EditText userName;
    private EditText passw;
    private EditText repeatPassw;
    private EditText email;
    private Button seguent;
    private Button cancelar;

    private Usuario user;

    String txtUser;
    String txtPassw;
    String txtRepeatPassw;
    String txtEmail;


    public Registro1() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_registro1, container, false);

        userName = v.findViewById(R.id.et_registro1_userName);
        passw = v.findViewById(R.id.et_registro1_password);
        repeatPassw = v.findViewById(R.id.et_registro1_repeatPassword);
        email = v.findViewById(R.id.et_registro1_email);
        seguent = v.findViewById(R.id.btn_registro1_siguiente);
        cancelar = v.findViewById(R.id.btn_registro1_cancelar);

        user = new Usuario();

        seguent.setOnClickListener(this);
        cancelar.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_registro1_siguiente)
        {
            txtUser = userName.getText().toString();
            txtPassw = passw.getText().toString();
            txtRepeatPassw = repeatPassw.getText().toString();
            txtEmail = email.getText().toString();

            if(comprobarLosCampos(txtUser, txtPassw, txtRepeatPassw, txtEmail))
            {
                registro2 = Registro2.newInstance(user);
                ((NavigationHost) getActivity()).navigateTo(registro2,true);
            }
            else
            {
                Log.d("TAG", "no entre al if");
            }
        }
        if (v.getId()==R.id.btn_registro1_cancelar)
        {
            login_fragment = new Login_Fragment();
            ((NavigationHost) getActivity()).navigateTo(login_fragment,true);
        }
    }

    private boolean comprobarLosCampos(String nombreUser, String pass, String rPass, String emailD)
    {
        if (comprobarNombreUser(nombreUser) && comprobarEmail(emailD) && comprobarContraseñas(pass, rPass))
        {
            return true;
        }
        else
        {
            Toast.makeText(getContext(), "Comproba els camps", Toast.LENGTH_LONG).show();
            return false;
        }

    }

    private boolean comprobarNombreUser(String validarNombre)
    {
        if (validarNombre.isEmpty())
        {
            userName.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else {
            user.setNombreUser(validarNombre);
            return true;
        }
    }

    private boolean comprobarEmail(String validarEmail)
    {
        if (validarEmail.isEmpty())
        {
            email.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else {
            user.setEmail(validarEmail);
            return true;
        }
    }

    private boolean comprobarContraseñas(String contra, String repeatContra)
    {
        if (contra.isEmpty())
        {
            passw.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else if (repeatContra.isEmpty())
        {
            repeatPassw.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else{
            user.setContraseña(contra);
            return true;
        }
    }
}
