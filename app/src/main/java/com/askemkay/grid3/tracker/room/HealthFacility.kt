package com.askemkay.grid3.tracker.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// Created by ask_emkay on 11/28/18.

@Entity(tableName = "healthFacilities")
data class HealthFacility(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "accessibility") var accessibility: String? = null,
    @ColumnInfo(name = "alternate_name") var alternateName: String? = null,
    @ColumnInfo(name = "cce_availability") var cceAvailability: String? = null,
    @ColumnInfo(name = "cce_last_updated") var cceLastUpdated: String? = null,
    @ColumnInfo(name = "cce_quantity") var cceQuantity: Double? = null,
    @ColumnInfo(name = "functional_status") var functionalStatus: String? = null,
    @ColumnInfo(name = "geometry_type") var geometryType: String? = null,
    @ColumnInfo(name = "global_id") var globalId: String? = null,
    @ColumnInfo(name = "latitude") var latitude: Double? = null,
    @ColumnInfo(name = "longitude") var longitude: Double? = null,
    @ColumnInfo(name = "lga_code") var lgaCode: String? = null,
    @ColumnInfo(name = "lga_name") var lgaName: String? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "mnch2") var mnch2: String? = null,
    @ColumnInfo(name = "mnch2last_updated") var mnch2LastUpdated: String? = null,
    @ColumnInfo(name = "ownership") var ownership: String? = null,
    @ColumnInfo(name = "state_code") var stateCode: String? = null,
    @ColumnInfo(name = "state_name") var stateName: String? = null,
    @ColumnInfo(name = "type") var type: String? = null,
    @ColumnInfo(name = "ri_service_status") var riServiceStatus: String? = null,
    @ColumnInfo(name = "ward_code") var wardCode: String? = null,
    @ColumnInfo(name = "ward_name") var wardName: String? = null
    ): Serializable {

}