package com.example.curdalmanaquepvz.Zombies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_JDBC.ZombieDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.ZombieDTO;
import com.example.curdalmanaquepvz.Plantas.ListadoPlantas;
import com.example.curdalmanaquepvz.Plantas.PlantasActivity;
import com.example.curdalmanaquepvz.R;

public class ZombiesActivity extends AppCompatActivity {

    EditText et_NombreZombie, et_DurezaZombie;
    Button btnGuardarZombie, btnMostrarZombie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zombies);

        et_NombreZombie = (EditText) findViewById(R.id.et_NombreZombie);
        et_DurezaZombie = (EditText) findViewById(R.id.et_DurezaZombie);

        btnGuardarZombie = (Button) findViewById(R.id.btnGuardarZombie);
        btnMostrarZombie = (Button) findViewById(R.id.btnMostrarZombie);

        btnGuardarZombie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZombieDTO zombito = new ZombieDTO();
                ZombieDAO_JDBC metodoInsertZm = new ZombieDAO_JDBC();

                zombito.setNombre_zombie(et_NombreZombie.getText().toString());
                zombito.setDureza_zombie(et_DurezaZombie.getText().toString());

                metodoInsertZm.InsertZm(zombito, ZombiesActivity.this);
            }
        });

        btnMostrarZombie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ZombiesActivity.this, ListadoZombies.class));
            }
        });
    }

}