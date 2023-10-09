package com.example.simple

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.util.Locale


class MainActivity : AppCompatActivity()  {
    var userList = arrayListOf<Weather>()
    var tv: TextView? = null
    var tv2: TextView? = null
    var tv3: TextView? = null
    var tv4: TextView? = null
    var tv5: TextView? = null
    var humidity: TextView? = null
    var et: EditText? = null
    var city: String? = null
    var shahar: TextView? = null
    var calling: TextView? = null
    var recyclerView: RecyclerView? = null
    var b1: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        recyclerView =  findViewById(R.id.recyclerview)
        tv = findViewById(R.id.tv)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
        tv4 = findViewById(R.id.tv4)
        tv5 = findViewById(R.id.tv5)
        humidity = findViewById(R.id.humidity)
        et = findViewById(R.id.et)

        shahar= findViewById(R.id.shahar)
        calling = findViewById(R.id.calling)

        //  city=et.getText().toString();
    }

    fun get(v: View?) {
        city = et!!.text.toString()
        val queue = Volley.newRequestQueue(applicationContext)
        val url2 =
            "https://api.openweathermap.org/data/2.5/weather?q=" + city!!.lowercase(Locale.getDefault()) + "&appid=ddbf071c3cd3d6e5a1a9373851c1b8fe"

//        val url = "http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=aa0a1d32f411e7433a62d450fe379424"
        val request = JsonObjectRequest(Request.Method.GET, url2, null, { response ->

                    val array = response.getJSONObject("main")
                    //JSONArray array=  response.getJSONArray("main");
                    val s = array.getString("temp")
                    tv!!.text = "Temperature: " + s + " K"

            val s2 = array.getString("temp_min")
            tv2!!.text = s + " K"
            val s3 = array.getString("feels_like")
            tv3!!.text = s + " K"
            val s4 = array.getString("temp_min")
            tv4!!.text = s + " K"
            val s5 = array.getString("feels_like")
            tv5!!.text = s + " K"

            val h1 = array.getString("humidity")
            humidity!!.text = "Humidity: " + h1 + " gramm meter cubic "


            val t = array.getString("pressure")
                    shahar!!.text = "Pressure: " + t + " PA"


                    val a = city!!.uppercase()
                    calling!!.text = a;


//            val jsonArray = response.getJSONArray("Weather")
//            for (i in 0 until jsonArray.length()){
//                val jsonObj = jsonArray.getJSONObject(i)
//
//                val weather = Weather(
//                    jsonObj.getString("description"),
//                    jsonObj.getString("main")
//                )
//
//                userList.add(weather)
//            }
//
//            recyclerView?.layoutManager = LinearLayoutManager(this)
//            recyclerView?.adapter = UserAdapter(userList)



            }) { error ->
            tv!!.text = error.toString()

//            shahar!!.text=error.toString()

        }
        queue.add(request)
    }

    val listener= View.OnClickListener { view ->
        when (view.getId()) {
            R.id.mover -> {
                // Do some work here
            }
        }
    }


}