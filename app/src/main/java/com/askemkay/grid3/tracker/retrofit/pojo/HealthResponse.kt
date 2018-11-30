package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



// Created by ask_emkay on 11/27/18.
class HealthResponse {

    @SerializedName("crs")
    @Expose
    var crs: Crs? = null
    @SerializedName("features")
    @Expose
    var features: List<Feature>? = null
    @SerializedName("pager")
    @Expose
    var pager: Pager? = null
    @SerializedName("totalFeatures")
    @Expose
    var totalFeatures: Int? = null
    @SerializedName("type")
    @Expose
    var type: String? = null

}