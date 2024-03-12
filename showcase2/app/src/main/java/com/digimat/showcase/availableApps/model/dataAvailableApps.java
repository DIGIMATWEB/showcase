
package com.digimat.showcase.availableApps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class dataAvailableApps {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nameApp")
    @Expose
    private String nameApp;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("available")
    @Expose
    private String available;

    public dataAvailableApps(String id, String nameApp, String version, String available) {
        super();
        this.id = id;
        this.nameApp = nameApp;
        this.version = version;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameApp() {
        return nameApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

}
