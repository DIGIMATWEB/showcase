package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.view;

import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;

import java.util.List;

public interface BottomSheetDialogFragmentView {
    void setCatalogServices(List<dataServicesCatalog> catalog);

    void setServicesAvailable(List<dataServicesCatalog> catalog);

    void succesUpdate();
}
