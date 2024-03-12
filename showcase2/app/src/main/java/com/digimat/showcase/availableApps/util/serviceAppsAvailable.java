package com.digimat.showcase.availableApps.util;

import com.digimat.showcase.availableApps.model.responseAvailableApps;
import com.digimat.showcase.availableApps.model.setApp.requestSetAvailable;
import com.digimat.showcase.availableApps.model.setApp.responseSetAvailable;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface serviceAppsAvailable {
    @GET(RetrofitEndPointsV2.GET_APPS)
    Call<responseAvailableApps> getAppData();
   @POST(RetrofitEndPointsV2.SET_APPS)/** pinta las zonas en el mapa*/
   Call<responseSetAvailable> setAvailable(@Body requestSetAvailable request);

}
