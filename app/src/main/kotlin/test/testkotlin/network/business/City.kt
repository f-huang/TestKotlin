package test.testkotlin.network.business

import com.google.gson.annotations.SerializedName


data class City(
	@SerializedName("name") val name: String,
	@SerializedName("weather") val weather: List<Weather>,
	@SerializedName("main") val main: Main,
	@SerializedName("wind") val wind: Wind,
	@SerializedName("clouds") val clouds: Clouds,
	@SerializedName("sys") val sys: Sys
)