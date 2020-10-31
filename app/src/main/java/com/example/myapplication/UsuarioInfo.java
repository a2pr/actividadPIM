package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

public class UsuarioInfo extends AppCompatActivity {

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_info);

        Intent intent = getIntent();
        this.usuario = (Usuario) intent.getSerializableExtra("usuario");
        Log.i("HelloDebug", this.usuario.getLogin());

        TextView textUsuario = (TextView) findViewById(R.id.usuarioView);
        textUsuario.setText(Html.fromHtml("<h2>Nome </h2>"+ "<p>"+this.usuario.getNome()+"</p>"
                +"<h2>Email </h2>"+ "<p>"+this.usuario.getLogin()+"</p>"
                +"<h2>Admin </h2>"+ "<p>"+this.usuario.isAdmin()+"</p>")
        );
    }
}