package com.digimat.showcase.availableApps.interactor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.availableApps.model.dataAvailableApps;
import com.digimat.showcase.availableApps.model.responseAvailableApps;
import com.digimat.showcase.availableApps.model.setApp.requestSetAvailable;
import com.digimat.showcase.availableApps.model.setApp.responseSetAvailable;
import com.digimat.showcase.availableApps.presenter.presenterAppsAvailable;
import com.digimat.showcase.availableApps.util.serviceAppsAvailable;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class interactorAppsAvailableImpl implements interactorAppsAvailable{
    private presenterAppsAvailable presenter;
    private Context context;
    private Retrofit retrofit;
    private serviceAppsAvailable service;
    public  interactorAppsAvailableImpl (presenterAppsAvailable presenter,Context context){
        this.presenter=presenter;
        this.context=context;
        retrofit= RetrofitClientV2.getRetrofitInstance();
        service= retrofit.create(serviceAppsAvailable.class);

    }
    @Override
    public void requestApps() {
        Call<responseAvailableApps> call= service.getAppData();
        call.enqueue(new Callback<responseAvailableApps>() {
            @Override
            public void onResponse(Call<responseAvailableApps> call, Response<responseAvailableApps> response) {
                validateCode(response, context);
            }

            @Override
            public void onFailure(Call<responseAvailableApps> call, Throwable t) {

            }
        });
    }

    @Override
    public void setAvailable(boolean available, String nameApp) {
        Integer isAvailabel=2;
        if(available){
            isAvailabel=1;
        }else{
            isAvailabel=0;
        }
        requestSetAvailable request= new requestSetAvailable(isAvailabel,nameApp);
        Call<responseSetAvailable> call= service.setAvailable(request);
        call.enqueue(new Callback<responseSetAvailable>() {
            @Override
            public void onResponse(Call<responseSetAvailable> call, Response<responseSetAvailable> response) {
                validateCodeSetApp(response,context);
            }

            @Override
            public void onFailure(Call<responseSetAvailable> call, Throwable t) {

            }
        });
    }

    private void validateCodeSetApp(Response<responseSetAvailable> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                setApp(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setApp(Response<responseSetAvailable> response, Context context) {
        responseSetAvailable resp=response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResponseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {



            }
            presenter.updateView();
        }else{
            Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
        }
    }

    private void validateCode(Response<responseAvailableApps> response, Context context) {
            if (response != null) {

                if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                    getAppsdata(response, context);
                } else {
                    Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
                }
            }
        }

    private void getAppsdata(Response<responseAvailableApps> response, Context context) {
        responseAvailableApps resp= response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResconseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                List<dataAvailableApps> data = resp.getData();

                if (data != null)//data
                {
                    presenter.setMenus(data);
                    Log.e("itemsMenu",""+data);
                }
            }
        }else{
            Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
        }
    }
}
