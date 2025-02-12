package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.interactor;

public interface interactorServiciosCrud {
    void getCatalogoServicios();

    void getServiciosComunity();

    void setServiceOnComunity(int i, String comunity, Integer idService, String nameService);
}
