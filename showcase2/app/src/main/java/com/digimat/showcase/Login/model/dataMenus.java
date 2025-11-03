package com.digimat.showcase.Login.model;

public class dataMenus {
    private Integer idObject;
    private String nameObject;
    private String iconObject;
    private String descObject;
    private String categoriObject;


    // Full constructor
    public dataMenus(Integer idObject, String nameObject, String iconObject, String descObject, String categoriObject) {
        this.idObject = idObject;
        this.nameObject = nameObject;
        this.iconObject = iconObject;
        this.descObject = descObject;
        this.categoriObject = categoriObject;
    }

    // Getters and setters
    public Integer getIdObject() {
        return idObject;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public String getIconObject() {
        return iconObject;
    }

    public void setIconObject(String iconObject) {
        this.iconObject = iconObject;
    }

    public String getDescObject() {
        return descObject;
    }

    public void setDescObject(String descObject) {
        this.descObject = descObject;
    }

    public String getCategoriObject() {
        return categoriObject;
    }

    public void setCategoriObject(String categoriObject) {
        this.categoriObject = categoriObject;
    }
}
