package com.example.curdalmanaquepvz.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "almanaquePvZ.db";
    public static final String TABLE_PLANTAS = "table_plantas";
    public static final String TABLE_ZOMBIES = "table_zombies";
    public static final String TABLE_USUARIOS = "usuarios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CreateTablePlantas = "CREATE TABLE " + TABLE_PLANTAS + "(" +
                "id_planta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre_planta TEXT," +
                "tipo_planta TEXT," +
                "fase_desbloqueoPlanta TEXT," +
                "coste_solesPlanta INTEGER)";
        String CreateTableZombies = "CREATE TABLE " + TABLE_ZOMBIES + "(" +
                "id_zombie INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre_zombie TEXT," +
                "dureza_zombie TEXT)";
        String CreateTableUsuarios = "CREATE TABLE " + TABLE_USUARIOS + "(" +
                "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userName TEXT," +
                "userPass TEXT)";

        sqLiteDatabase.execSQL(CreateTablePlantas);
        sqLiteDatabase.execSQL(CreateTableZombies);
        sqLiteDatabase.execSQL(CreateTableUsuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PLANTAS  + TABLE_ZOMBIES + TABLE_USUARIOS);
        onCreate(sqLiteDatabase);
    }
}
