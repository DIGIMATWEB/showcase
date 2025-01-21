package com.digimat.showcase.Zonas.model.getUsers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class usersRequest {
    @SerializedName("token")
    @Expose
    private String token;

    public usersRequest(String token) {
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