package com.digimat.showcase.Splash.presenter;

import android.content.Context;

import com.digimat.showcase.Splash.interactor.interactorSplash;
import com.digimat.showcase.Splash.interactor.interactorSplashImpl;
import com.digimat.showcase.Splash.model.dataSplash;
import com.digimat.showcase.Splash.view.Splash;
import com.digimat.showcase.Splash.view.viewSplash;

public class presenterSplashImpl  implements  presenterSplash{
    private viewSplash view;
    private Context context;
    private interactorSplash interactor;
    public presenterSplashImpl(viewSplash view, Context context) {
        this.view=view;
        this.context=context;
        interactor= new interactorSplashImpl(this,context);
    }

    @Override
    public void getSplashData() {
        if(view!=null){
            interactor.requestSplash();
        }
    }

    @Override
    public void setSplashData(dataSplash data) {
        if(view!=null){
            view.setSplash(data);
        }
    }
}
