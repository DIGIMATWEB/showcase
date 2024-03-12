package com.digimat.showcase.availableApps.presenter;

import android.content.Context;

import com.digimat.showcase.availableApps.interactor.interactorAppsAvailable;
import com.digimat.showcase.availableApps.interactor.interactorAppsAvailableImpl;
import com.digimat.showcase.availableApps.model.dataAvailableApps;
import com.digimat.showcase.availableApps.view.appsView;

import java.util.List;

public class presenterAppsavailableImpl implements presenterAppsAvailable{
    private Context context;
    private appsView view;
    private interactorAppsAvailable interactor;

    public presenterAppsavailableImpl(appsView view, Context context) {
        this.view=view;
        this.context=context;
        interactor= new interactorAppsAvailableImpl(this,context);
    }

    @Override
    public void requestMenus() {
        if(view!=null){
            interactor.requestApps();
        }
    }
    @Override
    public void setAvailable(boolean available, String nameApp) {
        if(view!=null){
            interactor.setAvailable(available,nameApp);
        }
    }

    @Override
    public void updateView() {
        if(view!=null){
            view.update();
        }
    }

    @Override
    public void setMenus(List<dataAvailableApps> data) {
        if(view!=null){
            view.setAppsAvailable(data);
        }
    }


}
