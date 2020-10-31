package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UsuarioDAO {

    private SQLiteDatabase bancoDeDados;

    public UsuarioDAO(Context context){
        this.bancoDeDados= (new BancoDeDados(context)).getWritableDatabase();
    }

    public Usuario getUsuario(String login, String password){
        Usuario  usuario= null;
        String sqlQuery = "SELECT * FROM Usuarios WHERE "+
                "email= '"+login+"' AND password = '"+password +"'";
        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);
        if(cursor.moveToNext()){
            usuario = new Usuario(cursor.getString(1),cursor.getString(2),
                    cursor.getString(3) , cursor.getInt(4));
        }

        cursor.close();
        return usuario;
    }

    public boolean addUsuario(Usuario u){

        try{
            String sqlCmd = "INSERT INTO Usuarios VALUES('"+
                    u.getLogin()+"','"+u.getNome()+"','"+
                    u.getPassword()+"','"+u.getAdmin()+"')"
                    ;
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        }catch (SQLException e){
            Log.e("HelloAPPDB", e.getMessage());
            return false;
        }
    }

    public Cursor getUsuarios(){

        return  this.bancoDeDados.rawQuery("SELECT rowid AS _id, "+
                "email, nome, "+
                "CASE WHEN tipo =1 THEN 1 ELSE 0 END AS admin "+
                "FROM Usuarios ORDER BY email",  null
        );
    }

}
