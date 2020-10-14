package com.frogsm.yogurt.ui.bottomsheet.list

import android.view.View
import androidx.annotation.LayoutRes
import com.frogsm.yogurt.R

sealed class DynamicBottomSheetItem(
    @LayoutRes open val layoutRes: Int
) : Presenter {

    data class Text(
        override val layoutRes: Int = R.layout.dynamic_bottom_sheet_text_item,
        val text: String
    ) : DynamicBottomSheetItem(layoutRes) {

        override fun presentUi(view: View, delegate: DynamicBottomSheetDelegate) {
            delegate.onBind(view, this)
        }
    }
}

interface Presenter {
    fun presentUi(view: View, delegate: DynamicBottomSheetDelegate)
}