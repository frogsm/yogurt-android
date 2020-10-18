package com.frogsm.yogurt.util

import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface BrightnessDelegate {

    fun initBrightness(fragment: Fragment)

    fun brightnessMax(isMax: Boolean)

    fun brightnessBack()

}


class BrightnessDelegateImpl : BrightnessDelegate, LifecycleObserver {

    private var fragment: Fragment? = null

    private var brightness = -1f

    override fun initBrightness(fragment: Fragment) {
        val fragmentLifecycle = fragment.viewLifecycleOwner.lifecycle
        val activityWindowAttr = fragment.getActivityWindowAttr()

        this.fragment = fragment
        this.brightness = activityWindowAttr.screenBrightness

        // LifecycleObserver 등록
        fragmentLifecycle.addObserver(this)

        brightnessMax(false)
    }


    override fun brightnessMax(isMax: Boolean) {
        fragment?.let {

            val windowAttr = it.getActivityWindowAttr()
            windowAttr.screenBrightness = if (isMax) {
                1f
            } else {
                0.8f
            }

            it.applyWindowAttr(windowAttr)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun brightnessBack() {
        fragment?.let {

            val windowAttr = it.getActivityWindowAttr()
            windowAttr.screenBrightness = brightness

            it.applyWindowAttr(windowAttr)
        }
    }

    private fun Fragment.applyWindowAttr(layoutParams: WindowManager.LayoutParams) {
        requireActivity().window.attributes = layoutParams
    }

    private fun Fragment.getActivityWindowAttr(): WindowManager.LayoutParams {
        return requireActivity().window.attributes
    }

}