package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


// Created by ask_emkay on 11/29/18.
public class Product{

    @SerializedName("_id")
    @Expose
    var id: String? = null
    @SerializedName("orderCode")
    @Expose
    var orderCode: String? = null
    @SerializedName("packageType")
    @Expose
    var packageType: String? = null
    @SerializedName("packageName")
    @Expose
    var packageName: String? = null
    @SerializedName("driverId")
    @Expose
    var driverId: String? = null
    @SerializedName("source")
    @Expose
    var source: String? = null
    @SerializedName("destination")
    @Expose
    var destination: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("qty")
    @Expose
    var qty: String? = null
    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null
    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null
    @SerializedName("__v")
    @Expose
    var v: Int? = null

}