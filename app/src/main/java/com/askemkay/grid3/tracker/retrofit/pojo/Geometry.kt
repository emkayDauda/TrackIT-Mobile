package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



// Created by ask_emkay on 11/27/18.
class Geometry {

    @SerializedName("coordinates")
    @Expose
    var coordinates: List<Double>? = null
    @SerializedName("type")
    @Expose
    var type: String? = null

}