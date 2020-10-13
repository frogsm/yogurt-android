package com.frogsm.yogurt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel @ViewModelInject constructor(
) : ViewModel() {

    private val _action = MutableLiveData<MainActivityAction>()
    val action: LiveData<MainActivityAction> get() = _action

    fun onBottomSheetClicked() {
        _action.value = MainActivityAction.NavigateBottomSheet
    }
}