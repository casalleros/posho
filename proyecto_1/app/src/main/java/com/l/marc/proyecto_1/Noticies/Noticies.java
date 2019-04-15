package com.l.marc.proyecto_1.Noticies;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Noticies implements Parcelable {

    private String titol;
    private String descripcio;
    private String autor;
    private String localitat;
    private Date fecha;

    public Noticies(String titol, String descripcio, String autor, String localitat, Date fecha) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.autor = autor;
        this.localitat = localitat;
        this.fecha = fecha;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLocalitat() {
        return localitat;
    }

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    protected Noticies(Parcel in) {
        titol = in.readString();
        descripcio = in.readString();
        autor = in.readString();
        localitat = in.readString();
        long tmpFecha = in.readLong();
        fecha = tmpFecha != -1 ? new Date(tmpFecha) : null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titol);
        dest.writeString(descripcio);
        dest.writeString(autor);
        dest.writeString(localitat);
        dest.writeLong(fecha != null ? fecha.getTime() : -1L);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Noticies> CREATOR = new Parcelable.Creator<Noticies>() {
        @Override
        public Noticies createFromParcel(Parcel in) {
            return new Noticies(in);
        }

        @Override
        public Noticies[] newArray(int size) {
            return new Noticies[size];
        }
    };
}