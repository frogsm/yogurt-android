package com.frogsm.yogurt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel @ViewModelInject constructor(
) : ViewModel() {

    private val _action = MutableLiveData<Navigate>()
    val action: LiveData<Navigate> get() = _action

    fun onBottomSheetClicked() {
        _action.value = Navigate.BottomSheetActivity
    }

    sealed class Navigate {
        object BottomSheetActivity : Navigate()
    }
}