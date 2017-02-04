package test.testkotlin.network.business

import com.google.gson.annotations.SerializedName


data class Clouds(
	@SerializedName("all") val all: Int
)