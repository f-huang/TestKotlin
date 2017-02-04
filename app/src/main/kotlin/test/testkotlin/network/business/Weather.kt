package test.testkotlin.network.business

import com.google.gson.annotations.SerializedName


data class Weather(
	@SerializedName("main") val main: String
)