package com.frogsm.yogurt.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, crossinline func: (T) -> Unit) {
    observe(owner, Observer { data -> data?.let { func(it) } })
}