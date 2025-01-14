package com.digimat.showcase.Zonas.Dialogs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class zoneRequest {
    @SerializedName("token")
    @Expose
    private String token;

    public zoneRequest(String token) {
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
