package com.example.covid19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    val service = createRetrofit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd")
        var Date = simpleDateFormat.format(System.currentTimeMillis())
        changeDate(Date)


        calendar_view.setOnDateChangeListener { calendarView, year, month, day ->
            Date = "%04d.%02d.%02d".format(year, month+1, day)
            changeDate(Date)
        }

        check.setOnClickListener { startActivity(Intent(this@MainActivity, ListActivity::class.java)) }
    }

    fun changeDate(date: String) {
        date_view.text = date

        service.getDateList(date).enqueue(
            object : Callback<Covid> {
                override fun onResponse(call: Call<Covid>, response: Response<Covid>) {
                    val data = response.body()
                    val nodata = "데이터가 없습니다."
                    if (data==null)
                        changeData(nodata, nodata, nodata, nodata)
                    else
                        changeData(data.confirmed, data.death, data.today_confirmed, data.today_death)
                }

                override fun onFailure(call: Call<Covid>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "서버 오류", Toast.LENGTH_LONG).show()
                }
            })
    }

    fun createRetrofit(): RetrofitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
//            .baseUrl("http://covid19kr.pythonanywhere.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitService::class.java)
    }

    fun changeData(c: String?, d: String?, tc: String?, td: String?) {
        confirmed.text = c
        death.text = d
        today_confirmed.text = tc
        today_death.text = td
    }
}