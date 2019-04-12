package com.l.marc.proyecto_1.Login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.l.marc.proyecto_1.NavigationHost;
import com.l.marc.proyecto_1.R;
import com.l.marc.proyecto_1.Registro.Registro1;
import com.l.marc.proyecto_1.ViewPager.ViewPagerFragment;

public class Login_Fragment extends Fragment implements View.OnClickListener {

    private Button btn_autenticar_login;
    private Button btn_registrar_login;

    private EditText et_correu_login;
    private EditText et_pass_login;

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
                autenticar();
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
}
