package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.xml.menu, menu );
        return true;
    }

    public boolean onOptionsItemSelected( MenuItem item){
        switch ( item.getItemId()){
            case R.id.novo:
                // open new intent.
                Intent intent = new Intent(this, Cadastro.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onLogin(View view){

        Intent intent = new Intent(this, home.class);
        EditText newLogin = (EditText)findViewById(R.id.newLogin);
        EditText newSenha = (EditText)findViewById(R.id.newSenha);

        UsuarioDAO usuarioDAO = new UsuarioDAO(this);
        Usuario usuario = usuarioDAO.getUsuario(newLogin.getText().toString(),
                newSenha.getText().toString());

        if(usuario != null){
            intent.putExtra("usuario", usuario);
            Toast.makeText(this, "login made", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else{
            Toast.makeText(this, "login not made", Toast.LENGTH_SHORT).show();
        }
    }
}