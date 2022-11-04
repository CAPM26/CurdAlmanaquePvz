package com.example.curdalmanaquepvz.Zombies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_JDBC.ZombieDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.ZombieDTO;
import com.example.curdalmanaquepvz.Plantas.ListadoPlantas;
import com.example.curdalmanaquepvz.Plantas.ModificarPlanta;
import com.example.curdalmanaquepvz.R;

import java.util.ArrayList;

public class ListadoZombies extends AppCompatActivity {

    ListView ListView;
    ArrayList<String> ListadoZmb;

    @Override
    protected void onPostResume() {
        super.onPostResume();
        CargarListadoZombies();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_zombies);
        ListView = (ListView) findViewById(R.id.lv_zombies);

        CargarListadoZombies();
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListadoZombies.this,ListadoZmb.get(i), Toast.LENGTH_SHORT).show();
                ZombieDTO zombito = new ZombieDTO();
                zombito.setId_zombie(Integer.parseInt(ListadoZmb.get(i).split("/")[0]));
                zombito.setNombre_zombie(ListadoZmb.get(i).split("/")[1]);
                zombito.setDureza_zombie(ListadoZmb.get(i).split("/")[2]);

                Intent intent = new Intent(ListadoZombies.this, ModificarZombie.class);
                intent.putExtra("id", zombito.getId_zombie());
                intent.putExtra("nombre", zombito.getNombre_zombie());
                intent.putExtra("dureza", zombito.getDureza_zombie());
                startActivity(intent);
            }
        });

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void CargarListadoZombies(){
        ZombieDAO_JDBC metodoSelectZm = new ZombieDAO_JDBC();
        ListadoZmb = metodoSelectZm.SelectZm(ListadoZombies.this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListadoZmb);
        ListView.setAdapter(adapter);
    }


}