package com.frogsm.yogurt.util

import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface BrightnessDelegate {
    fun initBrightness(fragment: Fragment)
}


class BrightnessDelegateImpl : BrightnessDelegate, LifecycleObserver {

    private lateinit var fragment: Fragment

    private val window: Window
        get() = fragment.requireActivity().window

    private var brightness = -1f

    override fun initBrightness(fragment: Fragment) {
        val fragmentLifecycle = fragment.viewLifecycleOwner.lifecycle

        this.fragment = fragment
        this.brightness = window.attributes.screenBrightness

        // LifecycleObserver 등록
        fragmentLifecycle.addObserver(this)

        brightnessMax(true)
    }


    private fun brightnessMax(isMax: Boolean) {
        with(window.attributes) {
            screenBrightness = if (isMax) {
                1f
            } else {
                0.8f
            }
            window.attributes = this
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        with(window.attributes) {
            screenBrightness = brightness
            window.attributes = this
        }
    }

}