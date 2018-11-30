package com.askemkay.grid3.tracker.retrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



// Created by ask_emkay on 11/27/18.
class RealProperties {

    @SerializedName("accessibility")
    @Expose
    var accessibility: Any? = null
    @SerializedName("alternate_name")
    @Expose
    var alternateName: Any? = null
    @SerializedName("cce_availability")
    @Expose
    var cceAvailability: String? = null
    @SerializedName("cce_last_updated")
    @Expose
    var cceLastUpdated: String? = null
    @SerializedName("cce_quantity")
    @Expose
    var cceQuantity: Any? = null
    @SerializedName("functional_status")
    @Expose
    var functionalStatus: String? = null
    @SerializedName("geometry_type")
    @Expose
    var geometryType: String? = null
    @SerializedName("global_id")
    @Expose
    var globalId: String? = null
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null
    @SerializedName("lga_code")
    @Expose
    var lgaCode: String? = null
    @SerializedName("lga_name")
    @Expose
    var lgaName: String? = null
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null
    @SerializedName("mnch2")
    @Expose
    var mnch2: Any? = null
    @SerializedName("mnch2_last_updated")
    @Expose
    var mnch2LastUpdated: Any? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("ownership")
    @Expose
    var ownership: String? = null
    @SerializedName("ri_service_status")
    @Expose
    var riServiceStatus: String? = null
    @SerializedName("state_code")
    @Expose
    var stateCode: String? = null
    @SerializedName("state_name")
    @Expose
    var stateName: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("ward_code")
    @Expose
    var wardCode: String? = null
    @SerializedName("ward_name")
    @Expose
    var wardName: String? = null

}