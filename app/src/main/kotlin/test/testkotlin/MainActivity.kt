package test.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import test.testkotlin.network.Api
import test.testkotlin.network.business.City
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		Api.weather.forCity("2988507", "Metric", getString(R.string.api_key_weather)).enqueue(
			success = { response ->
				updateUiSuccess(response.body())
			},
			localFailure = {
				updateUiError()
			},
			remoteFailure = {
				updateUiError()
			}
		)
	}

	fun updateUiSuccess(city: City) {
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

		positive_response.visibility = View.VISIBLE

		city_name.text = String.format("%s, %s", city.name, city.sys.country)
		main_weather.text = city.weather.firstOrNull()?.main
		temp.text = String.format("%sº", city.main.temperature)

		sunrise.append(timestampToHour(city.sys.sunrise, "h:mm a"))
		sunset.append(timestampToHour(city.sys.sunset, "h:mm a"))

		clouds.append("${city.clouds.all}%")
	}

	fun updateUiError() {
		negative_response.visibility = View.VISIBLE
		negative_response.text = "Error"
	}
}

private fun timestampToHour(timestamp: Long, format: String): String {
	val dateFormat = SimpleDateFormat(format, Locale.FRANCE)
	dateFormat.timeZone = TimeZone.getTimeZone("GMT")
	return dateFormat.format(timestamp * 1000)
}