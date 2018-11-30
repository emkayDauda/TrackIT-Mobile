package com.askemkay.grid3.tracker.fragments

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.askemkay.grid3.tracker.R
import com.askemkay.grid3.tracker.retrofit.HealthFacilities
import com.askemkay.grid3.tracker.retrofit.pojo.HealthResponse
import kotlinx.android.synthetic.main.fragment_create_order.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import android.widget.ArrayAdapter
import com.askemkay.grid3.tracker.room.*
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.widget.Toast
import com.askemkay.grid3.tracker.retrofit.Packages
import com.askemkay.grid3.tracker.retrofit.pojo.PackageResponse
import com.askemkay.grid3.tracker.retrofit.pojo.Product


// Created by ask_emkay on 11/27/18.
class CreateOrder: Fragment() {
    lateinit var facilities: MutableList<HealthFacility>
    var facilityNames: List<String> = listOf("KMashi", "Mando", "Kawo")
    val MY_PREFS_NAME = "sharedPrefs"
    lateinit var editor: SharedPreferences.Editor

    var client = OkHttpClient()
    lateinit var adapter: ArrayAdapter<String>

    lateinit var db: AppDatabase



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        db = Room.databaseBuilder(
            activity?.applicationContext!!,
            AppDatabase::class.java, "actualTable"
        )
            .fallbackToDestructiveMigration()
            .build()


        editor = activity?.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)?.edit()!!
//        GetFacilityNames(db).execute()

        return inflater.inflate(R.layout.fragment_create_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        grabDataSet(db)
        GetFacilityNames(db).execute()




        createOrder.setOnClickListener { it ->
            val orderId = orderId.text.toString()
            val driverNum = qty.text.toString()
            val qty = driverId.text.toString()
            val packageName = productName.text.toString()
            val type = activity?.getSharedPreferences("SharedPref", MODE_PRIVATE)?.getString("type", "Vaccine")
            val source = sourceTextView.text.toString()
            val destination = destinationTextView.text.toString()

            val a = Product()
//            a.id = orderId
            a.orderCode = orderId
            a.qty = qty
            a.driverId = driverNum
            a.packageName = packageName
            a.packageType = type
            a.source = source
            a.destination = destination


            val logging = HttpLoggingInterceptor()

            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor(logging)
            httpClient.callTimeout(2L, TimeUnit.MINUTES)
            httpClient.connectTimeout(2L, TimeUnit.MINUTES)
            httpClient.readTimeout(2L, TimeUnit.MINUTES)


            var retrofit = Retrofit.Builder()
                .baseUrl("https://teamegress.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()

            val serve = retrofit.create(Packages::class.java)

            val response = serve.addPackage(a)

            response.enqueue(object: Callback<PackageResponse>{
                override fun onFailure(call: Call<PackageResponse>, t: Throwable) {
                    Toast.makeText(activity?.baseContext, "${t.message}", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<PackageResponse>, response: Response<PackageResponse>) {
                    Toast.makeText(activity?.baseContext, "Package Created", Toast.LENGTH_LONG).show()
                }
            })

            


//            grabDataSet()
        }

//        queryDb.setOnClickListener {
//            val g = AsyncDelete(db)
//            g.execute()
//        }

        progressBar.visibility  = View.VISIBLE

    }

    fun grabDataSet(db: AppDatabase) {

        val logging = HttpLoggingInterceptor()

//        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()

//        httpClient.addInterceptor(logging)
        httpClient.callTimeout(2L, TimeUnit.MINUTES)
        httpClient.connectTimeout(2L, TimeUnit.MINUTES)
        httpClient.readTimeout(2L, TimeUnit.MINUTES)


        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.grid-nigeria.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        val service = retrofit.create(HealthFacilities::class.java)

        val response = service.getUsers(2000, "state_name IN ('Kaduna')")

        response.enqueue(object : Callback<HealthResponse> {

            override fun onFailure(p0: Call<HealthResponse>, p1: Throwable) {
                println(p1.message)
                hideProgressbar()
            }

            override fun onResponse(p0: Call<HealthResponse>, p1: Response<HealthResponse>) {
                hideProgressbar()
                if (p1.code() == 200){
                    val healthResponse = p1.body()
                    val facilities = healthResponse?.features
                    val ac = facilities?.map {
                        val prop = it.properties
                        HealthFacility(
                            accessibility = prop?.accessibility as String?,
                            cceAvailability = prop?.cceAvailability,
                            alternateName = prop?.alternateName as String?,
                            cceLastUpdated = prop?.cceLastUpdated,
                            cceQuantity = prop?.cceQuantity as Double?,
                            functionalStatus = prop?.functionalStatus,
                            riServiceStatus = prop?.riServiceStatus,
                            stateCode = prop?.stateCode,
                            stateName = prop?.stateName,
                            lgaName = prop?.lgaName,
                            wardName = prop?.wardName,
                            globalId = prop?.globalId,
                            latitude = prop?.latitude,
                            longitude = prop?.longitude,
                            lgaCode = prop?.lgaCode,
                            mnch2 = prop?.mnch2 as String?,
                            name = prop?.name,
                            mnch2LastUpdated = prop?.mnch2LastUpdated as String?,
                            wardCode = prop?.wardCode,
                            geometryType = prop?.geometryType,
                            ownership = prop?.ownership,
                            type = prop?.type
                        )
                    }
                    val task = AsyncInsert(db)
                    task.execute(ac)
                }else{
                    Log.e("OkHttp", "Response Code: ${p1.code()}\n${p1.message()}")
                }
            }
        })
    }

    private fun showProgressBar(){
        progressBar?.visibility = View.VISIBLE
    }

    private fun hideProgressbar(){
        progressBar?.visibility = View.INVISIBLE
    }

    private fun checkDbSize(){
        val checkerTask = CheckSize(db)
        checkerTask.execute()
    }

    inner class GetFacilityNames(val db: AppDatabase): AsyncTask<Void, Void, List<String>>(){
        override fun onPostExecute(result: List<String>?) {
            super.onPostExecute(result)
            facilityNames = result!!
//            Log.e("OkHttp.Facilities", "${facilityNames.size}")

            adapter = ArrayAdapter(
                activity?.baseContext,
                android.R.layout.simple_dropdown_item_1line, facilityNames
            )
            sourceTextView.setAdapter<ArrayAdapter<String>>(adapter)
            destinationTextView.setAdapter<ArrayAdapter<String>>(adapter)
            adapter.notifyDataSetChanged()

        }

        override fun doInBackground(vararg p0: Void?): List<String> {
            return db.userDao().getAllNames()
        }
    }

    inner class GetSelectedFacilities(db: AppDatabase, place: String): AsyncTask<String, Void, HealthFacility>(){
        override fun onPostExecute(result: HealthFacility?) {
            super.onPostExecute(result)


//            val r = result as Serializable

//            editor.putString(pla, r.toString())
//            editor.putInt("idName", 12)
//            editor.apply()

//            val c =activity?.baseContext?.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)
//            c?.getString()

        }

        override fun doInBackground(vararg p0: String): HealthFacility {

            return db.userDao().findByName(p0[0])
        }
    }
}