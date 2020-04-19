package ru.nikol.fakedetect.ui.check

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.toast
import ru.nikol.fakedetect.R
import ru.nikol.fakedetect.databinding.ActivityCheckForFakeBinding
import ru.nikol.fakedetect.network.pojo.response.CheckLinkResponse


class CheckForFakeActivity : AppCompatActivity() {

    val model: CheckForFakeVM by viewModels()
    lateinit var binding: ActivityCheckForFakeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_for_fake)
        binding = DataBindingUtil.setContentView<ActivityCheckForFakeBinding>(
            this,
            R.layout.activity_check_for_fake
        )
        val recieveValue = intent.getStringExtra(Intent.EXTRA_TEXT)
        if (recieveValue != null) {
            model.textField.value = recieveValue
        }
        binding.viewModel = model
        binding.lifecycleOwner = this
        model.check.observe(this, Observer {
            if (it == null) {
                alert {
                    title = "Error"
                    message = "Sorry, something went wrong"
                    okButton { }
                }
            } else {
                toast(it.prob.toString())
                if (!binding.nothindText.isGone) binding.nothindText.visibility = View.GONE
                addResult(it)
                //TODO realize visualization response
            }
        })
    }

    fun addResult(result: CheckLinkResponse) {
        val linear = LinearLayout(this)
        linear.orientation = LinearLayout.HORIZONTAL
        val tv1 = TextView(this)
        tv1.text = result.url
        tv1.movementMethod = LinkMovementMethod.getInstance();
        tv1.setTextAppearance(R.style.middle_description_text)
        tv1.width = 200

        val view: View = View(this)
        view.layoutParams = ViewGroup.LayoutParams(200, ViewGroup.LayoutParams.WRAP_CONTENT)

        val tv2 = TextView(this)
        tv2.text = (Math.round(result.prob!! * 100.0) / 100.0).toString()
        tv2.setTextAppearance(R.style.middle_description_text)


        linear.addView(tv1)
        linear.addView(view)
        linear.addView(tv2)
        binding.resultsLayout.addView(linear)
    }
}
