package com.digimat.showcase.Login.model;

import com.google.gson.annotations.SerializedName;

public class dataLogin {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("token")
    private String token;

    public dataLogin(String name, String email, String token) {
        super();
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
