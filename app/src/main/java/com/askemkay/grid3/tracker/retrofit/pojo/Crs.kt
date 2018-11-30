package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



// Created by ask_emkay on 11/27/18.
class Crs {

    @SerializedName("properties")
    @Expose
    private var properties: Properties? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null

    fun getProperties(): Properties? {
        return properties
    }

    fun setProperties(properties: Properties) {
        this.properties = properties
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

}