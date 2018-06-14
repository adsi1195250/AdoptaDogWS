package com.example.worldskills.adoptadogws.Interfaces;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.worldskills.adoptadogws.Data.DBSqlite;
import com.example.worldskills.adoptadogws.Data.Entidades;
import com.example.worldskills.adoptadogws.Interfaces.DetailPerrosFragment;
import com.example.worldskills.adoptadogws.R;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra(PerrosActivity.EXTRA_ID);

        DetailPerrosFragment fragment = (DetailPerrosFragment) getSupportFragmentManager()
                .findFragmentById(R.id.perros_detail_container);
        if (fragment == null){
            fragment = DetailPerrosFragment.newInstance(id);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.perros_detail_container, fragment)
                    .commit();
        }
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
    }
