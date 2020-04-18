package ru.nikol.fakedetect.check

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nikol.fakedetect.common.live.SingleLiveEvent

class CheckForFakeVM: ViewModel() {
    val textField:MutableLiveData<String> = MutableLiveData("")
    val check:SingleLiveEvent<Boolean> = SingleLiveEvent()

    fun onCheckClick(){
        check.call()
    }
}