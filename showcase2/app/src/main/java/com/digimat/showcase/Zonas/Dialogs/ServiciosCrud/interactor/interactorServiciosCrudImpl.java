package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.interactor;

import android.content.Context;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.requestCrudServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.responseCrudServices;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.requestGetServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.responseGetServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity.dataUpdateServiceComunity;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity.requestUpdateSetServiceOnComunity;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.updateComunity.responseUpdateServiceComunity;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.presenter.presenterServiciosCrudImpl;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.util.servicesCrudServicios;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class interactorServiciosCrudImpl implements  interactorServiciosCrud{
    private Context context;
    private  presenterServiciosCrudImpl presenter;
    private Retrofit retrofitClient;
    private servicesCrudServicios service;
    public interactorServiciosCrudImpl(presenterServiciosCrudImpl presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
        retrofitClient = RetrofitClientV2.getRetrofitInstance();
        service = retrofitClient.create(servicesCrudServicios.class);
    }

    @Override
    public void getCatalogoServicios() {
        requestCrudServicios request=new requestCrudServicios("faketoken");
        Call<responseCrudServices> call= service.getCatalogServices(request);
        call.enqueue(new Callback<responseCrudServices>() {
            @Override
            public void onResponse(Call<responseCrudServices> call, Response<responseCrudServices> response) {
                    validateCatalogServices(response,context);
            }

            @Override
            public void onFailure(Call<responseCrudServices> call, Throwable t) {
                Toast.makeText(context, "Error al obtener el catalogo "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validateCatalogServices(Response<responseCrudServices> response, Context context) {
           if (response != null) {

                    if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                        getCatalogdata(response, context);
                    } else {
                        Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
                    }
                }
    }

    private void getCatalogdata(Response<responseCrudServices> response, Context context) {
        responseCrudServices resp=response.body();
                if (resp != null) {
                    String message = resp.getMessage();
                    int responseCode = resp.getResponseCode();
                    if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                        List<dataServicesCatalog> data = resp.getData();

                        if (data != null)//data
                        {
                            presenter.setCatalogServices(data);
                        }
                    }
                }else{
                    Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
                }
    }

    @Override
    public void getServiciosComunity() {
        requestGetServicios request=new requestGetServicios(1);
        Call<responseGetServicios> call=service.getServicios(request);
        call.enqueue(new Callback<responseGetServicios>() {
            @Override
            public void onResponse(Call<responseGetServicios> call, Response<responseGetServicios> response) {
                validateGetServices(response,context);
            }

            @Override
            public void onFailure(Call<responseGetServicios> call, Throwable t) {
                Toast.makeText(context, "Error al obtener los servicios "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void validateGetServices(Response<responseGetServicios> response, Context context) {
         if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getServices(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getServices(Response<responseGetServicios> response, Context context) {
        responseGetServicios resp=response.body();
                        if (resp != null) {
                            String message = resp.getMessage();
                            int responseCode = resp.getResponseCode();
                            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                                List<dataServicesCatalog> data = resp.getData();

                                if (data != null)//data
                                {
                                    presenter.setServicesAvailable(data);

                                }
                            }
                        }else{
                            Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
                        }
    }

    @Override
    public void setServiceOnComunity(int i, String comunity, Integer idService, String nameService) {
        requestUpdateSetServiceOnComunity request=new requestUpdateSetServiceOnComunity(i,comunity,idService,nameService);
        Call<responseUpdateServiceComunity> call=service.updateServices(request);
        call.enqueue(new Callback<responseUpdateServiceComunity>() {
            @Override
            public void onResponse(Call<responseUpdateServiceComunity> call, Response<responseUpdateServiceComunity> response) {
                validateUpdate(response,context);
            }

            @Override
            public void onFailure(Call<responseUpdateServiceComunity> call, Throwable t) {
                Toast.makeText(context, "Error al actualizat el catalogo "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validateUpdate(Response<responseUpdateServiceComunity> response, Context context) {
            if (response != null) {

                            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                                getvalidateUpdate(response, context);
                            } else {
                                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
                            }
                        }
    }

    private void getvalidateUpdate(Response<responseUpdateServiceComunity> response, Context context) {
        responseUpdateServiceComunity resp=response.body();
                        if (resp != null) {
                            String message = resp.getMessage();
                            int responseCode = resp.getResponseCode();
                            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                                dataUpdateServiceComunity data = resp.getData();

                                if (data != null)//data
                                {
                                    presenter.succesUpdate(data);
                                }
                            }
                        }else{
                            Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
                        }
    }
}
