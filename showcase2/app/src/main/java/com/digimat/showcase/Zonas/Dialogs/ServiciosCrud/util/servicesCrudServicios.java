package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.util;

import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.requestCrudServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.responseCrudServices;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.requestGetServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.responseGetServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity.requestUpdateSetServiceOnComunity;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity.responseUpdateServiceComunity;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface servicesCrudServicios {
     @POST(RetrofitEndPointsV2.GET_CATALOG_SERVICES)/** pinta las zonas en el mapa*/
     Call<responseCrudServices> getCatalogServices(@Body requestCrudServicios request);
    @POST(RetrofitEndPointsV2.SET_UPDATE_CATALOG_SERVICES)
    Call<responseUpdateServiceComunity> updateServices(@Body requestUpdateSetServiceOnComunity request);

    @POST(RetrofitEndPointsV2.GET_SERVICES)
    Call<responseGetServicios> getServicios(@Body requestGetServicios request);
}
