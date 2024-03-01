package com.digimat.showcase.Splash.model;

import com.google.gson.annotations.SerializedName;

public class responseSplash {
    @SerializedName("resconseCode")
    private Integer resconseCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private dataSplash data;
    public responseSplash(Integer resconseCode, String message, dataSplash data) {
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

    public dataSplash getData() {
        return data;
    }

    public void setData(dataSplash data) {
        this.data = data;
    }

}
