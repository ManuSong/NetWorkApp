package com.risingcamp.manu.networkapp

import com.risingcamp.manu.networkapp.retrofitdata.Data
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantInterface {

    @GET("15066516/v1/uddi:507e01f5-76ec-42ff-96a5-8b6ff9ce554e")
    fun getRestaurant(
        @Query("page") page : Int,
        @Query("perPage") perPage : Int,
        @Query("serviceKey") serviceKey : String
    ) : Call<delicous_restrant>
}