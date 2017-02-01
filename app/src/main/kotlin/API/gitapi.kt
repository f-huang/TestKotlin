package API

import Model.gitmodel
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Query

interface gitapi {
    @GET("/weather")

    fun getFeed(@Query("id") city: String, @Query("units") units:String,
                @Query("appid") app_key: String, cb: Callback<gitmodel>)
}