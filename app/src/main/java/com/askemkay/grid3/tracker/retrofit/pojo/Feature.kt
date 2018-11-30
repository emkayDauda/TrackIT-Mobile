package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



// Created by ask_emkay on 11/27/18.
class Feature {

    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null
    @SerializedName("geometry_name")
    @Expose
    var geometryName: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("properties")
    @Expose
    var properties: RealProperties? = null
    @SerializedName("type")
    @Expose
    var type: String? = null

}