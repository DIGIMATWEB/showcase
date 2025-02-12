package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.presenter;

import android.content.Context;

import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.interactor.interactorServiciosCrud;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.interactor.interactorServiciosCrudImpl;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity.dataUpdateServiceComunity;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.view.BottomSheetDialogFragmentView;

import java.util.List;

public class presenterServiciosCrudImpl implements  presenterServiciosCrud{
    private BottomSheetDialogFragmentView view;
    private Context context;
    private interactorServiciosCrud interactor;
    public presenterServiciosCrudImpl(BottomSheetDialogFragmentView view,Context context){
        this.view=view;
        this.context=context;
        interactor=new interactorServiciosCrudImpl(this,context);
    }
    @Override
    public void getCatalogoServicios() {
        if(view!=null){
            interactor.getCatalogoServicios();
        }
    }

    @Override
    public void getServiciosComunity() {
        if(view!=null){
            interactor.getServiciosComunity();
        }
    }

    @Override
    public void setServiceOnComunity(int i, String comunity, Integer idService, String nameService) {
        if(view!=null){
            interactor.setServiceOnComunity(i,comunity,idService,nameService);
        }
    }

    @Override
    public void succesUpdate(dataUpdateServiceComunity data) {
        if(view!=null){
            view.succesUpdate();
        }
    }

    @Override
    public void setCatalogServices(List<dataServicesCatalog> catalog) {
        if(view!=null){
            view.setCatalogServices(catalog);
        }
    }

    @Override
    public void setServicesAvailable(List<dataServicesCatalog> catalog) {
        if(view!=null){
            view.setServicesAvailable(catalog);

        }
    }

}
