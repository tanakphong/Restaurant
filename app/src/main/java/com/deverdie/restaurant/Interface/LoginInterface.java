package com.deverdie.restaurant.Interface;

import com.deverdie.restaurant.model.LoginRes;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {
    @POST("admin/api/VerifyPWS.php")
    Call<LoginRes> verifyPWS(@Body RequestBody login);
}
