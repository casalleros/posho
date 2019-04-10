package com.l.marc.proyecto_1.Registro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.l.marc.proyecto_1.R;

public class Registro1 extends Fragment implements View.OnClickListener{
    private EditText userName;
    private EditText passw;
    private EditText repeatPassw;
    private EditText email;
    private Button siguiente;
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registro1, container, false);

        userName = v.findViewById(R.id.et_registro1_userName);
        passw = v.findViewById(R.id.et_registro1_password);
        repeatPassw = v.findViewById(R.id.et_registro1_repeatPassword);
        email = v.findViewById(R.id.et_registro1_email);
        siguiente = v.findViewById(R.id.btn_registro1_siguiente);
        cancelar = v.findViewById(R.id.btn_registro1_cancelar);



        siguiente.setOnClickListener(this);
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
                //pasar los datos a registro2
            }
        }
    }

    private boolean comprobarLosCampos(String nombreUser, String pass, String rPass, String email)
    {
        boolean validado = false;

        if (!nombreUser.isEmpty())
        {
            if (!email.isEmpty())
            {
                if (!pass.isEmpty())
                {
                    if (pass==rPass)
                    {
                        validado = true;
                    }
                }
            }
        }
        return validado;
    }
}
