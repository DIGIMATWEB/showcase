package com.digimat.showcase.Zonas.presenter;

import com.digimat.showcase.Zonas.Dialogs.model.dotZonesm;
import com.digimat.showcase.Zonas.model.getVehicles.dataFullVehicles;

import java.util.List;

public interface presenterVehicles {
    void requestVehicles();
    void setVehicles(List<dataFullVehicles> data);

    void updateZone(String zoneId, String descZone, String ratio, List<dotZonesm> dotZones);

    void closeEdiotorZone();

    void createZone(String name, String desc, String ratio, List<dotZonesm> dotZones);
}
