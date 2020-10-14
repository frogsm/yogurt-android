package com.frogsm.yogurt.ui.bottomsheet

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frogsm.yogurt.ui.bottomsheet.list.DynamicBottomSheetItem

class DynamicBottomSheetViewModel @ViewModelInject constructor(
) : ViewModel() {

    private val _bottomSheetItems = MutableLiveData<List<DynamicBottomSheetItem>>()
    val bottomSheetItems: LiveData<List<DynamicBottomSheetItem>> get() = _bottomSheetItems

    fun start(items: List<DynamicBottomSheetItem>) {
        val temp = listOf(
            DynamicBottomSheetItem.Text(text = "테스트1"),
            DynamicBottomSheetItem.Text(text = "테스트2"),
            DynamicBottomSheetItem.Text(text = "테스트3"),
            DynamicBottomSheetItem.Text(text = "테스트4"),
            DynamicBottomSheetItem.Text(text = "테스트5")
        )

        _bottomSheetItems.value = temp
    }

}