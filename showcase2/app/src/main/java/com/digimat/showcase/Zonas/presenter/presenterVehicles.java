package com.digimat.showcase.Zonas.presenter;

import com.digimat.showcase.Zonas.model.dataFullVehicles;

import java.util.List;

public interface presenterVehicles {
    void requestVehicles();
    void setVehicles(List<dataFullVehicles> data);

}
