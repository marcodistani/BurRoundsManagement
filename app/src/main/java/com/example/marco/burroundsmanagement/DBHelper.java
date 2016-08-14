package com.example.marco.burroundsmanagement;

/**
 * Created by marco on 13/08/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 5;

    // Database Name
    private static final String DATABASE_NAME = "bur.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here








        //HAVING DIFFERENT TEAMS IN EACH TOURNEAMENT


        String CREATE_TABLE_SQUADRA = "CREATE TABLE" + Squadra.TABLE_SQUADRA + "("
                + Torneo.KEY_ID_TORNEO + "INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Squadra.KEY_ID_SQUADRA + "INTEGER PRIMARY KEY AUTOINCREMENT"
                + Squadra.KEY_name_SQUADRA+ " TEXT )";

        db.execSQL(CREATE_TABLE_SQUADRA);




        String CREATE_TABLE_GIOCATORE = "CREATE TABLE " + Giocatore.TABLE_GIOCATORE  + "("
                + Torneo.KEY_ID_TORNEO + "INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Giocatore.KEY_ID_GIOCATORE  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Giocatore.KEY_name_GIOCATORE + " TEXT )";

        db.execSQL(CREATE_TABLE_GIOCATORE);


        String CREATE_TABLE_TORNEO = "CREATE TABLE " + Torneo.TABLE_TORNEO  + "("
                + Torneo.KEY_ID_TORNEO  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Torneo.KEY_name_TORNEO + " TEXT )";

        db.execSQL(CREATE_TABLE_TORNEO);






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Squadra.TABLE_SQUADRA);

        db.execSQL("DROP TABLE IF EXISTS " + Giocatore.TABLE_GIOCATORE);

        db.execSQL("DROP TABLE IF EXISTS " + Torneo.TABLE_TORNEO);

        // Create tables again
        onCreate(db);

    }

}