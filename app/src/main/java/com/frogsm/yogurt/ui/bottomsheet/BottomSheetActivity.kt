package com.frogsm.yogurt.ui.bottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogsm.yogurt.databinding.ActivityBottomSheetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater).also {
            it.lifecycleOwner = this
            setContentView(it.root)
        }

        DynamicBottomSheetFragment.newInstance()
            .show(supportFragmentManager, TAG_BOTTOM_SHEET)
    }

    companion object {

        private const val TAG_BOTTOM_SHEET = "bottom_sheet"
    }
}