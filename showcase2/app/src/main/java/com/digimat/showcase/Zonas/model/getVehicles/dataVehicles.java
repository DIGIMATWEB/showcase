package com.digimat.showcase.Zonas.model.getVehicles;

import com.google.gson.annotations.SerializedName;

public class dataVehicles {
    @SerializedName("vehicleId")
    
    private String vehicleId;
    @SerializedName("isBot")
    
    private String isBot;
    @SerializedName("speed")
    
    private String speed;
    @SerializedName("comunidad")
    
    private String comunidad;
    @SerializedName("latitude")
    
    private String latitude;
    @SerializedName("longitude")
    
    private String longitude;
    @SerializedName("type")
    
    private String type;
    @SerializedName("gforce")
    
    private String gforce;
    @SerializedName("status")
    
    private String status;
    @SerializedName("orientation")
    
    private String orientation;
    @SerializedName("ultimaConexion")
    
    private String ultimaConexion;
    @SerializedName("path")
    
    private String path;
    @SerializedName("icon")
    
    private String icon;

    public dataVehicles(String vehicleId, String isBot, String speed, String comunidad, String latitude, String longitude, String type, String gforce, String status, String orientation, String ultimaConexion, String path, String icon) {
        super();
        this.vehicleId = vehicleId;
        this.isBot = isBot;
        this.speed = speed;
        this.comunidad = comunidad;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.gforce = gforce;
        this.status = status;
        this.orientation = orientation;
        this.ultimaConexion = ultimaConexion;
        this.path = path;
        this.icon = icon;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getIsBot() {
        return isBot;
    }

    public void setIsBot(String isBot) {
        this.isBot = isBot;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGforce() {
        return gforce;
    }

    public void setGforce(String gforce) {
        this.gforce = gforce;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(String ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
