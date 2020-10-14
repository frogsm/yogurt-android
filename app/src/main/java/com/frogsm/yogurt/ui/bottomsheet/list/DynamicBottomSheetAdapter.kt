package com.frogsm.yogurt.ui.bottomsheet.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.android.extensions.LayoutContainer
import javax.inject.Inject

@FragmentScoped
class DynamicBottomSheetAdapter @Inject constructor(
    private val delegate: DynamicBottomSheetDelegate
) : ListAdapter<DynamicBottomSheetItem, DynamicBottomSheetViewHolder>(Diff) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DynamicBottomSheetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return DynamicBottomSheetViewHolder(view)
    }

    override fun onBindViewHolder(holder: DynamicBottomSheetViewHolder, position: Int) {
        holder.bind(currentList[position], delegate)
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].layoutRes
    }

    private object Diff : DiffUtil.ItemCallback<DynamicBottomSheetItem>() {
        override fun areItemsTheSame(
            oldItem: DynamicBottomSheetItem,
            newItem: DynamicBottomSheetItem
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: DynamicBottomSheetItem,
            newItem: DynamicBottomSheetItem
        ): Boolean = oldItem == newItem
    }
}

class DynamicBottomSheetViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(
        item: DynamicBottomSheetItem,
        delegate: DynamicBottomSheetDelegate
    ) {
        item.presentUi(containerView, delegate)
    }
}