package com.l.marc.proyecto_1.Registro;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.l.marc.proyecto_1.Login.Login_Fragment;
import com.l.marc.proyecto_1.NavigationHost;
import com.l.marc.proyecto_1.R;

import java.util.Calendar;

public class Registro2 extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private Usuario user;

    private Login_Fragment login;
    private EditText nombre;
    private EditText apellidos;
    private EditText fechaDeNacimiento;
    private Button cancelar;
    private Button registrar;


    private String txtNombre;
    private String txtApellidos;
    private String txtfechaDeNacimiento;

    private int dia;
    private int mes;
    private int año;

    private Calendar calendar;
    private FirebaseAuth mAuth;
    private DatabaseReference bbdd;

    public Registro2() {

    }

    public static Registro2 newInstance(Usuario user) {
        Registro2 fragment = new Registro2();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registro2, container, false);

        calendar = Calendar.getInstance();
        mAuth = FirebaseAuth.getInstance();
        bbdd = FirebaseDatabase.getInstance().getReference("Usuarios");
        nombre = v.findViewById(R.id.et_registro2_nombre);
        apellidos = v.findViewById(R.id.et_registro2_apellidos);
        fechaDeNacimiento = v.findViewById(R.id.et_registro2_fecha);
        fechaDeNacimiento.setOnClickListener(this);

        cancelar = v.findViewById(R.id.btn_registro2_cancelar);
        cancelar.setOnClickListener(this);

        registrar = v.findViewById(R.id.btn_registro2_registrar);
        registrar.setOnClickListener(this);

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
        if (v.getId()==R.id.et_registro2_fecha)
        {
<<<<<<< HEAD
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.DAY_OF_MONTH);


=======
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            año = calendar.get(Calendar.YEAR);
>>>>>>> 5a7df3c48cdda52cc7a501427afc235b2b3eb63f
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            fechaDeNacimiento.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
<<<<<<< HEAD
                    }, dia, mes, año);
=======
                    }, año, mes, dia);
>>>>>>> 5a7df3c48cdda52cc7a501427afc235b2b3eb63f
            datePickerDialog.show();
        }

        if (v.getId()==R.id.btn_registro2_registrar)
        {
            txtNombre = nombre.getText().toString();
            txtApellidos = apellidos.getText().toString();
            txtfechaDeNacimiento = fechaDeNacimiento.getText().toString();
            if (comprobarLosCampos(txtNombre, txtApellidos, txtfechaDeNacimiento))
            {
                crearUsuario(user.getEmail(), user.getApellidos(), user);
                login();
            }

        }
    }

    public boolean comprobarLosCampos(String n, String a, String f)
    {
        if (comprobarNombre(n) && comprobarFecha(f) && comprobarApellidos(a))
        {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean comprobarNombre(String validarNombre)
    {
        if (validarNombre.isEmpty())
        {
            nombre.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else {
            user.setNombre(validarNombre);
            return true;
        }
    }

    private boolean comprobarFecha(String validarFecha)
    {
        if (validarFecha.isEmpty())
        {
            nombre.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else {
            user.setFechaNacimiento(validarFecha);
            return true;
        }
    }

    private boolean comprobarApellidos(String validarApellidos)
    {
        if (validarApellidos.isEmpty())
        {
            nombre.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else {
            user.setApellidos(validarApellidos);
            return true;
        }
    }

    private void crearUsuario(final String email, final String contra, final Usuario user)
    {
        mAuth.createUserWithEmailAndPassword(email, contra)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser userFirebase = mAuth.getCurrentUser();
                            String uid = userFirebase.getUid();
                            datosDeUsuario(uid, user);
                        } else {
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                        }
                    }
                });
    }

    private void datosDeUsuario(String uid, Usuario user)
    {
        bbdd.child(uid).setValue(user);
    }

    private void login()
    {
        login = new Login_Fragment();
        ((NavigationHost) getActivity()).navigateTo(login,false);
    }
}
