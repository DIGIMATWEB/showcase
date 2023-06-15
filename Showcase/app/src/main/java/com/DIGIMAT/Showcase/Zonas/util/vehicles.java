package com.DIGIMAT.Showcase.Zonas.util;

import com.DIGIMAT.Showcase.Zonas.model.vehiclesRequest;
import com.DIGIMAT.Showcase.Zonas.model.vehiclesResponse;
import com.DIGIMAT.Showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface vehicles {
    @POST(RetrofitEndPointsV2.GET_VEHICLES)/** pinta las zonas en el mapa*/
    Call<vehiclesResponse> getAllVehicles(@Body vehiclesRequest request);
}
