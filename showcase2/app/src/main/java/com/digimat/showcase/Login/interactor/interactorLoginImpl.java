package com.digimat.showcase.Login.interactor;

import android.content.Context;
import android.widget.Toast;

import com.digimat.showcase.Login.model.requestLogin;
import com.digimat.showcase.Login.model.responseLogin;
import com.digimat.showcase.Login.presenter.presenterLogin;
import com.digimat.showcase.Login.util.serviceLogin;
import com.digimat.showcase.retrofit.RetrofitClientV2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class interactorLoginImpl implements interactorLogin {
    private Context context;
    private presenterLogin presenter;
    private Retrofit retrofit;
    private serviceLogin service;

    public interactorLoginImpl(presenterLogin presenter, Context context) {
        this.presenter=presenter;
        this.context=context;
        retrofit = RetrofitClientV2.getRetrofitInstance();
        service = retrofit.create(serviceLogin.class);
    }

    @Override
    public void requesLogin() {
        requestLogin request = new requestLogin("inghfrancisco.morales@gmail.com","12345");
        Call<responseLogin> call= service.getAvaileble(request);
        call.enqueue(new Callback<responseLogin>() {
            @Override
            public void onResponse(Call<responseLogin> call, Response<responseLogin> response) {
                if(response.code()==200){
                    if(response.body().getResconseCode()==200){
                        presenter.succesLogin();
                    }else{
                        Toast.makeText(context, "Tu usuario no se encuentra activo", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(context, "response: "+response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<responseLogin> call, Throwable t) {
                Toast.makeText(context, "response: onfailure, "+t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
