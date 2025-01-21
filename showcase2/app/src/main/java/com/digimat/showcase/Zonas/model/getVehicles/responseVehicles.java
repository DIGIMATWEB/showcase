package com.digimat.showcase.Zonas.model.getVehicles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responseVehicles {
    @SerializedName("responseCode")
   
    private Integer responseCode;
    @SerializedName("message")
   
    private String message;
    @SerializedName("data")
   
    private List<dataVehicles> data;


    public responseVehicles(Integer responseCode, String message, List<dataVehicles> data) {
        super();
        this.responseCode = responseCode;
        this.message = message;
        this.data = data;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<dataVehicles> getData() {
        return data;
    }

    public void setData(List<dataVehicles> data) {
        this.data = data;
    }

}
