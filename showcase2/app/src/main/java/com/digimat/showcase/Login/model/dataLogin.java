package com.digimat.showcase.Login.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class dataLogin {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("token")
    private String token;
    @SerializedName("dataMenus")
    private List<dataMenus> mdataMenus;
    public dataLogin(String name, String email, String token,List<dataMenus> mdataMenus) {
        super();
        this.name = name;
        this.email = email;
        this.token = token;
        this.mdataMenus=mdataMenus;
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
    public List<dataMenus> getMdataMenus() {
        return mdataMenus;
    }
    public void setMdataMenus(List<dataMenus> mdataMenus) {
        this.mdataMenus = mdataMenus;
    }

}
