package com.digimat.showcase.Zonas.model.updateZones;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class requestUpdateZones {
    @SerializedName("idzone")
    private Integer idzone;
    @SerializedName("nameZone")
    private String name;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("radio")
    private Integer radio;
    @SerializedName("puntos")
    private List<dotZonesm> dotZonesms;

    public requestUpdateZones(Integer idzone, String descripcion, Integer radio, List<dotZonesm> dotZonesms, String name) {
        super();
        this.idzone = idzone;
        this.descripcion = descripcion;
        this.radio = radio;
        this.dotZonesms = dotZonesms;
        this.name=name;
    }

    public Integer getIdzone() {
        return idzone;
    }

    public void setIdzone(Integer idzone) {
        this.idzone = idzone;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    public List<dotZonesm> getdotZonesms() {
        return dotZonesms;
    }

    public void setdotZonesms(List<dotZonesm> dotZonesms) {
        this.dotZonesms = dotZonesms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
