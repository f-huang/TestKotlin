package test.testkotlin.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitWeather {

	fun build(baseUrl: String): Retrofit {
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.client(OkHttpClient.Builder().build())
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}
}