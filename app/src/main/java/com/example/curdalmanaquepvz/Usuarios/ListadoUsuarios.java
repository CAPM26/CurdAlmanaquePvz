package com.example.curdalmanaquepvz.Usuarios;

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
import com.example.curdalmanaquepvz.DAO_JDBC.UsuarioDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.UsuarioDTO;
import com.example.curdalmanaquepvz.Plantas.ListadoPlantas;
import com.example.curdalmanaquepvz.Plantas.ModificarPlanta;
import com.example.curdalmanaquepvz.R;

import java.util.ArrayList;

public class ListadoUsuarios extends AppCompatActivity {

    ListView ListView;
    ArrayList<String> ListadoUsr;

    @Override
    protected void onPostResume() {
        super.onPostResume();
        CargarListadoUsuarios();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);
        ListView = (ListView) findViewById(R.id.lv_usuarios);

        CargarListadoUsuarios();
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListadoUsuarios.this,ListadoUsr.get(i), Toast.LENGTH_SHORT).show();
                UsuarioDTO usersito = new UsuarioDTO();
                usersito.setIdUsuario(Integer.parseInt(ListadoUsr.get(i).split("/")[0]));
                usersito.setUserName(ListadoUsr.get(i).split("/")[1]);
                usersito.setUserPass(ListadoUsr.get(i).split("/")[2]);

                Intent intent = new Intent(ListadoUsuarios.this, ModificarUsuario.class);
                intent.putExtra("id", usersito.getIdUsuario());
                intent.putExtra("nombre", usersito.getUserName());
                intent.putExtra("clave", usersito.getUserPass());
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

    private void CargarListadoUsuarios(){
        UsuarioDAO_JDBC metodoSelectUs = new UsuarioDAO_JDBC();
        ListadoUsr = metodoSelectUs.SelectUs(ListadoUsuarios.this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListadoUsr);
        ListView.setAdapter(adapter);
    }
}