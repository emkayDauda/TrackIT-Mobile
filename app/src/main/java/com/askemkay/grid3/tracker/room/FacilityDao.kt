package com.askemkay.grid3.tracker.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.askemkay.grid3.tracker.retrofit.pojo.RealProperties

@Dao
interface FacilityDao {
    @Insert
    fun addAll(vararg facility: HealthFacility)

    @Query("SELECT * FROM healthFacilities")
    fun getAll(): List<HealthFacility>

    @Query("Delete FROM healthFacilities")
    fun deleteAll()

    @Query("Select * FROM healthFacilities")
    fun getAllFacilities(): List<HealthFacility>

    @Query("SELECT name FROM healthFacilities")
    fun getAllNames(): List<String>

    @Query("SELECT * FROM healthFacilities WHERE name = :name")
    fun findByName(name: String): HealthFacility


}