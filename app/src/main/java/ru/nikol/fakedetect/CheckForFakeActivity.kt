package ru.nikol.fakedetect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.nikol.fakedetect.databinding.ActivityCheckForFakeBinding

class CheckForFakeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_for_fake)
        val binding = DataBindingUtil.setContentView<ActivityCheckForFakeBinding>(
            this,
            R.layout.activity_check_for_fake
        )
        binding.activity = this
    }
}
