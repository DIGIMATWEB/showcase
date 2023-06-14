package com.digimat.showcase.Zonas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class vehiclesRequest {
    @SerializedName("token")
    @Expose
    private String token;

    public vehiclesRequest(String token) {
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