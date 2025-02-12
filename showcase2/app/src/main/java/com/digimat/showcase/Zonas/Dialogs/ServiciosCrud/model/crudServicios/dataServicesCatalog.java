package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios;

import com.google.gson.annotations.SerializedName;

public class dataServicesCatalog {
    @SerializedName("idService")
    
    private Integer idService;
    @SerializedName("nameServicio")
    
    private String nameService;
    @SerializedName("iconService")
    
    private String iconService;
    @SerializedName("descService")
    
    private String descService;
    @SerializedName("responsable")
    
    private String responsable;
    @SerializedName("contactoService")
    
    private String contactoService;
    @SerializedName("comunityCreator")
    
    private String comunityCreator;


    public dataServicesCatalog(Integer idService, String nameService, String iconService, String descService, String responsable, String contactoService, String comunityCreator) {
        super();
        this.idService = idService;
        this.nameService = nameService;
        this.iconService = iconService;
        this.descService = descService;
        this.responsable = responsable;
        this.contactoService = contactoService;
        this.comunityCreator = comunityCreator;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getIconService() {
        return iconService;
    }

    public void setIconService(String iconService) {
        this.iconService = iconService;
    }

    public String getDescService() {
        return descService;
    }

    public void setDescService(String descService) {
        this.descService = descService;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getContactoService() {
        return contactoService;
    }

    public void setContactoService(String contactoService) {
        this.contactoService = contactoService;
    }

    public String getComunityCreator() {
        return comunityCreator;
    }

    public void setComunityCreator(String comunityCreator) {
        this.comunityCreator = comunityCreator;
    }
}
