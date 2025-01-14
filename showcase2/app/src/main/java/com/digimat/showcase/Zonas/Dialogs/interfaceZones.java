package com.digimat.showcase.Zonas.Dialogs;

import com.digimat.showcase.Zonas.Dialogs.model.dataGetAllZones;

import java.util.List;

public interface interfaceZones {
    interface View {
     void setZones(List<dataGetAllZones> data);
    }
    interface Presenter {
        void requestZones();

        void setZones(List<dataGetAllZones> data);
    }
    interface Interactor{
        void requestZones();
    }
}
