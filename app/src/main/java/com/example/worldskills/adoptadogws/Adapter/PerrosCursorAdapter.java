package com.example.worldskills.adoptadogws.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.worldskills.adoptadogws.Data.Relacion;
import com.example.worldskills.adoptadogws.R;

public class PerrosCursorAdapter extends CursorAdapter {
    public PerrosCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.cardview_perros, parent);

    }

    @Override
    public void bindView(View view, final Context context, Cursor c) {
        TextView nombreText = view.findViewById(R.id.id_nombre);
        TextView edadText = view.findViewById(R.id.id_edad);
        TextView razaText = view.findViewById(R.id.id_raza);
        TextView tipoText = view.findViewById(R.id.id_tipo);
        final ImageView imageView = view.findViewById(R.id.id_imagen);


        String nombre = c.getString(c.getColumnIndex(Relacion.GeneralEntry.NOMBRE));
        String edad = c.getString(c.getColumnIndex(Relacion.GeneralEntry.EDAD));
        String raza = c.getString(c.getColumnIndex(Relacion.GeneralEntry.RAZA));
        String tipo = c.getString(c.getColumnIndex(Relacion.GeneralEntry.TIPO));
        String imagen = c.getString(c.getColumnIndex(Relacion.GeneralEntry.IMAGEN));


        nombreText.setText(nombre);
        edadText.setText(edad);
        razaText.setText(raza);
        tipoText.setText(tipo);
        Glide
                .with(context)
                .load(Uri.parse("file:///android_asset/" + imagen))
                .asBitmap()
                .centerCrop()
                .error(R.drawable.ic_menu_send)
                .into(new BitmapImageViewTarget(imageView){
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);

                        imageView.setImageDrawable(drawable);
                    }
                });
    }
}
