package com.l.marc.proyecto_1.Registro;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private String nombre;
    private String nombreUser;
    private String apellidos;
    private String email;
    private String fechaNacimiento;
    private String contraseña;

    public Usuario()
    {

    }

    public Usuario(String nombre, String nombreUser, String apellidos, String email, String fechaNacimiento, String contraseña) {
        this.nombre = nombre;
        this.nombreUser = nombreUser;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public static Creator<Usuario> getCREATOR() {
        return CREATOR;
    }

    protected Usuario(Parcel in) {
        nombre = in.readString();
        nombreUser = in.readString();
        apellidos = in.readString();
        email = in.readString();
        fechaNacimiento = in.readString();
        contraseña = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(nombreUser);
        dest.writeString(apellidos);
        dest.writeString(email);
        dest.writeString(fechaNacimiento);
        dest.writeString(contraseña);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}

