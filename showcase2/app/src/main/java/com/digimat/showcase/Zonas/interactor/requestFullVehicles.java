package com.digimat.showcase.Zonas.interactor;

import com.digimat.showcase.Zonas.Dialogs.model.dotZonesm;

import java.util.List;

public interface requestFullVehicles {
    void requestVehicles();

    void updateZone(String zoneId, String descZone, String ratio, List<dotZonesm> dotZones);

    void createZone(String name, String desc, String ratio, List<dotZonesm> dotZones);
}
