package ru.nikol.fakedetect.ui.check

import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.nikol.fakedetect.API
import ru.nikol.fakedetect.common.live.SingleLiveEvent
import ru.nikol.fakedetect.network.FakeService
import ru.nikol.fakedetect.network.pojo.response.CheckLinkResponse


class CheckForFakeVM: ViewModel() {
    val textField:MutableLiveData<String> = MutableLiveData("")
    val check:SingleLiveEvent<CheckLinkResponse> = SingleLiveEvent()
    val retrofitInstance: Retrofit? = FakeService.retrofitInstance
    val service = retrofitInstance!!.create(API::class.java)

    fun onCheckClick(){
        //check.call()
        if(textField.value != null) {
            sendLink(textField.value!!)
        }
    }

    fun sendLink(url:String) {
        service.checkLink(url)?.enqueue(object: Callback<CheckLinkResponse>{
            override fun onFailure(
                call: Call<CheckLinkResponse>,
                t: Throwable
            ) {
                check.value = null
                Log.d("retrofit", "$t")
            }

            override fun onResponse(
                call: Call<CheckLinkResponse>,
                response: Response<CheckLinkResponse>
            ) {
                //check.value = response.body()?.prob.toString()
                val checkResponse = response.body()
                checkResponse?.url = textField.value
                check.value = checkResponse
                Log.d("retrofit", response.toString())
            }


        })
    }



}