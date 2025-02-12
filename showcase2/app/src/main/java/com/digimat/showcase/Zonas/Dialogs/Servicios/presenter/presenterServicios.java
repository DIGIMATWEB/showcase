package com.digimat.showcase.Zonas.Dialogs.Servicios.presenter;

import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;

import java.util.List;

public interface presenterServicios {
    void getServiciosComunity();
    void setServicesAvailable(List<dataServicesCatalog> catalog);
}
