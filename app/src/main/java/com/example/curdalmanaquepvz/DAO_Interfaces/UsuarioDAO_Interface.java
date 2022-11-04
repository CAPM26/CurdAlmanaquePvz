package com.example.curdalmanaquepvz.DAO_Interfaces;

import android.content.Context;

import com.example.curdalmanaquepvz.Dominio.UsuarioDTO;

import java.util.ArrayList;

public interface UsuarioDAO_Interface {

    public void InsertUs(UsuarioDTO u, Context contexto);
    public ArrayList<String> SelectUs(Context contexto);
    public void UpdateUs(UsuarioDTO u, Context contexto);
    public void DeleteUs(UsuarioDTO u, Context contexto);
    public int ValidarUser(String uname, String upass, Context contexto);
}
