package com.frogsm.yogurt.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.frogsm.yogurt.R
import com.frogsm.yogurt.databinding.ActivityMainBinding
import com.frogsm.yogurt.extension.observeNotNull
import com.frogsm.yogurt.ui.bottomsheet.BottomSheetActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
            setContentView(it.root)
        }

        initView()
        initBinding()
    }

    private fun initView() {

    }

    private fun initBinding() {
        viewModel.action.observeNotNull(this) {
            when (it) {
                MainActivityAction.NavigateBottomSheet -> {
                    val intent = Intent(this, BottomSheetActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}