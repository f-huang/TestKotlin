package test.testkotlin

import API.gitapi
import Model.gitmodel
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_main.*

import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    val API_URL = "http://api.openweathermap.org/data/2.5/"
    val API_KEY = "727dc3e5402d652b80c84b707b88913f"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locality: String = "2988507" //Paris city ID
        val temp_units: String = "Metric"

        val restAdapter = RestAdapter.Builder().setEndpoint(API_URL).build()

        val git = restAdapter.create(gitapi::class.java)

        git.getFeed(locality, temp_units, API_KEY, object : Callback<gitmodel>{
            override fun success(gitmodel: gitmodel, response: Response) {
                positive_response.visibility = 1

                city_name.text = gitmodel.getName() + ", " + gitmodel.getSys().getCountry()
                main_weather.text = gitmodel.getWeather()[0].getMain()
                temp.text = gitmodel.getMain().getTemp().toString() + "º"

                Glide.with(applicationContext)
                        .load("https://openclipart.org/image/2400px/svg_to_png/233791/Sunrise-Icon.png")
                        .into(sunrise_img)
                Glide.with(applicationContext)
                        .load("http://image.shutterstock.com/z/stock-vector-sunset-icon-vector-2551079.jpg")
                        .into(sunset_img)
                sunrise.append(" " + timestampToHour(gitmodel.getSys().getSunrise()))
                sunset.append(" " + timestampToHour(gitmodel.getSys().getSunset()))

                Glide.with(applicationContext)
                        .load("https://d1yn1kh78jj1rr.cloudfront.net/preview/cloud-icon_fkQZ0V_u_M.jpg")
                        .override(200, 200)
                        .into(clouds_img)
                clouds.append(" " + gitmodel.getClouds().getAll().toString() + "%")

                Glide.with(applicationContext)
                        .load("http://3.bp.blogspot.com/-BFBv_qF3tpM/VKBvMPqOJ_I/AAAAAAAAHX4/SHnl4Ypi54I/s1600/Gust-of-Wind-Emoji.png")
                        .override(200, 200)
                        .into(wind_img)
                wind.append(" " + (gitmodel.getWind().getSpeed() / 3.6).toString().substring(0, 2) + "km/h")

                Glide.with(applicationContext)
                        .load("https://image.freepik.com/free-icon/humidity_318-107086.jpg")
                        .override(200, 200)
                        .into(humidity_img)
                humidity.append(" " + gitmodel.getMain().getHumidity().toString() + "%")
            }
            override fun failure(error: RetrofitError) {
                negative_reponse.visibility = 1

                negative_reponse.text = "An error occured at : " + error.url + "\n" +
                    error.body + "\n" + error.response + "\n" + error.message
            }
        })
    }

    fun timestampToHour(timestamp: Long): String {
        val dateFormat = SimpleDateFormat("h:mm a")
        dateFormat.timeZone = TimeZone.getTimeZone("GMT")

        return dateFormat.format(timestamp * 1000)
    }
}