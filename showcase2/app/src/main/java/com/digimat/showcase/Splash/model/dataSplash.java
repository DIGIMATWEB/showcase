package com.digimat.showcase.Splash.model;

import com.google.gson.annotations.SerializedName;

public class dataSplash {

    @SerializedName("backgroundColor")
    private String backgroundColor;
    @SerializedName("backgroundImage")
    private String backgroundImage;
    @SerializedName("logo")
    private String logo;
    @SerializedName("mVehicleType")
    private String mVehicleType;
    public dataSplash(String backgroundColor, String backgroundImage, String logo, String mVehicleType) {
        super();
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.logo = logo;
        this.mVehicleType = mVehicleType;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getmVehicleType() {
        return mVehicleType;
    }

    public void setmVehicleType(String mVehicleType) {
        this.mVehicleType = mVehicleType;
    }

}
