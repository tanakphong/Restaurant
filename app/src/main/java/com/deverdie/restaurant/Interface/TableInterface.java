package com.deverdie.restaurant.Interface;

import com.deverdie.restaurant.model.TableRes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TableInterface {
    @GET("admin/api/table/getTableAll.php")
    Call<TableRes> getAll();
}
