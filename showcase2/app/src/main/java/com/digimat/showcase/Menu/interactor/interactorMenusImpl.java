package com.digimat.showcase.Menu.interactor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Menu.models.requestMenus;
import com.digimat.showcase.Menu.models.responseMenus;
import com.digimat.showcase.Menu.presenter.presenterMenus;
import com.digimat.showcase.Menu.util.serviceMenus;
import com.digimat.showcase.Zonas.model.dataFullVehicles;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class interactorMenusImpl  implements  interactorMenus{
    private Context context;
    private presenterMenus presenter;
    private Retrofit retrofitClient;
    private serviceMenus service;

    public interactorMenusImpl(presenterMenus presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
        retrofitClient = RetrofitClientV2.getRetrofitInstance();
        service = retrofitClient.create(serviceMenus.class);
    }

    @Override
    public void requestMenus() {
        String token="af599b21642927b27963b1d66694896a";
        if (token != null) {
           getMenus();
        }
    }

    private void getMenus() {
        requestMenus request=new requestMenus("1");
        Call<responseMenus> call= service.getMenus(request);
        call.enqueue(new Callback<responseMenus>() {
            @Override
            public void onResponse(Call<responseMenus> call, Response<responseMenus> response) {
                validateCode(response, context);
            }

            @Override
            public void onFailure(Call<responseMenus> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validateCode(Response<responseMenus> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getvehiclesdata(response, context);
            } else {
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getvehiclesdata(Response<responseMenus> response, Context context) {
        responseMenus resp= response.body();
        if (resp != null) {
            String message = resp.getMessage();
            int responseCode = resp.getResconseCode();
            if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                List<Integer> data = resp.getData();

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
