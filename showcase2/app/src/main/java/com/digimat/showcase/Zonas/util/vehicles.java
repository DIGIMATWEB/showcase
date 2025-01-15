package com.digimat.showcase.Zonas.util;

import com.digimat.showcase.Zonas.model.getVehicles.vehiclesRequest;
import com.digimat.showcase.Zonas.model.getVehicles.vehiclesResponse;
import com.digimat.showcase.Zonas.model.updateZones.requestUpdateZones;
import com.digimat.showcase.Zonas.model.updateZones.responseUpdateZone;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface vehicles {
    @POST(RetrofitEndPointsV2.GET_VEHICLES)/** pinta las zonas en el mapa*/
    Call<vehiclesResponse> getAllVehicles(@Body vehiclesRequest request);

    @POST(RetrofitEndPointsV2.UPDATE_ZONE)/** pinta las zonas en el mapa*/
    Call<responseUpdateZone> setUpdatedZone(@Body requestUpdateZones request);
}
