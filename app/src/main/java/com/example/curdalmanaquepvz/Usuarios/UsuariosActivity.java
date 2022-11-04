package com.example.curdalmanaquepvz.Usuarios;

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
import com.example.curdalmanaquepvz.DAO_JDBC.UsuarioDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.UsuarioDTO;
import com.example.curdalmanaquepvz.Plantas.ListadoPlantas;
import com.example.curdalmanaquepvz.Plantas.PlantasActivity;
import com.example.curdalmanaquepvz.R;

public class UsuariosActivity extends AppCompatActivity {

    EditText et_UserName, et_UserPass;
    Button btnGuardarUsuario, btnMostrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        et_UserName = (EditText) findViewById(R.id.et_userName);
        et_UserPass = (EditText) findViewById(R.id.et_userPass);

        btnGuardarUsuario = (Button) findViewById(R.id.btnGuardarUsuario);
        btnMostrarUsuario = (Button) findViewById(R.id.btnMostrarUsuario);

        btnGuardarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDTO usersito = new UsuarioDTO();
                UsuarioDAO_JDBC metodoInsertUs = new UsuarioDAO_JDBC();
                usersito.setUserName(et_UserName.getText().toString());
                usersito.setUserPass(et_UserPass.getText().toString());
                metodoInsertUs.InsertUs(usersito, UsuariosActivity.this);
            }
        });

        btnMostrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsuariosActivity.this, ListadoUsuarios.class));
            }
        });
    }
}