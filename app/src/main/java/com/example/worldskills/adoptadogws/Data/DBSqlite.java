package com.example.worldskills.adoptadogws.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSqlite extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "perros.db";

    public DBSqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s ( " +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT ) ",
                Relacion.GeneralEntry.TABLE_NAME, Relacion.GeneralEntry._ID, Relacion.GeneralEntry.ID,
                Relacion.GeneralEntry.NOMBRE, Relacion.GeneralEntry.EDAD, Relacion.GeneralEntry.RAZA,
                Relacion.GeneralEntry.TIPO, Relacion.GeneralEntry.DESCRIPCION, Relacion.GeneralEntry.IMAGEN
        ));

        loadPerros(db);
    }

    private void loadPerros(SQLiteDatabase db) {
        insertPerros(db, new Entidades("Sacha", "2 años", "Labrador", "Hembra",
                "Perra muy linda y obediente","sacha.jpg"));
        insertPerros(db, new Entidades("Negra", "10 Meses", "No definido", "Hembra",
                "Esterilizada y vacunada, tamaño mediano pequeño","negra.jpg"));
        insertPerros(db, new Entidades("Linda", "6 Meses", "No definido", "Hembra",
                "Esterilizada y vacunada, para adopción","linda.jpg"));
        insertPerros(db, new Entidades("Canu", "14 Años", "Cruce Yorkshire", "Macho",
                "Canu sólo ha conocido a una dueña en 14 años, pero al final, ha perdido a su compañera humana y el pobre tiene que buscar otro hogar.\n" +
                "Se lleva bien con niños, con perros, hace sus necesidades en la calle y a pesar de su edad tiene Vuena" +
                "salud. Es muy cariñoso y tranquilo. ADÓPTALO!!!","kanu.jpg"));
        insertPerros(db, new Entidades("Bizcocho", "2 Meses", "Cruce de Grifon", "Macho", "Mojicon, Bizcocho, Bica, Magdalena y Roscón estaban en un mercadillo, no paseando, si no que estaban siendo vendidos por unos indigentes, los cuales habían tirado a su mama a la basura. " +
                "Por suerte una familia los recogió y nos ha pedido ayuda","bizcocho.jpg"));
        insertPerros(db, new Entidades("Cati", "4 Meses y 3 días", "Cruce de aguas","Hembra", "Cati y Encarni son dos preciosas perritas, cruce de perro de aguas.\n" +
                "Estaban en la perrera y por suerte, an sido sacadas de allí. Unos cachorritos, no tendrían que pasar tan mal trago." +
                "Necesitan un hogar donde las quieran y las mimen.", "cati.jpg"));
        insertPerros(db, new Entidades("Encarni", "4 Meses y 3 días", "Cruce de aguas", "Hembra", "Cati y Encarni son dos preciosas perritas, cruce de perro de aguas.\n" +
                "Estaban en la perrera y por suerte, an sido sacadas de allí. Unos cachorritos, no tendrían que pasar tan mal trago.\n" +
                "Necesitan un hogar donde las quieran y las mimen.","encarni.jpg"));
        insertPerros(db, new Entidades("Curro", "2 años y 3 Meses", "Cruce mediano", "Macho", "Curro casi le mata su dueño de una paliza a palos y luego fue llevado a la perra, es solo un perro de dos años que desde que ha empezado su vida, ha sido maltratado, humillado, necesita acogida urgente o adopción, donde se le enseñe lo que es el cariño, una caricia, salir de paseo empezar a vivir la vida .¿Quieres ser tú?\n",
                "curro.jpg"));
        insertPerros(db, new Entidades("Magdalena", "1 Meses y 21 días", "Cruce de Grifon", "Hembra", "Mojicon, Bizcocho, Bica, Magdalena y Roscón estaban en un mercadillo, no paseando, si no que estaban siendo vendidos por unos indigentes, los cuales habían tirado a su mama a la basura. Por suerte una familia los recogió y nos ha pedido ayuda\n",
                "magdalena.jpg"));
        insertPerros(db, new Entidades("Roscon", "1 Meses y 21 días", "Cruce de Grifon", "macho", "Mojicon, Bizcocho, Bica, Magdalena y Roscón estaban en un mercadillo, no paseando, si no que estaban siendo vendidos por unos indigentes, los cuales habían tirado a su mama a la basura. Por suerte una familia los recogió y nos ha pedido ayuda\n",
                "roscon.jpg"));
    }

    private long insertPerros(SQLiteDatabase db, Entidades entidades) {
        return db.insert(Relacion.GeneralEntry.TABLE_NAME,
                null, entidades.toContentValues());
    }

    public Cursor getAllPerros(){
        return getReadableDatabase().query(
                Relacion.GeneralEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }


    public Cursor getByIdPerros(String perrosId){
        Cursor c =  getReadableDatabase().query(
                Relacion.GeneralEntry.TABLE_NAME,
                null,
                Relacion.GeneralEntry.ID + " LIKE ?",
                new String[]{perrosId},
                null,
                null,
                null
        );
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(String.format("DROP´DATABASE IF EXITS " + Relacion.GeneralEntry.TABLE_NAME));
        this.onCreate(db);
    }
}
