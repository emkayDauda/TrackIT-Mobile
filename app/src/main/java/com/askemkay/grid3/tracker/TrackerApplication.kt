package com.askemkay.grid3.tracker

import android.app.Application
import androidx.room.Room
import com.askemkay.grid3.tracker.room.AppDatabase

// Created by ask_emkay on 11/29/18.
class TrackerApplication: Application() {
    private lateinit var db: AppDatabase
    private lateinit var instance: TrackerApplication
    init {

    }
    override fun onCreate() {
        super.onCreate()

        instance = this

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "actualTable"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    val appDatabase get() = this.db

     val mInstance get() = this.instance
}