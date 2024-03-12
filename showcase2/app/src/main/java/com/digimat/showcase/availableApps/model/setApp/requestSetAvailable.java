package com.digimat.showcase.availableApps.model.setApp;

import com.google.gson.annotations.SerializedName;

public class requestSetAvailable {
    @SerializedName("available")
    private Integer available;
    @SerializedName("nameApp")
    private String nameApp;

    public requestSetAvailable(Integer available, String nameApp) {
        super();
        this.available = available;
        this.nameApp = nameApp;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getNameApp() {
        return nameApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }
}
