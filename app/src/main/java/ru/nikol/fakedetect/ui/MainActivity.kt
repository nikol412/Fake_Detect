package ru.nikol.fakedetect.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nikol.fakedetect.R
import ru.nikol.fakedetect.ui.check.CheckForFakeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, CheckForFakeActivity::class.java))
    }
}
