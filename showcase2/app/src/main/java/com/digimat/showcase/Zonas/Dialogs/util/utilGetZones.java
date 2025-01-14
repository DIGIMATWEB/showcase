package com.digimat.showcase.Zonas.Dialogs.util;

import com.digimat.showcase.Zonas.Dialogs.model.responseGetZones;
import com.digimat.showcase.Zonas.Dialogs.model.zoneRequest;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface utilGetZones {
    @POST(RetrofitEndPointsV2.GET_ZONES)/** pinta las zonas en el mapa*/
    Call<responseGetZones> getAllZones(@Body zoneRequest request);
}
