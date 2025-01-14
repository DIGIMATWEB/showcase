package com.digimat.showcase.Zonas.Dialogs.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class dataGetAllZones {

    @SerializedName("zoneId")
    
    private String zoneId;
    @SerializedName("zoneName")
    
    private String zoneName;
    @SerializedName("ratio")
    
    private String ratio;
    @SerializedName("dotZoness")
    
    private List<dotZones> dotZoness;


    public dataGetAllZones(String zoneId, String zoneName, String ratio, List<dotZones> dotZoness) {
        super();
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.ratio = ratio;
        this.dotZoness = dotZoness;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public List<dotZones> getdotZoness() {
        return dotZoness;
    }

    public void setdotZoness(List<dotZones> dotZoness) {
        this.dotZoness = dotZoness;
    }

}
