package com.digimat.showcase.Splash.interactor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Menu.util.serviceMenus;
import com.digimat.showcase.Splash.model.dataSplash;
import com.digimat.showcase.Splash.model.requestSplash;
import com.digimat.showcase.Splash.model.responseSplash;
import com.digimat.showcase.Splash.presenter.presenterSplashImpl;
import com.digimat.showcase.Splash.util.serviceSplash;
import com.digimat.showcase.retrofit.RetrofitClientV2;
import com.digimat.showcase.retrofit.RetrofitValidationsV2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;

public class interactorSplashImpl  implements  interactorSplash{
    private presenterSplashImpl presenter;
    private Context context;
    private Retrofit retrofitClient;
    private serviceSplash service;
    public interactorSplashImpl(presenterSplashImpl presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
        retrofitClient = RetrofitClientV2.getRetrofitInstance();
        service = retrofitClient.create(serviceSplash.class);
    }

    @Override
    public void requestSplash() {
        String token="af599b21642927b27963b1d66694896a";
        if (token != null) {
            getSplash();
        }
    }

    private void getSplash() {
        requestSplash request =new requestSplash(1);
        Call<responseSplash> call=service.getSplash(request );
        call.enqueue(new Callback<responseSplash>() {
            @Override
            public void onResponse(Call<responseSplash> call, Response<responseSplash> response) {
                validateCode(response, context);
            }

            @Override
            public void onFailure(Call<responseSplash> call, Throwable t) {
                presenter.setSplashData(null);
                //Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void validateCode(Response<responseSplash> response, Context context) {
        if (response != null) {

            if (RetrofitValidationsV2.checkSuccessCode(response.code())) {
                getSplashData(response, context);
            } else {
                presenter.setSplashData(null);
                Toast.makeText(context, "" + RetrofitValidationsV2.getErrorByStatus(response.code(), context), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getSplashData(Response<responseSplash> response, Context context) {

         responseSplash resp= response.body();
                if (resp != null) {
                    String message = resp.getMessage();
                    int responseCode = resp.getResconseCode();
                    if (responseCode == GeneralConstantsV2.RESPONSE_CODE_OK) {
                       dataSplash data = resp.getData();

                        if (data != null)//data
                        {
                            presenter.setSplashData(data);
                            Log.e("itemsMenu",""+data);
                        }else {
                            presenter.setSplashData(null);
                        }
                    }else {
                        presenter.setSplashData(null);
                    }
                }else{
                    presenter.setSplashData(null);
                }
    }
}
