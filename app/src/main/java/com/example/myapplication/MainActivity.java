package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCadastrar(View view){
        EditText newLogin = (EditText)findViewById(R.id.newLogin);
        EditText newSenha = (EditText)findViewById(R.id.newSenha);
        EditText newNome = (EditText)findViewById(R.id.newNome);


    }
}