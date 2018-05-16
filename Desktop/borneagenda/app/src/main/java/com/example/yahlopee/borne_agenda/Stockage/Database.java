package com.example.yahlopee.borne_agenda.Stockage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.yahlopee.borne_agenda.modeles.Cours;

import java.util.HashMap;
import java.util.Map;


public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "projetLpSmin";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String requete = "CREATE table IF NOT EXISTS cours( id integer primary key autoincrement," +
                                                            " name text not null," +
                                                            " uid text unique not null," +
                                                            " salle text not null," +
                                                            " professeur text not null," +
                                                            " groupe text not null," +
                                                            " dateDebut text not null, " +
                                                            " dateFin text not null)";
        db.execSQL(requete);
        Log.i("Database onCreate()", "onCreate: Create database ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String requete = "Drop table cours";
        db.execSQL(requete);
        this.onCreate(db);
        Log.i("Database onUpgrade()", "onUpgrade: Upgrade database ");
    }


    public void insertCours(Cours c )
    {
        String requete = "INSERT INTO cours(name, uid, salle, professeur, groupe, dateDebut, dateFin)" +
                         " VALUES ('"+c.getName()+
                         "','"+c.getUid()+
                         "','"+c.getSalle()+
                         "','"+c.getProfesseur()+
                         "','"+c.getGroupe()+
                         "','"+c.getDateDebut().toString()+
                         "','"+c.getDateFin().toString()+"')";
        this.getWritableDatabase().execSQL(requete);
        Log.i("Database Insert", "insertCours: Insert INTO cours");
    }

    public void deleteCours(Cours c)
    {
        String requete = "DELETE FROM cours WHERE uid ='"+c.getUid()+"'";
        this.getWritableDatabase().execSQL(requete);
    }


    public void updateCours(String uid, HashMap<String, String> values)
    {
        String requete = "UPDATE cours SET ";
        for (Map.Entry me : values.entrySet()) {
            requete += me.getKey()+" = '"+me.getValue()+"',";
        }
        if(requete.endsWith(","))
        {
            requete.replace((char)requete.charAt(requete.length()-1), ' ');
        }
        this.getWritableDatabase().execSQL(requete);
    }
    /*public void updateCours(Cours c)
    {
        String requete = "UPDATE cours SET name = '"+c.getName()+"', ";
    }*/

}
