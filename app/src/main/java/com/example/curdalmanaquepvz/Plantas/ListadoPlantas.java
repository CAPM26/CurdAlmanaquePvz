package com.example.curdalmanaquepvz.Plantas;

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
import com.example.curdalmanaquepvz.DAO_JDBC.PlantaDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.PlantaDTO;
import com.example.curdalmanaquepvz.R;

import java.util.ArrayList;

public class ListadoPlantas extends AppCompatActivity {

    ListView ListView;
    ArrayList<String> ListadoPln;

    @Override
    protected void onPostResume() {
        super.onPostResume();
        CargarListadoPlantas();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_plantas);
        ListView = (ListView) findViewById(R.id.lv_plantas);

        CargarListadoPlantas();
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListadoPlantas.this,ListadoPln.get(i), Toast.LENGTH_SHORT).show();
                PlantaDTO plantita = new PlantaDTO();
                plantita.setId_planta(Integer.parseInt(ListadoPln.get(i).split("/")[0]));
                plantita.setNombre_planta(ListadoPln.get(i).split("/")[1]);
                plantita.setTipo_planta(ListadoPln.get(i).split("/")[2]);
                plantita.setFase_desbloqueoPlanta(ListadoPln.get(i).split("/")[3]);
                plantita.setCoste_SolesPlanta(Integer.parseInt(ListadoPln.get(i).split("/")[4]));
                Intent intent = new Intent(ListadoPlantas.this, ModificarPlanta.class);
                intent.putExtra("id", plantita.getId_planta());
                intent.putExtra("nombre", plantita.getNombre_planta());
                intent.putExtra("tipo", plantita.getTipo_planta());
                intent.putExtra("fase", plantita.getFase_desbloqueoPlanta());
                intent.putExtra("coste", plantita.getCoste_SolesPlanta());
                startActivity(intent);
            }
        });

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void CargarListadoPlantas(){
        PlantaDAO_JDBC metodoSelectPl = new PlantaDAO_JDBC();
        ListadoPln = metodoSelectPl.SelectPl(ListadoPlantas.this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListadoPln);
        ListView.setAdapter(adapter);
    }


}