package com.digimat.showcase.Zonas.model.getVehicles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class requestVehicles {
    @SerializedName("token")
    private String token;

    public requestVehicles(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
