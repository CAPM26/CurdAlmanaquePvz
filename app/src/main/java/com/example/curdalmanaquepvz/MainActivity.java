package com.example.curdalmanaquepvz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.curdalmanaquepvz.Plantas.PlantasActivity;
import com.example.curdalmanaquepvz.Usuarios.UsuariosActivity;
import com.example.curdalmanaquepvz.Zombies.ZombiesActivity;

public class MainActivity extends AppCompatActivity {

    Button vPlantas, vZombies, vUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPlantas = (Button) findViewById(R.id.btnPlantas);
        vZombies = (Button) findViewById(R.id.btnZombies);
        vUsuarios = (Button) findViewById(R.id.btnUsuarios);

        vPlantas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlantasActivity.class);
                startActivity(intent);
            }
        });

        vZombies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ZombiesActivity.class);
                startActivity(intent);
            }
        });

        vUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UsuariosActivity.class);
                startActivity(intent);
            }
        });
    }
}