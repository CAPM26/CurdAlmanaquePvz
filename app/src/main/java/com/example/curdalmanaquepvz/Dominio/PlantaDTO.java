package com.example.curdalmanaquepvz.Dominio;

public class PlantaDTO {

    private int id_planta;
    private String nombre_planta;
    private String tipo_planta;
    private String fase_desbloqueoPlanta;
    private int coste_SolesPlanta;

    public int getId_planta() {
        return id_planta;
    }

    public void setId_planta(int id_planta) {
        this.id_planta = id_planta;
    }

    public String getNombre_planta() {
        return nombre_planta;
    }

    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
    }

    public String getTipo_planta() {
        return tipo_planta;
    }

    public void setTipo_planta(String tipo_planta) {
        this.tipo_planta = tipo_planta;
    }

    public String getFase_desbloqueoPlanta() {
        return fase_desbloqueoPlanta;
    }

    public void setFase_desbloqueoPlanta(String fase_desbloqueoPlanta) {
        this.fase_desbloqueoPlanta = fase_desbloqueoPlanta;
    }

    public int getCoste_SolesPlanta() {
        return coste_SolesPlanta;
    }

    public void setCoste_SolesPlanta(int coste_SolesPlanta) {
        this.coste_SolesPlanta = coste_SolesPlanta;
    }
}
