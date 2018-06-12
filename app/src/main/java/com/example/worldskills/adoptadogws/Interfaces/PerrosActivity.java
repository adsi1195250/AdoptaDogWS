package com.example.worldskills.adoptadogws.Interfaces;

/**
 * Created by Anderson on 12-Jun-18.
 */

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.worldskills.adoptadogws.Data.DBSqlite;
import com.example.worldskills.adoptadogws.Data.Relacion;
import com.example.worldskills.adoptadogws.R;
import com.example.worldskills.adoptadogws.adapter.perrosCursorAdapter;
import com.example.worldskills.adoptadogws.Data.Relacion;

public class PerrosActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "extra_id";
    private DBSqlite sqlite;
    private ListView listView;
    private perrosCursorAdapter cursorAdapter;

    public PerrosActivity() {
    }

    public static PerrosActivity newInstance(){return new PerrosActivity();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perros);
        sqlite = new DBSqlite(this);
        listView = findViewById(R.id.listViewPerros);
        cursorAdapter = new perrosCursorAdapter(this,null);

        listView.setAdapter(cursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor c = (Cursor) cursorAdapter.getItem(position);
                String currentId = c.getString(c.getColumnIndex(Relacion.GeneralEntry.ID));
                showDetailtScreen(currentId);
            }
        });

        loadPerros();
    }

    private void showDetailtScreen(String currentId) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_ID, currentId);
        startActivityForResult(intent, 2);
    }

    private class perrosLoadTask extends AsyncTask<Void, Void, Cursor>{
        @Override
        protected Cursor doInBackground(Void... voids) {
            return sqlite.getAllPerros();
        }

    private void loadPerros() {
        new perrosLoadTask().execute();
    }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0){
                cursorAdapter.swapCursor(cursor);

            }else{

            }
        }

    }

    private void showDetailScreen(String currentId) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(PerrosActivity.EXTRA_ID, currentId);
        startActivityForResult(intent, 2);
    }


}