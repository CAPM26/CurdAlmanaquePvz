package com.example.curdalmanaquepvz.Usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_JDBC.UsuarioDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.UsuarioDTO;
import com.example.curdalmanaquepvz.Plantas.ModificarPlanta;
import com.example.curdalmanaquepvz.R;

public class ModificarUsuario extends AppCompatActivity {

    EditText et_userName, et_userPass;
    Button btnModificarUsuario;
    Button btnEliminarUsuario;
    UsuarioDTO usersito = new UsuarioDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_usuario);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            usersito.setIdUsuario(b.getInt("id"));
            usersito.setUserName(b.getString("nombre"));
            usersito.setUserPass(b.getString("clave"));
        }

        et_userName = (EditText) findViewById(R.id.et_userName);
        et_userPass = (EditText) findViewById(R.id.et_userPass);

        et_userName.setText(usersito.getUserName());
        et_userPass.setText(usersito.getUserPass());


        btnModificarUsuario = (Button) findViewById(R.id.btnModificarUsuario);
        btnEliminarUsuario = (Button) findViewById(R.id.btnEliminarUsuario);

        btnModificarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDTO usersitoModificar = new UsuarioDTO();
                UsuarioDAO_JDBC metodoUpdateUs = new UsuarioDAO_JDBC();

                usersitoModificar.setIdUsuario(usersito.getIdUsuario());
                usersitoModificar.setUserName(et_userName.getText().toString());
                usersitoModificar.setUserPass(et_userPass.getText().toString());

                metodoUpdateUs.UpdateUs(usersitoModificar, ModificarUsuario.this);
                onBackPressed();
                Toast.makeText(ModificarUsuario.this, "Usuario modificado", Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDAO_JDBC metodoDeleteUs = new UsuarioDAO_JDBC();
                metodoDeleteUs.DeleteUs(usersito, ModificarUsuario.this);
                onBackPressed();
                Toast.makeText(ModificarUsuario.this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}