package com.digimat.showcase.Menu.interactor;

import android.content.Context;

import com.digimat.showcase.Menu.presenter.presenterMenus;
import com.digimat.showcase.Menu.util.serviceMenus;
import com.digimat.showcase.retrofit.RetrofitClientV2;

import retrofit2.Retrofit;

public class interactorMenusImpl  implements  interactorMenus{
    private Context context;
    private presenterMenus presenter;
    private Retrofit retrofitClient;
    private serviceMenus service;

    public interactorMenusImpl(presenterMenus presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
        retrofitClient = RetrofitClientV2.getRetrofitInstance();
        service = retrofitClient.create(serviceMenus.class);
    }
}
