package com.rzl.listcars.network

import com.rzl.listcars.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestfulApi {

    @GET("admin/car")
    fun getAllCar(): Call<List<ResponseDataCarItem>>

    @GET("admin/car/{id}")
    fun getDetailCar(@Path("id") id : Int): Call<ResponseDataCarItem>
}
