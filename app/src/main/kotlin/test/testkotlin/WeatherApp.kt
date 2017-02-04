package test.testkotlin
import android.app.Application
import test.testkotlin.network.Api
import test.testkotlin.network.RetrofitWeather

class WeatherApp : Application() {

	override fun onCreate() {
		super.onCreate()
		val retrofit = RetrofitWeather.build(getString(R.string.api_url_weather))
		Api.init(retrofit)
	}
}
