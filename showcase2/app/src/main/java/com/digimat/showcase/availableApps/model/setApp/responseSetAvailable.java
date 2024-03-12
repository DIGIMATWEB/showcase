package com.digimat.showcase.availableApps.model.setApp;

import com.google.gson.annotations.SerializedName;

public class responseSetAvailable {

    @SerializedName("responseCode")
    private Integer responseCode;
    @SerializedName("message")
    private String message;

    public responseSetAvailable(Integer responseCode, String message) {
        super();
        this.responseCode = responseCode;
        this.message = message;
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

}
