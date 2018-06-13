package com.example.worldskills.adoptadogws.Interfaces;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.worldskills.adoptadogws.Data.DBSqlite;
import com.example.worldskills.adoptadogws.Data.Entidades;
import com.example.worldskills.adoptadogws.R;


public class DetailPerrosFragment extends Fragment {
    private static final String ARG_ID = "currentId";
    private String mPerrosId;
    private TextView nombre;
    private TextView edad;
    private TextView raza;
    private TextView tipo;
    private TextView descripcion;
    private ImageView imagen;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private DBSqlite sqlite;

    public DetailPerrosFragment() {
        // Required empty public constructor
    }

    public static DetailPerrosFragment newInstance(String perrosId) {
        DetailPerrosFragment fragment = new DetailPerrosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ID, perrosId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPerrosId = getArguments().getString(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_perros, container, false);
        sqlite = new DBSqlite(getActivity());
        nombre = view.findViewById(R.id.idnombre);
        edad = view.findViewById(R.id.idedad);
        raza = view.findViewById(R.id.idraza);
        tipo = view.findViewById(R.id.idtipo);
        //descripcion = view.findViewById(R.id.iddescripcion);
        //collapsingToolbarLayout = view.findViewById(R.id.colla)
        loadPerros();

        return view;

    }

    private void loadPerros() {
        new loadPerrosTask();
    }

    private class loadPerrosTask extends AsyncTask<Void, Void, Cursor>{
        @Override
        protected Cursor doInBackground(Void... voids) {
            return sqlite.getByIdPerros(mPerrosId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()){
                showPerros(new Entidades(cursor));
            }
            else {
                loadError();
            }
        }
    }

    private void loadError() {
        Toast.makeText(getActivity(), "Error al cargar el detalle", Toast.LENGTH_SHORT).show();
    }

    private void showPerros(Entidades entidades) {
        nombre.setText(entidades.getNombre());
        edad.setText(entidades.getEdad());
        raza.setText(entidades.getRaza());
        tipo.setText(entidades.getTipo());
        descripcion.setText(entidades.getDescripcion());
        Glide
                .with(getActivity())
                .load("file:///android_asset/"+ entidades.getImagen())
                .asBitmap()
                .centerCrop()
                .into(imagen);
    }
}
