package com.digimat.showcase.availableApps.presenter;

import com.digimat.showcase.availableApps.model.dataAvailableApps;

import java.util.List;

public interface presenterAppsAvailable {
    void requestMenus();

    void setMenus(List<dataAvailableApps> data);

    void setAvailable(boolean available, String nameApp);

    void updateView();
}
