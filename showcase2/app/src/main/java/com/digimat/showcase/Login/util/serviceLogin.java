package com.digimat.showcase.Login.util;

import com.digimat.showcase.Login.model.requestLogin;
import com.digimat.showcase.Login.model.responseLogin;
import com.digimat.showcase.retrofit.RetrofitEndPointsV2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface serviceLogin {
    @POST(RetrofitEndPointsV2.LOGIN)
    Call<responseLogin> getAvaileble(@Body requestLogin request);
}
