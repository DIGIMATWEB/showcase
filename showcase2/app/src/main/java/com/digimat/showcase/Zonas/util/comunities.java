package com.digimat.showcase.Zonas.util;

import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.responseGetZones;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.zoneRequest;
import com.digimat.showcase.Zonas.model.getUsers.usersRequest;
import com.digimat.showcase.Zonas.model.getUsers.usersResponse;
import com.digimat.showcase.Zonas.model.getVehicles.requestVehicles;
import com.digimat.showcase.Zonas.model.getVehicles.responseVehicles;
import com.digimat.showcase.Zonas.model.newZone.requestNewZone;
import com.digimat.showcase.Zonas.model.newZone.responseNewZone;
import com.digimat.showcase.Zonas.model.removeZones.requestRemoveZone;
import com.digimat.showcase.Zonas.model.removeZones.responseRemoveZone;
import com.digimat.showcase.Zonas.model.updateZones.requestUpdateZones;
import com.digimat.showcase.Zonas.model.updateZones.responseUpdateZone;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface comunities {
    @POST(RetrofitEndPointsV2.GET_USERS)/** pinta las zonas en el mapa*/
    Call<usersResponse> getAllUsers(@Body usersRequest request);
    @POST(RetrofitEndPointsV2.GET_ZONES)/** pinta las zonas en el mapa*/
    Call<responseGetZones> getAllZones(@Body zoneRequest request);

    @POST(RetrofitEndPointsV2.UPDATE_ZONE)/** pinta las zonas en el mapa*/
    Call<responseUpdateZone> setUpdatedZone(@Body requestUpdateZones request);

    @POST(RetrofitEndPointsV2.NEW_ZONE)
    Call<responseNewZone> newZone(@Body requestNewZone request);
    @POST(RetrofitEndPointsV2.REMOVE_ZONE)
    Call<responseRemoveZone> removeZone(@Body requestRemoveZone request);
    @POST(RetrofitEndPointsV2.GET_VEHICLES)
    Call<responseVehicles> getAllVehicles(@Body requestVehicles request);
}
