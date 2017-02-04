package test.testkotlin

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Call<T>.enqueue(success: (Response<T>) -> Unit, localFailure: (Throwable) -> Unit, remoteFailure: (Response<T>) -> Unit) {
    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, error: Throwable) {
            localFailure(error)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (!response.isSuccessful) {
                remoteFailure(response)
            } else {
                success(response)
            }
        }
    })
}
