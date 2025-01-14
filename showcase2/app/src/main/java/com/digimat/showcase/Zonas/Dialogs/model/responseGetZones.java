package com.digimat.showcase.Zonas.Dialogs.model;

import com.digimat.showcase.Zonas.Dialogs.model.dataGetAllZones;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responseGetZones {
    @SerializedName("resconseCode")
    @Expose
    private Integer resconseCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<dataGetAllZones> data = null;

    public responseGetZones(Integer resconseCode, String message, List<dataGetAllZones> data) {
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

    public List<dataGetAllZones> getData() {
        return data;
    }

    public void setData(List<dataGetAllZones> data) {
        this.data = data;
    }

}
