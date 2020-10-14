package com.frogsm.yogurt.ui.bottomsheet.list

import android.view.View
import com.frogsm.yogurt.databinding.DynamicBottomSheetTextItemBinding
import javax.inject.Inject

interface DynamicBottomSheetDelegate :
    DynamicBottomSheetTextDelegate

class DynamicBottomSheetDelegateImpl @Inject constructor(
    dynamicBottomSheetTextDelegateImpl: DynamicBottomSheetTextDelegateImpl
) : DynamicBottomSheetDelegate,
    DynamicBottomSheetTextDelegate by dynamicBottomSheetTextDelegateImpl


// 텍스트 타입
interface DynamicBottomSheetTextDelegate {
    fun onBind(view: View, item: DynamicBottomSheetItem.Text)
}

class DynamicBottomSheetTextDelegateImpl @Inject constructor(
) : DynamicBottomSheetTextDelegate {

    override fun onBind(
        view: View,
        item: DynamicBottomSheetItem.Text
    ) {
        DynamicBottomSheetTextItemBinding.bind(view).also {
            it.item = item
            it.executePendingBindings()
        }
    }
}