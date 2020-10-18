package com.frogsm.yogurt.ui.brightness

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogsm.yogurt.databinding.ActivityBrightnessBinding

class BrightnessActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBrightnessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrightnessBinding.inflate(layoutInflater)
            .also {
                it.lifecycleOwner = this
                setContentView(it.root)
            }
    }
}