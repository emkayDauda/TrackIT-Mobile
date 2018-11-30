package com.askemkay.grid3.tracker.retrofit

import com.askemkay.grid3.tracker.retrofit.pojo.Accept
import com.askemkay.grid3.tracker.retrofit.pojo.Accepter
import com.askemkay.grid3.tracker.retrofit.pojo.PackageResponse
import com.askemkay.grid3.tracker.retrofit.pojo.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface Packages {

    @POST("/CreatePackage/")
    fun addPackage(@Body product: Product): Call<PackageResponse>

    @POST("/receivedPackage")
    fun acceptPackage(@Body orderCode : Accept): Call<Accepter>
}