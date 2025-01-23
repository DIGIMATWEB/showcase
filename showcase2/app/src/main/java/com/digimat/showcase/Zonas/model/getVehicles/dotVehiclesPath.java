package com.digimat.showcase.Zonas.model.getVehicles;

import com.google.gson.annotations.SerializedName;

public class dotVehiclesPath {
    @SerializedName("Latitud")

    private String latitud;
    @SerializedName("Longitud")

    private String longitud;


    public dotVehiclesPath(String latitud, String longitud) {
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
