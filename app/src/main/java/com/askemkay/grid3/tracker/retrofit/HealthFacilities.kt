package com.askemkay.grid3.tracker.retrofit

import com.askemkay.grid3.tracker.retrofit.pojo.HealthResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HealthFacilities {

    @GET("/health-facilities/")
    fun getUsers(@Query("size") size: Int, @Query("cql", encoded = true) cql: String): Call<HealthResponse>
}