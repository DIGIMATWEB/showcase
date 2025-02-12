package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios;

import com.google.gson.annotations.SerializedName;

public class requestGetServicios {
    @SerializedName("idComunity")
    private Integer idComunity;
    public requestGetServicios(Integer idComunity){
        this.idComunity=idComunity;
    }

    public Integer getIdComunity() {
        return idComunity;
    }

    public void setIdComunity(Integer idComunity) {
        this.idComunity = idComunity;
    }


}
