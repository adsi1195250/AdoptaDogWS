package com.example.worldskills.adoptadogws.Data;

import android.provider.BaseColumns;

public class Relacion {


    public static abstract class GeneralEntry implements BaseColumns {
        public static final String TABLE_NAME = "perro" ;
        public static final String ID = "id" ;
        public static final String NOMBRE = "nombre" ;
        public static final String EDAD = "edad" ;
        public static final String RAZA = "raza" ;
        public static final String TIPO = "tipo" ;
        public static final String DESCRIPCION = "descripcion" ;
        public static final String IMAGEN = "imagen" ;
    }
}
