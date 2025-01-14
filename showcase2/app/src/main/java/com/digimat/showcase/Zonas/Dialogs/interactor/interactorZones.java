package com.digimat.showcase.Zonas.Dialogs.interactor;

import android.content.Context;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Zonas.Dialogs.interfaceZones;
import com.digimat.showcase.Zonas.Dialogs.model.dataGetAllZones;
import com.digimat.showcase.Zonas.Dialogs.model.responseGetZones;
import com.digimat.showcase.Zonas.Dialogs.model.zoneRequest;
import com.digimat.showcase.Zonas.Dialogs.util.utilGetZones;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class interactorZones implements interfaceZones.Interactor{
    private Context context;
    private Retrofit retrofitClient;
    private utilGetZones service;
    private interfaceZones.Presenter presenter;

    public interactorZones(interfaceZones.Presenter presenter, Context context) {
        this.presenter=presenter;
        this.context = context;
        retrofitClient = RetrofitClientV2.getRetrofitInstance();
        service = retrofitClient.create(utilGetZones.class);
    }

    @Override
    public void requestZones() {
        zoneRequest request=new zoneRequest("af599b21642927b27963b1d66694896a") ;
        Call<responseGetZones> call = service.getAllZones(request);
        call.enqueue(new Callback<responseGetZones>() {
            @Override
            public void onResponse(Call<responseGetZones> call, Response<responseGetZones> response) {
                validateCode(response, context);
            }

            @Override
            public void onFailure(Call<responseGetZones> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validateCode(Response<responseGetZones> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getZonesdata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getZonesdata(Response<responseGetZones> response, Context context) {
        responseGetZones resp=response.body();
                if (resp != null) {
                    String message = resp.getMessage();
                    int responseCode = resp.getResconseCode();
                    if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                        List<dataGetAllZones> data = resp.getData();

                        if (data != null)//data
                        {
                            presenter.setZones(data);
                        }
                    }
                }else{
                    Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
                }
    }
}
