package com.example.curdalmanaquepvz.DAO_Interfaces;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.Dominio.PlantaDTO;

import java.util.ArrayList;

public interface PlantaDAO_Interface {

    public void InsertPl(PlantaDTO p, Context contexto);
    public ArrayList<String> SelectPl(Context contexto);
    public void UpdatePl(PlantaDTO p, Context contexto);
    public void DeletePl(PlantaDTO p, Context contexto);
}
