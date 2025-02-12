package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios;

import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog ;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responseGetServicios {
    @SerializedName("responseCode")
    
    private Integer responseCode;
    @SerializedName("message")
    
    private String message;
    @SerializedName("data")
    
    private List<dataServicesCatalog> data;
    public responseGetServicios(Integer responseCode, String message, List<dataServicesCatalog>  data) {
        super();
        this.responseCode = responseCode;
        this.message = message;
        this.data = data;
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

    public List<dataServicesCatalog>  getData() {
        return data;
    }

    public void setData(List<dataServicesCatalog>  data) {
        this.data = data;
    }
}
