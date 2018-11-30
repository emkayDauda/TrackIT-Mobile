package com.askemkay.grid3.tracker

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.askemkay.grid3.tracker.retrofit.Packages
import com.askemkay.grid3.tracker.retrofit.pojo.Accept
import com.askemkay.grid3.tracker.retrofit.pojo.Accepter

import kotlinx.android.synthetic.main.activity_accept_package.*
import kotlinx.android.synthetic.main.content_accept_package.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AcceptPackage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accept_package)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        progressBar2?.visibility = View.INVISIBLE


        acceptOrder?.setOnClickListener {
            progressBar2?.visibility = View.VISIBLE

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

            val accept = Accept(orderCode?.text?.toString() ?: "1")
            val response = serve.acceptPackage(accept)

            response.enqueue(object: Callback<Accepter>{
                override fun onFailure(call: Call<Accepter>, t: Throwable) {
                    Toast.makeText(this@AcceptPackage, "${t.message}", Toast.LENGTH_LONG).show()
                    progressBar2?.visibility = View.INVISIBLE
                }

                override fun onResponse(call: Call<Accepter>, response: Response<Accepter>) {
                    Toast.makeText(this@AcceptPackage, "Package Accepted", Toast.LENGTH_LONG).show()
                    progressBar2?.visibility = View.INVISIBLE
                }
            })

        }
    }

}
