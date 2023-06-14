package com.digimat.showcase.Zonas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class vehiclesResponse {
    @SerializedName("resconseCode")
    @Expose
    private Integer resconseCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<dataFullVehicles> data = null;

    public vehiclesResponse(Integer resconseCode, String message, List<dataFullVehicles> data) {
        super();
        this.resconseCode = resconseCode;
        this.message = message;
        this.data = data;
    }

    public Integer getResconseCode() {
        return resconseCode;
    }

    public void setResconseCode(Integer resconseCode) {
        this.resconseCode = resconseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<dataFullVehicles> getData() {
        return data;
    }

    public void setData(List<dataFullVehicles> data) {
        this.data = data;
    }

}