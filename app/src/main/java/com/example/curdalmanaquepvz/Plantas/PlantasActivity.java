package com.example.curdalmanaquepvz.Plantas;

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
import com.example.curdalmanaquepvz.DAO_JDBC.PlantaDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.PlantaDTO;
import com.example.curdalmanaquepvz.R;

public class PlantasActivity extends AppCompatActivity {

    EditText et_NombrePlanta, et_TipoPlanta, et_FaseDesbloqueoPlanta, et_CosteSolesPlanta;
    Button btnGuardarPlanta, btnMostrarPlanta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantas);

        et_NombrePlanta = (EditText) findViewById(R.id.et_NombrePlanta);
        et_TipoPlanta = (EditText) findViewById(R.id.et_TipoPlanta);
        et_FaseDesbloqueoPlanta = (EditText) findViewById(R.id.et_FaseDesbloqueoPlanta);
        et_CosteSolesPlanta = (EditText) findViewById(R.id.et_CosteSolesPlanta);

        btnGuardarPlanta = (Button) findViewById(R.id.btnGuardarPlanta);
        btnMostrarPlanta = (Button) findViewById(R.id.btnMostrarPlanta);


        btnGuardarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantaDTO plantita = new PlantaDTO();
                PlantaDAO_JDBC metodoInsertPl = new PlantaDAO_JDBC();
                plantita.setNombre_planta(et_NombrePlanta.getText().toString());
                plantita.setTipo_planta(et_TipoPlanta.getText().toString());
                plantita.setFase_desbloqueoPlanta(et_FaseDesbloqueoPlanta.getText().toString());
                plantita.setCoste_SolesPlanta(Integer.parseInt(et_CosteSolesPlanta.getText().toString()));
                metodoInsertPl.InsertPl(plantita, PlantasActivity.this);
            }
        });

        btnMostrarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlantasActivity.this, ListadoPlantas.class));
            }
        });

    }
}