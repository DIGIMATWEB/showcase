package com.digimat.showcase.Zonas.presenter;

import android.content.Context;

import com.digimat.showcase.Zonas.Dialogs.model.dotZonesm;
import com.digimat.showcase.Zonas.interactor.requestFullVehicles;
import com.digimat.showcase.Zonas.interactor.vehiclesInteractorImpl;
import com.digimat.showcase.Zonas.model.getVehicles.dataFullVehicles;
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
    public void updateZone(String zoneId, String descZone, String ratio, List<dotZonesm> dotZones) {
        if(view!=null){
            interactor.updateZone(zoneId,descZone,ratio,dotZones);
        }
    }

    @Override
    public void closeEdiotorZone() {
        if(view!=null){
            view.closeEdiotorZone();
        }
    }

    @Override
    public void setVehicles(List<dataFullVehicles> data) {
        if(view!=null){
            view.setVehicles(data);
        }
    }


}
