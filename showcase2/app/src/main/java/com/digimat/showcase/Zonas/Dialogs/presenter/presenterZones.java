package com.digimat.showcase.Zonas.Dialogs.presenter;

import android.content.Context;

import com.digimat.showcase.Zonas.Dialogs.interactor.interactorZones;
import com.digimat.showcase.Zonas.Dialogs.interfaceZones;
import com.digimat.showcase.Zonas.Dialogs.model.dataGetAllZones;

import java.util.List;

public class presenterZones implements interfaceZones.Presenter {
    private interfaceZones.View view;
    private Context ccntext;
    private interfaceZones.Interactor interactor;
    public presenterZones(interfaceZones.View view,Context ccntext) {
        this.ccntext = ccntext;
        this.view = view;
        interactor=new interactorZones(this,ccntext);
    }

    @Override
    public void requestZones() {
        if(view!=null){
            interactor.requestZones();
        }
    }

    @Override
    public void setZones(List<dataGetAllZones> data) {
        if(view!=null){
            view.setZones(data);
        }
    }
}
