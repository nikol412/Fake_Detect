package ru.nikol.fakedetect.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FakeService {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "http://keesha787898.pythonanywhere.com/"
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }


}