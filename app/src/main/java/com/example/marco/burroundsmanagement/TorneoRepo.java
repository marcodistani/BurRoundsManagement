package com.example.marco.burroundsmanagement;

/**
 * Created by marco on 13/08/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class TorneoRepo {
    private DBHelper dbHelper;

    public TorneoRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Torneo torneo) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Torneo.KEY_name_TORNEO, torneo.name_TORNEO);

        // Inserting Row
        long torneo_Id = db.insert(Torneo.TABLE_TORNEO, null, values);
        db.close(); // Closing database connection
        return (int) torneo_Id;
    }

    public void delete(int torneo_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Torneo.TABLE_TORNEO, Torneo.KEY_ID_TORNEO + "= ?", new String[]{String.valueOf(torneo_Id)});
        db.close(); // Closing database connection
    }

    public void update(Torneo torneo) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Torneo.KEY_name_TORNEO, torneo.name_TORNEO);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Torneo.TABLE_TORNEO, values, Torneo.KEY_ID_TORNEO + "= ?", new String[]{String.valueOf(torneo.torneo_ID)});
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getTorneoList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                Torneo.KEY_ID_TORNEO + "," +
                Torneo.KEY_name_TORNEO + " " +
                " FROM " + Torneo.TABLE_TORNEO;

        ArrayList<HashMap<String, String>> torneoList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> torneo = new HashMap<String, String>();
                torneo.put("id", cursor.getString(cursor.getColumnIndex(Torneo.KEY_ID_TORNEO)));
                torneo.put("name", cursor.getString(cursor.getColumnIndex(Torneo.KEY_name_TORNEO)));
                torneoList.add(torneo);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return torneoList;

    }

    public Torneo getTorneoById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                Torneo.KEY_ID_TORNEO+ "," +
                Torneo.KEY_name_TORNEO + " " +
                " FROM " + Torneo.TABLE_TORNEO
                + " WHERE " +
                Torneo.KEY_ID_TORNEO + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount = 0;
        Torneo torneo = new Torneo();

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});

        if (cursor.moveToFirst()) {
            do {
                torneo.torneo_ID = cursor.getInt(cursor.getColumnIndex(Torneo.KEY_ID_TORNEO));
                torneo.name_TORNEO = cursor.getString(cursor.getColumnIndex(Torneo.KEY_name_TORNEO));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return torneo;
    }
}

