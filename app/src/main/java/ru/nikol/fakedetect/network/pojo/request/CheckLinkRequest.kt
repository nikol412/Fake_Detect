package ru.nikol.fakedetect.network.pojo.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CheckLinkRequest {
    @SerializedName("url")
    @Expose
    var url: String? = null
}