package com.example.spinnerdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper dbAss = new DatabaseHelper(this);
        MyDB db = new MyDB(this);
        Spinner desplegable = (Spinner) this.findViewById(R.id.spinnerCategories);

        Cursor cur = db.selectRecords("_id AS _id, Nombres AS Nombres", "Categoria3","");
        startManagingCursor(cur);
        String[] from = new String[]{"Nombres"};
        int[] to = new int[]{android.R.id.text1};
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cur, from, to);
        desplegable.setAdapter(mAdapter);

    }
}

