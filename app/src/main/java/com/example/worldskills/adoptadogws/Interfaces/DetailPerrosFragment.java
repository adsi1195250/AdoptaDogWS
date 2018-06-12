package com.example.worldskills.adoptadogws.Interfaces;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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


        return view;

    }
}
