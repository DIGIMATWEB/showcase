package com.digimat.showcase.Zonas.Dialogs.model;

import com.google.gson.annotations.SerializedName;

public class dotZones {

    @SerializedName("Latitud")
    
    private String latitud;
    @SerializedName("Longitud")
    
    private String longitud;


    public dotZones(String latitud, String longitud) {
        super();
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
