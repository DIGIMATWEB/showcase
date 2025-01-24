package com.digimat.showcase.Zonas.model.getVehicles.savePath;

public class requestSavePath {
    private String vehicleId;
    private String path;

    public requestSavePath(String vehicleId, String path) {
        this.vehicleId=vehicleId;
        this.path = path;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
