package com.example.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recyc extends AppCompatActivity {
    RecyclerView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyc);

        r = findViewById(R.id.recyclerview_tasks);
        r.setLayoutManager(new LinearLayoutManager(this));


        getall();//here after we are coding for fetch from javatpoint
    }

    public List<Model> getall() {  //model class
        List<Model> Tablelist = new ArrayList<Model>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Table.TABLE_NAME; //Table is already created for the fields

        DbHelper dbHelper = new DbHelper(Recyc.this);//we need to make object called dbhelper
        SQLiteDatabase db =dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setName((cursor.getString(0)));
                model.setCls(cursor.getString(1));

                // Adding contact to list
                Tablelist.add(model);
            } while (cursor.moveToNext());

            TaskAdapter adapter = new TaskAdapter(Recyc.this,Tablelist);
            r.setAdapter(adapter);

        }
        return Tablelist;
    }
}






