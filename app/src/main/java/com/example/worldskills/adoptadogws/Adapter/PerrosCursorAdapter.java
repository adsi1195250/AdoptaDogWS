package com.example.worldskills.adoptadogws.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

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
    public void bindView(View view, Context context, Cursor cursor) {
        //TextView nombreText = view.findViewById(R.id.)
    }
}
