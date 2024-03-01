package com.digimat.showcase.Splash.util;

import com.digimat.showcase.Menu.models.requestMenus;
import com.digimat.showcase.Menu.models.responseMenus;
import com.digimat.showcase.Splash.model.requestSplash;
import com.digimat.showcase.Splash.model.responseSplash;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface serviceSplash {

    @POST(RetrofitEndPointsV2.SPLASH)/** pinta las zonas en el mapa*/
    Call<responseSplash> getSplash(@Body requestSplash request);
}
