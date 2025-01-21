package com.digimat.showcase.Zonas.model.updateZones;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responseUpdateZone {
    @SerializedName("responseCode")
    
    private Integer responseCode;
    @SerializedName("message")
    
    private String message;
    @SerializedName("Ratio")
    
    private Integer ratio;
    @SerializedName("dots")
    
    private List<dotZonesm> dots;
    @SerializedName("descZone")
    
    private String descZone;

    public responseUpdateZone(Integer responseCode, String message, Integer ratio, List<dotZonesm> dots, String descZone) {
        super();
        this.responseCode = responseCode;
        this.message = message;
        this.ratio = ratio;
        this.dots = dots;
        this.descZone = descZone;
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

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    public List<dotZonesm> getdotZonesms() {
        return dots;
    }

    public void setdotZonesms(List<dotZonesm> dots) {
        this.dots = dots;
    }

    public String getDescZone() {
        return descZone;
    }

    public void setDescZone(String descZone) {
        this.descZone = descZone;
    }
}
