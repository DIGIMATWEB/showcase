package com.DIGIMAT.Showcase.Zonas.presenter;

import android.content.Context;

import com.DIGIMAT.Showcase.Zonas.interactor.requestFullVehicles;
import com.DIGIMAT.Showcase.Zonas.interactor.vehiclesInteractorImpl;
import com.DIGIMAT.Showcase.Zonas.model.dataFullVehicles;
import com.DIGIMAT.Showcase.Zonas.view.zonasView;

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
