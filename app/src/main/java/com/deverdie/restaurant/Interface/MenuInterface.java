package com.deverdie.restaurant.Interface;

import com.deverdie.restaurant.model.MenuRes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuInterface {
    @GET("admin/api/menu/getMenuAll.php")
    Call<MenuRes> getAll();
}
