package com.digimat.showcase.Zonas.Dialogs.Servicios.interactor;

import android.content.Context;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Zonas.Dialogs.Servicios.presenter.presenterServiciosImpl;
import com.digimat.showcase.Zonas.Dialogs.Servicios.util.serviceServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.requestGetServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.getServicios.responseGetServicios;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class interactorServiciosImpl implements  interactorServicios{
    private presenterServiciosImpl presenter;
    private Context context;
    private Retrofit retrofitClient;
    private serviceServicios service;
    public interactorServiciosImpl(presenterServiciosImpl presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
        retrofitClient = RetrofitClientV2.getRetrofitInstance();
        service = retrofitClient.create(serviceServicios.class);
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

}
