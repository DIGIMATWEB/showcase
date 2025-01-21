package com.digimat.showcase.Zonas.model.removeZones;

import com.google.gson.annotations.SerializedName;

public class requestRemoveZone {
    @SerializedName("id_zone")
    private Integer idZone;


    public requestRemoveZone(Integer idZone) {
        super();
        this.idZone = idZone;
    }

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
    }
}
