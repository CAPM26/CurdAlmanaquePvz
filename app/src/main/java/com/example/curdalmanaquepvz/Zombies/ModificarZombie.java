package com.example.curdalmanaquepvz.Zombies;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_JDBC.ZombieDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.ZombieDTO;
import com.example.curdalmanaquepvz.Plantas.ModificarPlanta;
import com.example.curdalmanaquepvz.R;

public class ModificarZombie extends AppCompatActivity {

    EditText et_NombreZombie, et_DurezaZombie;
    Button btnModificarZombie;
    Button btnEliminarZombie;
    ZombieDTO zombito = new ZombieDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_zombie);
        Bundle b = getIntent().getExtras();
        if (b!=null){
            zombito.setId_zombie(b.getInt("id"));
            zombito.setNombre_zombie(b.getString("nombre"));
            zombito.setDureza_zombie(b.getString("dureza"));
        }

        et_NombreZombie = (EditText) findViewById(R.id.et_NombreZombie);
        et_DurezaZombie = (EditText) findViewById(R.id.et_DurezaZombie);

        et_NombreZombie.setText(zombito.getNombre_zombie());
        et_DurezaZombie.setText(zombito.getDureza_zombie());


        btnModificarZombie = (Button) findViewById(R.id.btnModificarZombie);
        btnEliminarZombie = (Button) findViewById(R.id.btnEliminarZombie);

        btnModificarZombie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZombieDTO zombitoModificar = new ZombieDTO();
                ZombieDAO_JDBC metodoUpdateZm = new ZombieDAO_JDBC();

                zombitoModificar.setId_zombie(zombito.getId_zombie());
                zombitoModificar.setNombre_zombie(et_NombreZombie.getText().toString());
                zombitoModificar.setDureza_zombie(et_DurezaZombie.getText().toString());

                metodoUpdateZm.UpdateZm(zombitoModificar, ModificarZombie.this);
                onBackPressed();
                Toast.makeText(ModificarZombie.this, "Zombie modificado", Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminarZombie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZombieDAO_JDBC metotoDeleteZm = new ZombieDAO_JDBC();
                metotoDeleteZm.DeleteZm(zombito, ModificarZombie.this);
                onBackPressed();
                Toast.makeText(ModificarZombie.this, "Zombie eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}