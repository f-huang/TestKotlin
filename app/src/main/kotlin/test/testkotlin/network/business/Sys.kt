package test.testkotlin.network.business

import com.google.gson.annotations.SerializedName


data class Sys(
	@SerializedName("sunrise") val sunrise: Long,
	@SerializedName("sunset") val sunset: Long,
	@SerializedName("country") val country: String
)