package com.frogsm.yogurt.ui.brightness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.frogsm.yogurt.R
import com.frogsm.yogurt.databinding.FragmentBrightnessBinding
import com.frogsm.yogurt.util.autoCleared

class BrightnessFragment : Fragment() {

    private var binding: FragmentBrightnessBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrightnessBinding.inflate(inflater, container, false)
            .also {
                it.lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.brightnessButton.setOnClickListener {
            childFragmentManager.beginTransaction()
                .add(R.id.fragment_container, BrightnessApplyFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}