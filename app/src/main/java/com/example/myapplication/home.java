package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.xml.menu_home, menu );
        return true;
    }

    public boolean onOptionsItemSelected( MenuItem item){
        switch ( item.getItemId()){
            case R.id.info:
                // open new intent.
                Intent intent = new Intent(this, UsuarioInfo.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void buyIngresso(View view){
        Toast.makeText(this, "Comprando ingresso", Toast.LENGTH_SHORT).show();
    }
}