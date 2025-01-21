package com.digimat.showcase.Zonas.model.removeZones;

import com.google.gson.annotations.SerializedName;

public class responseRemoveZone {

    @SerializedName("responseCode")
    
    private Integer responseCode;
    @SerializedName("message")
    
    private String message;
    @SerializedName("id_zone")
    
    private String idZone;


    public responseRemoveZone(Integer responseCode, String message, String idZone) {
        super();
        this.responseCode = responseCode;
        this.message = message;
        this.idZone = idZone;
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

    public String getIdZone() {
        return idZone;
    }

    public void setIdZone(String idZone) {
        this.idZone = idZone;
    }

}
