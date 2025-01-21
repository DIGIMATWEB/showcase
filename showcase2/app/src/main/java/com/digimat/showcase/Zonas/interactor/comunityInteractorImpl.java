package com.digimat.showcase.Zonas.interactor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dataGetAllZones;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.responseGetZones;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.zoneRequest;
import com.digimat.showcase.Zonas.model.getUsers.dataFullUsers;
import com.digimat.showcase.Zonas.model.getUsers.usersRequest;
import com.digimat.showcase.Zonas.model.getUsers.usersResponse;
import com.digimat.showcase.Zonas.model.getVehicles.dataVehicles;
import com.digimat.showcase.Zonas.model.getVehicles.requestVehicles;
import com.digimat.showcase.Zonas.model.getVehicles.responseVehicles;
import com.digimat.showcase.Zonas.model.newZone.requestNewZone;
import com.digimat.showcase.Zonas.model.newZone.responseNewZone;
import com.digimat.showcase.Zonas.model.removeZones.requestRemoveZone;
import com.digimat.showcase.Zonas.model.removeZones.responseRemoveZone;
import com.digimat.showcase.Zonas.model.updateZones.requestUpdateZones;
import com.digimat.showcase.Zonas.model.updateZones.responseUpdateZone;
import com.digimat.showcase.Zonas.presenter.presenterComunities;
import com.digimat.showcase.Zonas.presenter.presenterComunitiesImpl;
import com.digimat.showcase.Zonas.util.comunities;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class comunityInteractorImpl implements requestFullCumunities {

    private Context context;
    private presenterComunities presenter;
    private Retrofit retrofitClient;
    private comunities service;
    public comunityInteractorImpl(presenterComunitiesImpl presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
         retrofitClient = RetrofitClientV2.getRetrofitInstance();
         service = retrofitClient.create(comunities.class);

    }

    @Override
    public void requestUsers() {
       // SharedPreferences preferences = context.getSharedPreferences(GeneralConstantsV2.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
        //String token = preferences.getString(GeneralConstantsV2.TOKEN_PREFERENCES, null);
       String token="af599b21642927b27963b1d66694896a";
       // if (token != null) {
        getUsersData(token);/** aqui solo obtendremos los siguientes datos   cve_layer & tab_layer_color      */
        //}
    }

    @Override
    public void getZonesView() {
        zoneRequest request=new zoneRequest("af599b21642927b27963b1d66694896a") ;
        Call<responseGetZones> call = service.getAllZones(request);
        call.enqueue(new Callback<responseGetZones>() {
            @Override
            public void onResponse(Call<responseGetZones> call, Response<responseGetZones> response) {
                validateCodeZonesView(response, context);
            }

            @Override
            public void onFailure(Call<responseGetZones> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validateCodeZonesView(Response<responseGetZones> response, Context context) {
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
                    presenter.setZonesView(data);
                }
            }
        }else{
            Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
        }
    }

    private void getUsersData(String token) {
         usersRequest request = new usersRequest(token);
        //        presenter.showProgressDialog();
                Call<usersResponse> call = service.getAllUsers(request);
                call.enqueue(new Callback<usersResponse>() {
                    @Override
                    public void onResponse(Call<usersResponse> call, Response<usersResponse> response) {
                        validateCode(response, context);
                    }

                    @Override
                    public void onFailure(Call<usersResponse> call, Throwable t) {
                        Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void validateCode(Response<usersResponse> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getusersdata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getusersdata(Response<usersResponse> response, Context context) {
        usersResponse resp=response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResconseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                List<dataFullUsers> data = resp.getData();

                if (data != null)//data
                {
                    List<dataFullUsers> dataf = new ArrayList<>();//todo este filtro deberia filtar por comunidad
                    for(dataFullUsers user:data){
                        if(user.getComunidad().equals("1")){

                            dataf.add(user);
                        }
                    }
                    Log.e("users","Numero: "+dataf.size());
                    presenter.setUsers(dataf);
                }
            }
        }else{
            Toast.makeText(context, "sin datos de vehiculos", Toast.LENGTH_SHORT).show();
        }
    }  @Override
    public void updateZone(String zoneId, String descZone, String ratio, List<dotZonesm> dotZones) {
        requestUpdateZones request =new requestUpdateZones(Integer.valueOf(zoneId),descZone,Integer.valueOf(ratio),dotZones);
        Call<responseUpdateZone> call = service.setUpdatedZone(request);
        call.enqueue(new Callback<responseUpdateZone>() {
            @Override
            public void onResponse(Call<responseUpdateZone> call, Response<responseUpdateZone> response) {
                validateCodeEditZone(response, context);
            }

            @Override
            public void onFailure(Call<responseUpdateZone> call, Throwable t) {
                Toast.makeText(context, "onFailure  updateZone cause :" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void createZone(String name, String desc, String ratio, List<dotZonesm> dotZones) {
      //  Toast.makeText(context, "crear zona pendiente endpoint", Toast.LENGTH_SHORT).show();
       requestNewZone request =new requestNewZone(name,desc,Integer.valueOf(ratio),dotZones);
       Call<responseNewZone> call = service.newZone(request);
       call.enqueue(new Callback<responseNewZone>() {
           @Override
           public void onResponse(Call<responseNewZone> call, Response<responseNewZone> response) {
               validateCodeCreateZone(response, context);
           }

           @Override
           public void onFailure(Call<responseNewZone> call, Throwable t) {
               Toast.makeText(context, "onFailure  createZone cause :" + t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }



    private void validateCodeCreateZone(Response<responseNewZone> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getNewZonedata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getNewZonedata(Response<responseNewZone> response, Context context) {
        responseNewZone resp=response.body();
                if (resp != null) {
                    String message = resp.getMessage();
                    int responseCode = resp.getResponseCode();
                    if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                        Toast.makeText(context, "Datos actualizados correctamente" , Toast.LENGTH_SHORT).show();
                        presenter.closeEdiotorZone();
                    }
                }else{
                    Toast.makeText(context, "sin puntos de la Zona", Toast.LENGTH_SHORT).show();
                }
    }

    private void validateCodeEditZone(Response<responseUpdateZone> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getZonedata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getZonedata(Response<responseUpdateZone> response, Context context) {
        responseUpdateZone resp=response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResponseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                List<dotZonesm> data = resp.getdotZonesms();

                if (data != null)//data
                {
                    Gson gson=new Gson();
                    String json=gson.toJson(data);
                    Toast.makeText(context, "Datos actualizados correctamente" , Toast.LENGTH_SHORT).show();
                    presenter.closeEdiotorZone();
                }
            }
        }else{
            Toast.makeText(context, "sin puntos de la Zona", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void eraseZones(String zoneId) {
        requestRemoveZone request =new requestRemoveZone(Integer.valueOf( zoneId));
        Call<responseRemoveZone> call = service.removeZone(request);
        call.enqueue(new Callback<responseRemoveZone>() {
            @Override
            public void onResponse(Call<responseRemoveZone> call, Response<responseRemoveZone> response) {
                validateCodeEraseZone(response, context);
            }

            @Override
            public void onFailure(Call<responseRemoveZone> call, Throwable t) {
                Toast.makeText(context, "onFailure  eraseZones cause :" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void validateCodeEraseZone(Response<responseRemoveZone> response, Context context) {//
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getRemoveZonedata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getRemoveZonedata(Response<responseRemoveZone> response, Context context) {
        responseRemoveZone resp=response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResponseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                Toast.makeText(context, "Zona eliminada correctamente id: "+resp.getIdZone() , Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(context, "sin puntos de la Zona", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void getVehicles() {
        requestVehicles request=new requestVehicles("af599b21642927b27963b1d66694896a") ;
        Call<responseVehicles> call = service.getAllVehicles(request);
        call.enqueue(new Callback<responseVehicles>() {
            @Override
            public void onResponse(Call<responseVehicles> call, Response<responseVehicles> response) {
                validateVehicles(response,context);
            }

            @Override
            public void onFailure(Call<responseVehicles> call, Throwable t) {

            }
        });
    }

    private void validateVehicles(Response<responseVehicles> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getVehiclesdata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getVehiclesdata(Response<responseVehicles> response, Context context) {
        responseVehicles resp=response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResponseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
              List<dataVehicles> data = resp.getData();

                                if (data != null)//data
                                {
                                    Gson gson=new Gson();
                                    String json=gson.toJson(data);

                                    presenter.setVehicles(data);
                                }

            }
        }else{
            Toast.makeText(context, "sin informacion de vehiculo", Toast.LENGTH_SHORT).show();
        }
    }
}
