package test.testkotlin.network

import test.testkotlin.network.business.City
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

	@GET("weather")
	fun forCity(
		@Query("id") city: String,
		@Query("units") units: String,
		@Query("appid") app_key: String
	): Call<City>
}