package com.digimat.showcase.Menu.presenter;

import android.content.Context;

import com.digimat.showcase.Menu.interactor.interactorMenus;
import com.digimat.showcase.Menu.interactor.interactorMenusImpl;
import com.digimat.showcase.Menu.view.menuView;

public class presenterMenusImpl implements presenterMenus {

    private Context context;
    private menuView view;
    private interactorMenus interactor;

    public presenterMenusImpl(menuView view,Context context){
        this.view=view;
        this.context=context;
        interactor= new interactorMenusImpl(this,context);

    }
    @Override
    public void requestMenus() {

    }
}