package com.digimat.showcase.Zonas.model.getVehicles.savePath;

import com.digimat.showcase.Zonas.model.getVehicles.dataVehicles;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responseSavePath {
    @SerializedName("responseCode")

    private Integer responseCode;
    @SerializedName("message")

    private String message;
    @SerializedName("data")
    private String data;
    public responseSavePath(Integer responseCode, String message, String data) {
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
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
