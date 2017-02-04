package test.testkotlin.network.business

import com.google.gson.annotations.SerializedName


data class Main(
	@SerializedName("temp") val temperature: Float,
	@SerializedName("humidity") val humidity: Int
)