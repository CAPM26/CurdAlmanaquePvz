package com.example.curdalmanaquepvz.DAO_Interfaces;

import android.content.Context;

import com.example.curdalmanaquepvz.Dominio.ZombieDTO;

import java.util.ArrayList;

public interface ZombieDAO_Interface {

    public void InsertZm(ZombieDTO z, Context contexto);
    public ArrayList<String> SelectZm(Context contexto);
    public void UpdateZm(ZombieDTO z, Context contexto);
    public void DeleteZm(ZombieDTO z, Context contexto);
}
