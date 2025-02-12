package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity;

import com.google.gson.annotations.SerializedName;

public class responseUpdateServiceComunity {

    @SerializedName("responseCode")
   
    private Integer responseCode;
    @SerializedName("message")
   
    private String message;
    @SerializedName("data")
   
    private dataUpdateServiceComunity data;


    public responseUpdateServiceComunity(Integer responseCode, String message, dataUpdateServiceComunity data) {
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

    public dataUpdateServiceComunity getData() {
        return data;
    }

    public void setData(dataUpdateServiceComunity data) {
        this.data = data;
    }
}
