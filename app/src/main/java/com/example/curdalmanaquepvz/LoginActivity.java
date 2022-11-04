package com.example.curdalmanaquepvz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curdalmanaquepvz.DAO_JDBC.UsuarioDAO_JDBC;

public class LoginActivity extends AppCompatActivity {

    EditText et_UserNameLogin, et_UserPassLogin;
    Button btnLoginUsers;
    UsuarioDAO_JDBC validarUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_UserNameLogin = (EditText) findViewById(R.id.et_userNameLogin);
        et_UserPassLogin = (EditText) findViewById(R.id.et_userPassLogin);
        btnLoginUsers = (Button) findViewById(R.id.btnLoginUsers);
        validarUser = new UsuarioDAO_JDBC();


        btnLoginUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = et_UserNameLogin.getText().toString();
                String upass = et_UserPassLogin.getText().toString();
                if(uname.equals("")&&upass.equals("")){
                    Toast.makeText(LoginActivity.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }else if(validarUser.ValidarUser(uname, upass, LoginActivity.this)>=1){
                    Toast.makeText(LoginActivity.this, "BIENVENIDO", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "USUARIO Y/O CLAVE INCORRECTOS", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}