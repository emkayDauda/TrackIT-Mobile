package com.askemkay.grid3.tracker.room

import android.os.AsyncTask
import android.util.Log
import com.askemkay.grid3.tracker.fragments.CreateOrder

// Created by ask_emkay on 11/28/18.
class AsyncInsert(val db: AppDatabase): AsyncTask<List<HealthFacility>, Void, String>() {
    override fun doInBackground(vararg p0: List<HealthFacility>?): String {

//        db.userDao().deleteAll()

        val facilities = p0[0]
        if (facilities != null){
            for (facility in facilities){
                db.userDao().addAll(facility)
            }
        }

        return  "Completed..."
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        println("$result")
        Log.e("OkHttp.Room", "$result")

        //Get names for autocomplete textview after filling database
//        CreateOrder().GetFacilityNames(db).execute()

    }

    override fun onCancelled(result: String?) {
        super.onCancelled(result)
    }
}

class AsyncDelete(val db: AppDatabase): AsyncTask<Void, Void, String>(){
    override fun doInBackground(vararg p0: Void?): String {
        db.userDao().deleteAll()

        return "All records deleted..."
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        println("$result")
        Log.e("OkHttp.Room", result)
    }
}
class CheckSize(val db: AppDatabase): AsyncTask<Void, Void, Int>(){
    override fun doInBackground(vararg p0: Void?): Int{
        val g = db.userDao().getAll()

        return g.size
    }

    override fun onPostExecute(result: Int) {
        if (result == 0)
            CreateOrder().grabDataSet(db)
//        else CreateOrder().GetFacilityNames(db).execute()
        super.onPostExecute(result)

        println("$result")
        Log.e("OkHttp.Room", "$result")
    }
}