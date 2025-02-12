package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios;

public class requestCrudServicios {
    private String token;
    public  requestCrudServicios(String token){
        this.token=token;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
