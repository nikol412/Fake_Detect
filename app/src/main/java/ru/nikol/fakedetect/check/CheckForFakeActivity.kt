package ru.nikol.fakedetect.check

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.jetbrains.anko.toast
import ru.nikol.fakedetect.R
import ru.nikol.fakedetect.databinding.ActivityCheckForFakeBinding

class CheckForFakeActivity : AppCompatActivity() {

    val model: CheckForFakeVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_for_fake)
        val binding = DataBindingUtil.setContentView<ActivityCheckForFakeBinding>(
            this,
            R.layout.activity_check_for_fake
        )
        binding.viewModel = model

        model.check.observe(this, Observer {
            toast("its okey")
        })

    }
}
