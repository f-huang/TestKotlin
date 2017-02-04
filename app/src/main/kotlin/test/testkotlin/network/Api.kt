package test.testkotlin.network

import retrofit2.Retrofit

object Api {

	lateinit var weather: test.testkotlin.network.WeatherApi

	fun init(retrofit: Retrofit) {
		weather = retrofit.create(WeatherApi::class.java)
	}
}