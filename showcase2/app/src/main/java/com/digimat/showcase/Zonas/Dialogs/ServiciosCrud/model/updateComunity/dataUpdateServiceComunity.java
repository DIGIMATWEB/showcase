package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity;

import com.google.gson.annotations.SerializedName;

public class dataUpdateServiceComunity {
    @SerializedName("idComunity")
    
    private Integer idComunity;
    @SerializedName("nameComunity")
    
    private String nameComunity;
    @SerializedName("idServicioPublico")
    
    private Integer idServicioPublico;
    @SerializedName("nameServicio")
    
    private String nameServicio;

    public dataUpdateServiceComunity(Integer idComunity, String nameComunity, Integer idServicioPublico, String nameServicio) {
        super();
        this.idComunity = idComunity;
        this.nameComunity = nameComunity;
        this.idServicioPublico = idServicioPublico;
        this.nameServicio = nameServicio;
    }

    public Integer getIdComunity() {
        return idComunity;
    }

    public void setIdComunity(Integer idComunity) {
        this.idComunity = idComunity;
    }

    public String getNameComunity() {
        return nameComunity;
    }

    public void setNameComunity(String nameComunity) {
        this.nameComunity = nameComunity;
    }

    public Integer getIdServicioPublico() {
        return idServicioPublico;
    }

    public void setIdServicioPublico(Integer idServicioPublico) {
        this.idServicioPublico = idServicioPublico;
    }

    public String getNameServicio() {
        return nameServicio;
    }

    public void setNameServicio(String nameServicio) {
        this.nameServicio = nameServicio;
    }

}
