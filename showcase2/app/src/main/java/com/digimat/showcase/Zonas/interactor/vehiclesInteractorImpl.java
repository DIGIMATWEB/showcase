package com.digimat.showcase.Zonas.interactor;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Zonas.model.dataFullVehicles;
import com.digimat.showcase.Zonas.model.vehiclesRequest;
import com.digimat.showcase.Zonas.model.vehiclesResponse;
import com.digimat.showcase.Zonas.presenter.presenterVehicles;
import com.digimat.showcase.Zonas.presenter.presenterVehiclesImpl;
import com.digimat.showcase.Zonas.util.vehicles;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class vehiclesInteractorImpl implements  requestFullVehicles{

    private Context context;
    private presenterVehicles presenter;
    private Retrofit retrofitClient;
    private vehicles service;
    public vehiclesInteractorImpl(presenterVehiclesImpl presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
         retrofitClient = RetrofitClientV2.getRetrofitInstance();
         service = retrofitClient.create(vehicles.class);

    }

    @Override
    public void requestVehicles() {
       // SharedPreferences preferences = context.getSharedPreferences(GeneralConstantsV2.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
        //String token = preferences.getString(GeneralConstantsV2.TOKEN_PREFERENCES, null);
        String token="af599b21642927b27963b1d66694896a";
        if (token != null) {
            getVehiclesdata(token);/** aqui solo obtendremos los siguientes datos   cve_layer & tab_layer_color      */
        }
    }

    private void getVehiclesdata(String token) {
         vehiclesRequest request = new vehiclesRequest(token);
        //        presenter.showProgressDialog();
                Call<vehiclesResponse> call = service.getAllVehicles(request);
                call.enqueue(new Callback<vehiclesResponse>() {
                    @Override
                    public void onResponse(Call<vehiclesResponse> call, Response<vehiclesResponse> response) {
                        validateCode(response, context);
                    }

                    @Override
                    public void onFailure(Call<vehiclesResponse> call, Throwable t) {
                        Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void validateCode(Response<vehiclesResponse> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getvehiclesdata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getvehiclesdata(Response<vehiclesResponse> response, Context context) {
        vehiclesResponse resp=response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResconseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                List<dataFullVehicles> data = resp.getData();

                if (data != null)//data
                {
                    presenter.setVehicles(data);
                }
            }
        }else{
            Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
        }
    }
}
