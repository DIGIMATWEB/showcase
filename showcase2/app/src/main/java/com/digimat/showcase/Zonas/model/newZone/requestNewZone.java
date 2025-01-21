package com.digimat.showcase.Zonas.model.newZone;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class requestNewZone {
    @SerializedName("nombreZona")
    
    private String nombreZona;
    @SerializedName("descripcion")
    
    private String descripcion;
    @SerializedName("radio")
    
    private Integer radio;
    @SerializedName("puntos")
    private List<dotZonesm> puntos;


    public requestNewZone(String nombreZona, String descripcion, Integer radio, List<dotZonesm> puntos) {
        super();
        this.nombreZona = nombreZona;
        this.descripcion = descripcion;
        this.radio = radio;
        this.puntos = puntos;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    public List<dotZonesm> getdotZonesms() {
        return puntos;
    }

    public void setdotZonesms(List<dotZonesm> puntos) {
        this.puntos = puntos;
    }
}
