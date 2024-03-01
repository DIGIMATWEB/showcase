package com.digimat.showcase.Menu.models;

import com.google.gson.annotations.SerializedName;

public class requestMenus {
    @SerializedName("userId")
    private String userId;

    public requestMenus(String userId) {
        super();
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
