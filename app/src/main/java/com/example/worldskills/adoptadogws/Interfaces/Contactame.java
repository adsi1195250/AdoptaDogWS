package com.example.worldskills.adoptadogws.Interfaces;

/**
 * Created by Anderson on 12-Jun-18.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class ContactameActivity extends AppCompatActivity
{
    private Spinner spinner;
    TextInputLayout nombre, apellido, mensaje, correo;
    Button boton_enviar;
    TextInputEditText correo_recibe, nombre_recibe, apellido_recibe, mensaje_recibe;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactame);
        spinner = (Spinner) findViewById(R.id.spinner);
        nombre = (TextInputLayout) findViewById(R.id.nombre);
        apellido= (TextInputLayout) findViewById(R.id.apellido);
        correo = (TextInputLayout) findViewById(R.id.correo);

        nombre_recibe = (TextInputEditText) findViewById(R.id.nombreRecibir);
        apellido_recibe = (TextInputEditText) findViewById(R.id.apellidoRecibir);
        mensaje_recibe = (TextInputEditText) findViewById(R.id.mensajeRecibir);
        correo_recibe = (TextInputEditText) findViewById(R.id.correoRecibir);
        mContext = this;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        correo.getEditText();

        ArrayList<String> objects = new ArrayList<>();
        objects.add("Apadrino");
        objects.add("Adopto");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, objects);
        spinner.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                enviarMail();
            }
        });

    }

    public void enviarMail(){

        String nombre, asunto, email, msg;
        nombre = nombre_recibe.getText().toString();
        asunto = spinner.getSelectedItem().toString();
        email = correo_recibe.getText().toString();
        msg = mensaje_recibe.getText().toString();

        String[] TO = {"cajaramillov@gmail.com"};
        String[] CC = {email};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.fromParts("mail to:", email, null));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, msg);
        mContext.startActivity(Intent.createChooser(emailIntent, "Enviar email"));
        Toast.makeText(this, "Gracias por pertenecer y aportar un granito de arena"+ nombre, Toast.LENGTH_SHORT).show();
    }
}
