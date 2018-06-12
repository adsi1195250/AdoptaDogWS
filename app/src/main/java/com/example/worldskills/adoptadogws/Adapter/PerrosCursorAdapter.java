package com.example.worldskills.adoptadogws.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.adoptadogws.Data.Relacion;
import com.example.worldskills.adoptadogws.R;

public class PerrosCursorAdapter extends CursorAdapter {
    public PerrosCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //return inflater.inflate(R.layout.card_view, parent);
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor c) {
        //TextView nombreText = view.findViewById(R.id.)
        //TextView edadText = view.findViewById(R.id.)
        //TextView razaText = view.findViewById(R.id.)
        //TextView tipoText = view.findViewById(R.id.)
        //final ImageView imageView = view.findViewById(R.id.id_imagen)


        String nombre = c.getString(c.getColumnIndex(Relacion.GeneralEntry.NOMBRE));
        String edad = c.getString(c.getColumnIndex(Relacion.GeneralEntry.EDAD));
        String raza = c.getString(c.getColumnIndex(Relacion.GeneralEntry.RAZA));
        String tipo = c.getString(c.getColumnIndex(Relacion.GeneralEntry.TIPO));
        String imagen = c.getString(c.getColumnIndex(Relacion.GeneralEntry.IMAGEN));

    }
}
