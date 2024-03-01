package com.digimat.showcase.Splash.model;

import com.google.gson.annotations.SerializedName;

public class requestSplash {
    @SerializedName("token")
    private Integer token;

    public requestSplash(Integer token) {
        super();
        this.token = token;
    }

    public Integer getUserToken() {
        return token;
    }

    public void setUserToken(Integer userId) {
        this.token = token;
    }

}
