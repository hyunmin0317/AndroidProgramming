package com.example.covid19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {

    val service = createRetrofit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        check.setOnClickListener { startActivity(Intent(this@ListActivity, MainActivity::class.java)) }

        service.getDataList().enqueue(
            object : Callback<ArrayList<Covid>> {
                override fun onResponse(
                    call: Call<ArrayList<Covid>>,
                    response: Response<ArrayList<Covid>>
                ) {
                    if (response.isSuccessful) {
                        val dataList = response.body()
                        val adapter = DataAdapter(
                            dataList!!,
                            LayoutInflater.from(this@ListActivity)
                        )
                        list_recyclerview.adapter = adapter
                        list_recyclerview.layoutManager = LinearLayoutManager(this@ListActivity)
                    } else {
                        Toast.makeText(this@ListActivity, "400 Bad Request", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ArrayList<Covid>>, t: Throwable) {
                    Toast.makeText(this@ListActivity, "400 Bad Request", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    fun createRetrofit(): RetrofitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
//            .baseUrl("http://covid19kr.pythonanywhere.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitService::class.java)
    }
}