package com.DIGIMAT.Showcase.Zonas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class dataFullVehicles {


    @SerializedName("mVehicleId")
    @Expose
    private String mVehicleId;
    @SerializedName("mVehicleLat")
    @Expose
    private String mVehicleLat;
    @SerializedName("mVehiclelong")
    @Expose
    private String mVehiclelong;
    @SerializedName("mVehicleType")
    @Expose
    private String mVehicleType;
    @SerializedName("mVehiclegForce")
    @Expose
    private String mVehiclegForce;
    @SerializedName("mVehicleStatus")
    @Expose
    private String mVehicleStatus;
    @SerializedName("mVehicleTrayectory")
    @Expose
    private String mVehicleTrayectory;

    public dataFullVehicles(String mVehicleId, String mVehicleLat, String mVehiclelong, String mVehicleType, String mVehiclegForce, String mVehicleStatus, String mVehicleTrayectory) {
        super();
        this.mVehicleId = mVehicleId;
        this.mVehicleLat = mVehicleLat;
        this.mVehiclelong = mVehiclelong;
        this.mVehicleType = mVehicleType;
        this.mVehiclegForce = mVehiclegForce;
        this.mVehicleStatus = mVehicleStatus;
        this.mVehicleTrayectory = mVehicleTrayectory;
    }

    public String getmVehicleId() {
        return mVehicleId;
    }

    public void setmVehicleId(String mVehicleId) {
        this.mVehicleId = mVehicleId;
    }

    public String getmVehicleLat() {
        return mVehicleLat;
    }

    public void setmVehicleLat(String mVehicleLat) {
        this.mVehicleLat = mVehicleLat;
    }

    public String getmVehiclelong() {
        return mVehiclelong;
    }

    public void setmVehiclelong(String mVehiclelong) {
        this.mVehiclelong = mVehiclelong;
    }

    public String getmVehicleType() {
        return mVehicleType;
    }

    public void setmVehicleType(String mVehicleType) {
        this.mVehicleType = mVehicleType;
    }

    public String getmVehiclegForce() {
        return mVehiclegForce;
    }

    public void setmVehiclegForce(String mVehiclegForce) {
        this.mVehiclegForce = mVehiclegForce;
    }

    public String getmVehicleStatus() {
        return mVehicleStatus;
    }

    public void setmVehicleStatus(String mVehicleStatus) {
        this.mVehicleStatus = mVehicleStatus;
    }

    public String getmVehicleTrayectory() {
        return mVehicleTrayectory;
    }

    public void setmVehicleTrayectory(String mVehicleTrayectory) {
        this.mVehicleTrayectory = mVehicleTrayectory;
    }

}