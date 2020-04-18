package ru.nikol.fakedetect.network.pojo.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CheckLinkResponse {
    @SerializedName("prob")
    @Expose
    var prob: Double? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}