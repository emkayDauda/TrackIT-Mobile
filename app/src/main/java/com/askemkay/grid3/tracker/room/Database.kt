package com.askemkay.grid3.tracker.room

import androidx.room.Database
import androidx.room.RoomDatabase

// Created by ask_emkay on 11/28/18.

@Database(entities = arrayOf(HealthFacility::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): FacilityDao
}