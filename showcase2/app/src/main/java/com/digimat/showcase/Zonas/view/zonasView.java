package com.digimat.showcase.Zonas.view;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dataGetAllZones;
import com.digimat.showcase.Zonas.model.getUsers.dataFullUsers;
import com.digimat.showcase.Zonas.model.getVehicles.dataVehicles;

import java.util.List;

public interface zonasView {
    void setUsers(List<dataFullUsers> data);

    void closeEdiotorZone();

    void drawZonesOnView(List<dataGetAllZones> data);

    void setVehicles(List<dataVehicles> data);

    void setVehiclePath(String data);
}
