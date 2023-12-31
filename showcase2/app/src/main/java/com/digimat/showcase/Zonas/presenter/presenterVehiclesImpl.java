package com.digimat.showcase.Zonas.presenter;

import android.content.Context;

import com.digimat.showcase.Zonas.interactor.requestFullVehicles;
import com.digimat.showcase.Zonas.interactor.vehiclesInteractorImpl;
import com.digimat.showcase.Zonas.model.dataFullVehicles;
import com.digimat.showcase.Zonas.view.zonasView;

import java.util.List;

public class presenterVehiclesImpl implements presenterVehicles{

    private zonasView view;
    private Context context;
    private requestFullVehicles interactor;

    public  presenterVehiclesImpl(zonasView view,Context context)
    {
        this.view=view;
        this.context=context;
        this.interactor=new vehiclesInteractorImpl(this,context);
    }

    @Override
    public void requestVehicles() {
        if(view!=null){
        interactor.requestVehicles();
        }
    }

    @Override
    public void setVehicles(List<dataFullVehicles> data) {
        if(view!=null){
            view.setVehicles(data);
        }
    }
}
