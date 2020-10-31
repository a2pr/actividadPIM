package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    public  static final int DATABASE_VERSION = 1;
    public static final  String DATABASE_NAME="actividadPim.db";
    public static final String SQL_CREATE_TABLES ="CREATE TABLE Usuarios("+
            "id INT PRIMARY KEY , nome TEXT,email TEXT, password TEXT, admin INT)";

    public static final String SQL_POPULATE_TABLES ="INSERT INTO Usuarios('nome', 'email', 'password', 'admin')"+
            "VALUES('andres', 'andres@gmail.com', 'teste123',0)";
    public static final String SQL_DELETE_TABLES ="DROP TABLE IF EXISTS Usuarios";

    public BancoDeDados(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLES);
        sqLiteDatabase.execSQL(SQL_POPULATE_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLES);
        onCreate(db);
    }
}
