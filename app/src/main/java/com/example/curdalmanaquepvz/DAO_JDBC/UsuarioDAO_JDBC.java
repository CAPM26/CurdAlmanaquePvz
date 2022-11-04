package com.example.curdalmanaquepvz.DAO_JDBC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_Interfaces.UsuarioDAO_Interface;
import com.example.curdalmanaquepvz.Dominio.UsuarioDTO;
import com.example.curdalmanaquepvz.Usuarios.ListadoUsuarios;
import com.example.curdalmanaquepvz.Usuarios.ModificarUsuario;
import com.example.curdalmanaquepvz.Usuarios.UsuariosActivity;

import java.util.ArrayList;

public class UsuarioDAO_JDBC implements UsuarioDAO_Interface {
    @Override
    public void InsertUs(UsuarioDTO u, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues c = new ContentValues();
            c.put("userName", u.getUserName());
            c.put("userPass", u.getUserPass());
            db.insert("usuarios",null, c);
            db.close();
            Toast.makeText(contexto, "Usuario insertado", Toast.LENGTH_LONG).show();
        }catch (Exception ex){

            Toast.makeText(contexto, "Error: "+ ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public ArrayList<String> SelectUs(Context contexto) {
        ArrayList<String> datosUsuarios = new ArrayList<String>();
        try {
            DbHelper helper = new DbHelper(contexto);
            SQLiteDatabase db = helper.getReadableDatabase();
            String querito = "select * from usuarios";
            Cursor c = db.rawQuery(querito,null);
            if (c.moveToFirst()){

                do {
                    String linea = c.getInt(0)+"/"+c.getString(1)+"/"+c.getString(2);
                    datosUsuarios.add(linea);

                }while(c.moveToNext());
            }
            db.close();

        }catch (Exception ex){
            Toast.makeText(contexto,"Algo salio mal al mostrar usuarios",Toast.LENGTH_LONG).show();
        }
        return datosUsuarios;
    }

    @Override
    public void UpdateUs(UsuarioDTO u, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {

            String querito = "update usuarios set userName = '"+u.getUserName()+"', userPass = '"+u.getUserPass()+
                    "' where idUsuario = "+u.getIdUsuario();
            db.execSQL(querito);
            db.close();
        }catch (Exception ex){
            Toast.makeText(contexto, "Algo salio mal al modificar",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void DeleteUs(UsuarioDTO u, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {

            String querito = "delete from usuarios where idUsuario = "+u.getIdUsuario();
            db.execSQL(querito);
            db.close();
        }catch (Exception ex){
            Toast.makeText(contexto, "Algo salio mal al eliminar",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int ValidarUser(String uname, String upass, Context contexto) {
        int v = 0;
        try {
            DbHelper helper = new DbHelper(contexto);
            SQLiteDatabase db = helper.getReadableDatabase();
            String querito = "select * from usuarios";
            Cursor c = db.rawQuery(querito,null);

            if (c!=null && c.moveToFirst()){
                do {
                    if(c.getString(1).equals(uname)&&c.getString(2).equals(upass)){
                        v++;
                    }
                }while(c.moveToNext());
            }
            db.close();

        }catch (Exception ex){
            Toast.makeText(contexto,"Algo salio mal al mostrar usuarios",Toast.LENGTH_LONG).show();
        }
        return v;
    }
}
