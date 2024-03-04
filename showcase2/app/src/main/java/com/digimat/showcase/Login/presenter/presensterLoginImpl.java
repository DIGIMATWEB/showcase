package com.digimat.showcase.Login.presenter;

import android.content.Context;

import com.digimat.showcase.Login.interactor.interactorLogin;
import com.digimat.showcase.Login.interactor.interactorLoginImpl;
import com.digimat.showcase.Login.view.loginView;

public class presensterLoginImpl implements presenterLogin {
    private loginView view;
    private Context context;
    private interactorLogin interactor;
    public presensterLoginImpl(loginView view,Context context){
        this.view= view;
        this.context= context;
        interactor= new interactorLoginImpl(this,context);

    }
    @Override
    public void requestLogin() {
        if(view!=null){
            interactor.requesLogin();
        }
    }

    @Override
    public void succesLogin() {
        if(view!=null){
            view.succesLogin();
        }
    }
}
