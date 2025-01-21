package com.digimat.showcase.Zonas.model.getUsers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class usersResponse {
    @SerializedName("resconseCode")
    @Expose
    private Integer resconseCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<dataFullUsers> data = null;

    public usersResponse(Integer resconseCode, String message, List<dataFullUsers> data) {
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

    public List<dataFullUsers> getData() {
        return data;
    }

    public void setData(List<dataFullUsers> data) {
        this.data = data;
    }

}