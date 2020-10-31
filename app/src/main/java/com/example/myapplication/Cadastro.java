package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void onCadastro(View view){
        EditText inputEmail = (EditText)findViewById(R.id.idNovoEmail);
        EditText inputNome = (EditText)findViewById(R.id.idNovoNome);
        EditText inputSenha = (EditText)findViewById(R.id.idNovoSenha);

        Usuario usuario = new Usuario( inputEmail.getText().toString(),
                inputNome.getText().toString(),
                inputSenha.getText().toString(),
                0
        );

        UsuarioDAO usuarioDAO = new UsuarioDAO(this);

        if(usuarioDAO.addUsuario(usuario)){
            Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Erro ao Cadastrar", Toast.LENGTH_SHORT).show();
        }
    }
}