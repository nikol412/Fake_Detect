package ru.nikol.fakedetect.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.nikol.fakedetect.R
import ru.nikol.fakedetect.ui.check.CheckForFakeActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, CheckForFakeActivity::class.java))
    }
}
