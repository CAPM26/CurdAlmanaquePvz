package com.example.curdalmanaquepvz.DAO_JDBC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_Interfaces.PlantaDAO_Interface;
import com.example.curdalmanaquepvz.Dominio.PlantaDTO;
import com.example.curdalmanaquepvz.Plantas.ListadoPlantas;
import com.example.curdalmanaquepvz.Plantas.ModificarPlanta;
import com.example.curdalmanaquepvz.Plantas.PlantasActivity;

import java.util.ArrayList;

public class PlantaDAO_JDBC implements PlantaDAO_Interface {
    @Override
    public void InsertPl(PlantaDTO p, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues c = new ContentValues();
            c.put("nombre_planta", p.getNombre_planta());
            c.put("tipo_planta", p.getTipo_planta());
            c.put("fase_desbloqueoPlanta", p.getFase_desbloqueoPlanta());
            c.put("coste_solesPlanta", p.getCoste_SolesPlanta());
            db.insert("table_plantas",null, c);
            db.close();
            Toast.makeText(contexto, "Planta Insertada", Toast.LENGTH_LONG).show();
        }catch (Exception ex){

            Toast.makeText(contexto, "Error: "+ ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public ArrayList<String> SelectPl(Context contexto) {
        ArrayList<String> datosPlantas = new ArrayList<String>();
        try {
            DbHelper helper = new DbHelper(contexto);
            SQLiteDatabase db = helper.getReadableDatabase();
            String querito = "select * from table_plantas";
            Cursor c = db.rawQuery(querito,null);
            if (c.moveToFirst()){

                do {
                    String linea = c.getInt(0)+"/"+c.getString(1)+"/"+c.getString(2)+"/"+c.getString(3)+"/"+c.getInt(4);
                    datosPlantas.add(linea);

                }while(c.moveToNext());
            }
            db.close();

        }catch (Exception ex){
            Toast.makeText(contexto,"Algo salio mal al mostrar plantas",Toast.LENGTH_LONG).show();
        }
        return datosPlantas;
    }

    @Override
    public void UpdatePl(PlantaDTO p, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {

            String querito = "update table_plantas set nombre_planta = '" + p.getNombre_planta() + "', tipo_planta = '" + p.getTipo_planta() +
                    "', fase_desbloqueoPlanta = '" + p.getFase_desbloqueoPlanta() + "', coste_solesPlanta = '" + p.getCoste_SolesPlanta() +
                    "' where id_planta = "+p.getId_planta();
            db.execSQL(querito);
            db.close();
        }catch (Exception ex){
            Toast.makeText(contexto, "Algo salio mal al modificar",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void DeletePl(PlantaDTO p, Context contexto) {
        DbHelper helper = new DbHelper(contexto);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {

            String querito = "delete from table_plantas where id_planta = "+p.getId_planta();
            db.execSQL(querito);
            db.close();
        }catch (Exception ex){
            Toast.makeText(contexto, "Algo salio mal al eliminar",Toast.LENGTH_SHORT).show();
        }
    }
}
