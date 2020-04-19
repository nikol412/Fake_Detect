package ru.nikol.fakedetect

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.nikol.fakedetect.network.pojo.response.CheckLinkResponse


interface API {
    @GET("/get_prob/url")
    fun checkLink(@Query("url") url: String?): Call<CheckLinkResponse>?
}