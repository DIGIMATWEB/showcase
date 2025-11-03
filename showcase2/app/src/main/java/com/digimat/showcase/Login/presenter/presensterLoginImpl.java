package com.digimat.showcase.Login.presenter;

import android.content.Context;

import com.digimat.showcase.Login.interactor.interactorLogin;
import com.digimat.showcase.Login.interactor.interactorLoginImpl;
import com.digimat.showcase.Login.model.dataLogin;
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
    public void requestLogin(String user, String pass) {
        if(view!=null){
            interactor.requesLogin(user,pass);
        }
    }

    @Override
    public void succesLogin(dataLogin data) {
        if(view!=null){
            view.succesLogin(data);
        }
    }
}
