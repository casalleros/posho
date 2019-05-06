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
import android.widget.Toast;

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

import static android.content.ContentValues.TAG;

public class Registro2 extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private Usuario user;

    private Login_Fragment login;
    private EditText nom;
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
        nom = v.findViewById(R.id.et_registro2_nombre);
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
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            fechaDeNacimiento.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, dia, mes, año);
            datePickerDialog.show();
        }

        if (v.getId()==R.id.btn_registro2_registrar)
        {
            txtNombre = nom.getText().toString();
            txtApellidos = apellidos.getText().toString();
            txtfechaDeNacimiento = fechaDeNacimiento.getText().toString();
            if (comprobarLosCampos(txtNombre, txtApellidos, txtfechaDeNacimiento))
            {
                user.setNombre(txtNombre);
                user.setApellidos(txtApellidos);
                user.setFechaNacimiento(txtfechaDeNacimiento);
                crearUsuario();
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
            nom.setError(getString(R.string.EspacioEnBlanco));
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
            nom.setError(getString(R.string.EspacioEnBlanco));
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
            nom.setError(getString(R.string.EspacioEnBlanco));
            return false;
        }
        else {
            user.setApellidos(validarApellidos);
            return true;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    private void crearUsuario()
    {
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getContraseña())
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser userFire = mAuth.getCurrentUser();
                            String uid = userFire.getUid();
                            datosDeUsuario(uid, user);
                            Toast.makeText(getContext(), "Usuario guardado", Toast.LENGTH_LONG).show();
                            login();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                            updateUI(null);
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
