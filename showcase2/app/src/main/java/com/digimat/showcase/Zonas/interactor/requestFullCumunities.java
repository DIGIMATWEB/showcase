package com.digimat.showcase.Zonas.interactor;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;

import java.util.List;

public interface requestFullCumunities {
    void requestUsers();
    void getZonesView();
    void updateZone(String zoneId, String descZone, String ratio, List<dotZonesm> dotZones);

    void createZone(String name, String desc, String ratio, List<dotZonesm> dotZones);

    void eraseZones(String zoneId);


    void getVehicles();
}