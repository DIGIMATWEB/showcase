package com.digimat.showcase.Zonas.Dialogs.Servicios.presenter;

import android.content.Context;

import com.digimat.showcase.Zonas.Dialogs.Servicios.interactor.interactorServicios;
import com.digimat.showcase.Zonas.Dialogs.Servicios.interactor.interactorServiciosImpl;
import com.digimat.showcase.Zonas.Dialogs.Servicios.view.viewServices;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;

import java.util.List;

public class presenterServiciosImpl  implements  presenterServicios{
    private viewServices view;
    private Context context;
    private interactorServicios interactor;
    public presenterServiciosImpl(viewServices view,Context context){
        this.view=view;
        this.context=context;
        this.interactor=new interactorServiciosImpl(this,context);
    }
    @Override
    public void getServiciosComunity() {
        if(view!=null){
            interactor.getServiciosComunity();
        }
    }
    @Override
    public void setServicesAvailable(List<dataServicesCatalog> catalog) {
        if(view!=null){
            view.setServicesAvailable(catalog);

        }
    }
}
