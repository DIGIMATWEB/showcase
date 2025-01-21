package com.digimat.showcase.Zonas.presenter;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dataGetAllZones;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.digimat.showcase.Zonas.model.getUsers.dataFullUsers;
import com.digimat.showcase.Zonas.model.getVehicles.dataVehicles;

import java.util.List;

public interface presenterComunities {
    void requestUsers();
    void setUsers(List<dataFullUsers> data);
    void getZonesView();

    void updateZone(String zoneId, String descZone, String ratio, List<dotZonesm> dotZones);

    void closeEdiotorZone();

    void createZone(String name, String desc, String ratio, List<dotZonesm> dotZones);

    void eraseZones(String zoneId);

    void setZonesView(List<dataGetAllZones> data);

    void getVehicles();

    void setVehicles(List<dataVehicles> data);
}
