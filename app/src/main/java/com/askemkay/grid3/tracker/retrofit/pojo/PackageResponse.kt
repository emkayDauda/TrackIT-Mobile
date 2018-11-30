package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



// Created by ask_emkay on 11/29/18.
class PackageResponse {

    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("product")
    @Expose
    var product: Product? = null

}