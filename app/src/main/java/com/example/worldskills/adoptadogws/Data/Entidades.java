package com.example.worldskills.adoptadogws.Data;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

public class Entidades {

    String id = "id";
    String nombre = "nombre";
    String edad = "edad";
    String raza = "raza";
    String tipo = "tipo";
    String descripcion = "descripcion";
    String imagen = "imagen";

    public Entidades(String nombre, String edad, String raza, String tipo, String descripcion, String imagen) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Entidades(Cursor c) {
        this.id = c.getString(c.getColumnIndex(Relacion.GeneralEntry.ID));
        this.nombre = c.getString(c.getColumnIndex(Relacion.GeneralEntry.NOMBRE));
        this.edad = c.getString(c.getColumnIndex(Relacion.GeneralEntry.EDAD));
        this.raza = c.getString(c.getColumnIndex(Relacion.GeneralEntry.RAZA));
        this.tipo = c.getString(c.getColumnIndex(Relacion.GeneralEntry.TIPO));
        this.descripcion = c.getString(c.getColumnIndex(Relacion.GeneralEntry.DESCRIPCION));
        this.imagen = c.getString(c.getColumnIndex(Relacion.GeneralEntry.IMAGEN));
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Relacion.GeneralEntry.ID, id);
        values.put(Relacion.GeneralEntry.NOMBRE, nombre);
        values.put(Relacion.GeneralEntry.EDAD, edad);
        values.put(Relacion.GeneralEntry.RAZA, raza);
        values.put(Relacion.GeneralEntry.TIPO, tipo);
        values.put(Relacion.GeneralEntry.DESCRIPCION, descripcion);
        values.put(Relacion.GeneralEntry.IMAGEN, imagen);
        return values;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
