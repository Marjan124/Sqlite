package com.example.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1,ed2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.name);
        ed2=findViewById(R.id.cls);
        b=findViewById(R.id.button_save);

        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String n=ed1.getText().toString();
        String c=ed2.getText().toString();

        DbHelper dbHelper = new DbHelper(MainActivity.this);

        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Table.COLUMN_NAME_TITLE, n);
        values.put(Table.COLUMN_NAME_SUBTITLE, c);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Table.TABLE_NAME, null, values);
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        Intent i=new Intent(MainActivity.this, Recyc.class);
        startActivity(i);








       /* SQLiteDatabase db1 = dbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Table.COLUMN_NAME_TITLE,
                Table.COLUMN_NAME_SUBTITLE
        };

// Filter results WHERE "title" = 'My Title'
        String selection = Table.COLUMN_NAME_TITLE + " Name";
        String[] selectionArgs = { "Name" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                Table.COLUMN_NAME_SUBTITLE + " Class";

        Cursor cursor = db1.query(
                Table.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );*/

    }
}
