package test.testkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_main.*

import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response

import API.apiUrl
import Model.apiCurrentWeather
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    val API_URL = "http://api.openweathermap.org/data/2.5/"
    val API_KEY = "727dc3e5402d652b80c84b707b88913f"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val locality: String = "2988507"
        val temp_units: String = "Metric"

        val restAdapter = RestAdapter.Builder().setEndpoint(API_URL).build()
        val apiUrl = restAdapter.create(apiUrl::class.java)

        apiUrl.getFeed(locality, temp_units, API_KEY, object : Callback<apiCurrentWeather> {
            override fun success(apiRet: apiCurrentWeather, response: Response) {
                positive_response.visibility = 1

                val images = mapOf<ImageView, String>(
                        sunrise_img to "https://openclipart.org/image/2400px/svg_to_png/233791/Sunrise-Icon.png",
                        sunset_img to "http://image.shutterstock.com/z/stock-vector-sunset-icon-vector-2551079.jpg",
                        clouds_img to "https://d1yn1kh78jj1rr.cloudfront.net/preview/cloud-icon_fkQZ0V_u_M.jpg",
                        wind_img to "https://maxcdn.icons8.com/Share/icon/Transport//windsock1600.png",
                        humidity_img to "http://avtech.com/images/home/icons/Icon_Pool.png"
                )

                for ((view, url) in images) {
                    Glide.with(applicationContext)
                            .load(url)
                            .override(210, 210)
                            .into(view)
                }

                city_name.text = String.format("%s, %s", apiRet.getName(), apiRet.getSys().getCountry())
                main_weather.text = apiRet.getWeather()[0].getMain()
                temp.text = String.format("%sº", apiRet.getMain().getTemp().toString())

                sunrise.append(apiRet.getSys().getSunrise())
                sunset.append(apiRet.getSys().getSunset())

                clouds.append(apiRet.getClouds().getAll())
                wind.append(apiRet.getWind().convertSpeed("km/h"))
                humidity.append(apiRet.getMain().getHumidity())
            }

            override fun failure(error: RetrofitError) {
                negative_reponse.visibility = 1
                negative_reponse.text = String.format("Error at : %s\nResponded with : %s\nMessage : %s\n%s",
                        error.url, error.response, error.message, error.body)
            }
        })
    }
}