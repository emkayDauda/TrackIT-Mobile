package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Created by ask_emkay on 11/29/18.
class Accepter() {
    constructor(orderCode: String) : this()

    @SerializedName("orderCode")
    @Expose
    private var orderCode: String? = null
}

data class Accept(val orderCode: String)