package com.frogsm.yogurt.ui.bottomsheet

import com.frogsm.yogurt.ui.bottomsheet.list.DynamicBottomSheetDelegate
import com.frogsm.yogurt.ui.bottomsheet.list.DynamicBottomSheetDelegateImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface DynamicBottomSheetModule {

    @Binds
    fun bindsDelegate(delegate: DynamicBottomSheetDelegateImpl): DynamicBottomSheetDelegate
}