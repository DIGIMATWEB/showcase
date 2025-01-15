package com.digimat.showcase.Menu.util;

import com.digimat.showcase.Menu.models.requestMenus;
import com.digimat.showcase.Menu.models.responseMenus;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface serviceMenus {
    @POST(RetrofitEndPointsV2.GET_MENUS)/** pinta las zonas en el mapa*/
    Call<responseMenus> getMenus(@Body requestMenus request);
}
