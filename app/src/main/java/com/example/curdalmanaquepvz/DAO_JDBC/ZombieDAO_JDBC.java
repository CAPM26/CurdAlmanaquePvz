package com.example.curdalmanaquepvz.DAO_JDBC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_Interfaces.ZombieDAO_Interface;
import com.example.curdalmanaquepvz.Dominio.ZombieDTO;
import com.example.curdalmanaquepvz.Zombies.ListadoZombies;
import com.example.curdalmanaquepvz.Zombies.ModificarZombie;
import com.example.curdalmanaquepvz.Zombies.ZombiesActivity;

import java.util.ArrayList;

public class ZombieDAO_JDBC implements ZombieDAO_Interface {
    @Override
    public void InsertZm(ZombieDTO z, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues c = new ContentValues();
            c.put("nombre_zombie", z.getNombre_zombie());
            c.put("dureza_zombie", z.getDureza_zombie());
            db.insert("table_zombies",null, c);
            db.close();
            Toast.makeText(contexto, "Zombie Insertado", Toast.LENGTH_LONG).show();
        }catch (Exception ex){

            Toast.makeText(contexto, "Error: "+ ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public ArrayList<String> SelectZm(Context contexto) {
        ArrayList<String> datosZombies = new ArrayList<String>();
        try {
            DbHelper helper = new DbHelper(contexto);
            SQLiteDatabase db = helper.getReadableDatabase();
            String querito = "select * from table_zombies";
            Cursor c = db.rawQuery(querito,null);
            if (c.moveToFirst()){

                do {
                    String linea = c.getInt(0)+"/"+c.getString(1)+"/"+c.getString(2);
                    datosZombies.add(linea);

                }while(c.moveToNext());
            }
            db.close();

        }catch (Exception ex){
            Toast.makeText(contexto,"Algo salio mal al mostrar zombies",Toast.LENGTH_LONG).show();
        }
        return datosZombies;
    }

    @Override
    public void UpdateZm(ZombieDTO z, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {

            String querito = "update table_zombies set nombre_zombie = '"+z.getNombre_zombie()+"', dureza_zombie = '"+z.getDureza_zombie()+
                    "' where id_zombie = "+z.getId_zombie();
            db.execSQL(querito);
            db.close();
        }catch (Exception ex){
            Toast.makeText(contexto, "Algo salio mal al modificar",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void DeleteZm(ZombieDTO z, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {

            String querito = "delete from table_zombies where id_zombie = "+z.getId_zombie();
            db.execSQL(querito);
            db.close();
        }catch (Exception ex){
            Toast.makeText(contexto, "Algo salio mal al eliminar",Toast.LENGTH_SHORT).show();
        }
    }
}
