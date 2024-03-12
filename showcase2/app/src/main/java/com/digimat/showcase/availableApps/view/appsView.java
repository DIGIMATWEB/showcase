package com.digimat.showcase.availableApps.view;

import com.digimat.showcase.availableApps.model.dataAvailableApps;

import java.util.List;

public interface appsView {
    void setAppsAvailable(List<dataAvailableApps> data);

    void update();
}
