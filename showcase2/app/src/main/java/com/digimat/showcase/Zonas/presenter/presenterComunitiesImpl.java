package com.digimat.showcase.Zonas.presenter;

import android.content.Context;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dataGetAllZones;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.digimat.showcase.Zonas.interactor.requestFullCumunities;
import com.digimat.showcase.Zonas.interactor.comunityInteractorImpl;
import com.digimat.showcase.Zonas.model.getUsers.dataFullUsers;
import com.digimat.showcase.Zonas.model.getVehicles.dataVehicles;
import com.digimat.showcase.Zonas.model.getVehicles.dotVehiclesPath;
import com.digimat.showcase.Zonas.view.zonasView;

import java.util.List;

public class presenterComunitiesImpl implements presenterComunities {

    private zonasView view;
    private Context context;
    private requestFullCumunities interactor;

    public presenterComunitiesImpl(zonasView view, Context context)
    {
        this.view=view;
        this.context=context;
        this.interactor=new comunityInteractorImpl(this,context);
    }

    @Override
    public void requestUsers() {
        if(view!=null){
        interactor.requestUsers();
        }
    }
    @Override
    public void getZonesView() {
        if(view!=null){
            interactor.getZonesView();
        }
    }
    @Override
    public void updateZone(String zoneId, String descZone, String ratio, List<dotZonesm> dotZones) {
        if(view!=null){
            interactor.updateZone(zoneId,descZone,ratio,dotZones);
        }
    }
    @Override
    public void createZone(String name, String desc, String ratio, List<dotZonesm> dotZones) {
        if(view!=null){
            interactor.createZone(name,desc,ratio,dotZones);
        }
    }

    @Override
    public void eraseZones(String zoneId) {
        if(view!=null){
            interactor.eraseZones(zoneId);
        }
    }
    @Override
    public void getVehicles() {
        if(view!=null){
            interactor.getVehicles();
        }
    }
    @Override
    public void savePathVehicle(String currentVehicleId, List<dotVehiclesPath> dotPath) {
        if(view!=null){
            interactor.savePathVehicle(currentVehicleId,dotPath);
        }
    }

    @Override
    public void setVehiclePath(String data) {
        if(view!=null){
            view.setVehiclePath(data);
        }
    }

    @Override
    public void setVehicles(List<dataVehicles> data) {
        if(view!=null){
            view.setVehicles(data);
        }
    }



    @Override
    public void setZonesView(List<dataGetAllZones> data) {
        if(view!=null){
            view.drawZonesOnView(data);
        }
    }



    @Override
    public void closeEdiotorZone() {
        if(view!=null){
            view.closeEdiotorZone();
        }
    }



    @Override
    public void setUsers(List<dataFullUsers> data) {
        if(view!=null){
            view.setUsers(data);
        }
    }




}
