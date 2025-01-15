package com.digimat.showcase.Zonas.Dialogs.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class dataGetAllZones {

    @SerializedName("zoneId")
    
    private String zoneId;
    @SerializedName("zoneName")
    
    private String zoneName;
    @SerializedName("descZone")

    private String descZone;
    @SerializedName("ratio")
    
    private String ratio;
    @SerializedName("dots")
    
    private List<dotZonesm> dotZoness;

    public dataGetAllZones(String zoneId, String zoneName,String descZone, String ratio, List<dotZonesm> dotZoness) {
        super();
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.descZone =descZone;
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

    public String getDescZone() {
        return descZone;
    }

    public void setDescZone(String descZone) {
        this.descZone = descZone;
    }

    public List<dotZonesm> getDotZoness() {
        return dotZoness;
    }

    public void setDotZoness(List<dotZonesm> dotZoness) {
        this.dotZoness = dotZoness;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

}
