package com.frogsm.yogurt.ui.brightness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.frogsm.yogurt.databinding.FragmentBrightnessApplyBinding
import com.frogsm.yogurt.util.BrightnessDelegate
import com.frogsm.yogurt.util.BrightnessDelegateImpl
import com.frogsm.yogurt.util.autoCleared

class BrightnessApplyFragment : Fragment(),
    BrightnessDelegate by BrightnessDelegateImpl() {

    private var binding: FragmentBrightnessApplyBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrightnessApplyBinding.inflate(inflater, container, false)
            .also {
                it.lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner) {
                parentFragmentManager.popBackStack()
            }

        initBrightness(this)
    }
}