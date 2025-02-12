package com.digimat.showcase.Zonas.Dialogs.Servicios.util;

import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.requestGetServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.responseGetServicios;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface serviceServicios {
    @POST(RetrofitEndPointsV2.GET_SERVICES)
    Call<responseGetServicios> getServicios(@Body requestGetServicios request);
}
