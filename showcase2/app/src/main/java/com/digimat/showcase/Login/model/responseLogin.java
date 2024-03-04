package com.digimat.showcase.Login.model;

import com.google.gson.annotations.SerializedName;

public class responseLogin {
    @SerializedName("resconseCode")
    private Integer resconseCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private dataLogin data;

    public responseLogin(Integer resconseCode, String message, dataLogin data) {
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

    public dataLogin getData() {
        return data;
    }

    public void setData(dataLogin data) {
        this.data = data;
    }

}
