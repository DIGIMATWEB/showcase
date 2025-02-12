package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.presenter;

import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity.dataUpdateServiceComunity;

import java.util.List;

public interface presenterServiciosCrud {
    void getCatalogoServicios();
    void getServiciosComunity();

    void setCatalogServices(List<dataServicesCatalog> catalog);
    void setServicesAvailable(List<dataServicesCatalog> catalog);

    void setServiceOnComunity(int i, String comunity, Integer idService, String nameService);

    void succesUpdate(dataUpdateServiceComunity data);
}
