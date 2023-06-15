package com.DIGIMAT.Showcase.Zonas.presenter;

import com.DIGIMAT.Showcase.Zonas.model.dataFullVehicles;

import java.util.List;

public interface presenterVehicles {
    void requestVehicles();
    void setVehicles(List<dataFullVehicles> data);

}
