package com.digimat.showcase.Menu.util;

import com.digimat.showcase.Zonas.model.vehiclesRequest;
import com.digimat.showcase.Zonas.model.vehiclesResponse;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface serviceMenus {
    @POST(RetrofitEndPointsV2.GET_VEHICLES)/** pinta las zonas en el mapa*/
    Call<vehiclesResponse> getAllVehicles(@Body vehiclesRequest request);
}
