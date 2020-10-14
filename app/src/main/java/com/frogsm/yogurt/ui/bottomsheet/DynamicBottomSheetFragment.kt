package com.frogsm.yogurt.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frogsm.yogurt.R
import com.frogsm.yogurt.databinding.FragmentDynamicBottomSheetBinding
import com.frogsm.yogurt.extension.observeNotNull
import com.frogsm.yogurt.ui.bottomsheet.list.DynamicBottomSheetAdapter
import com.frogsm.yogurt.util.autoCleared
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DynamicBottomSheetFragment : BottomSheetDialogFragment() {

    private var binding: FragmentDynamicBottomSheetBinding by autoCleared()
    private val viewModel: DynamicBottomSheetViewModel by viewModels()

    @Inject
    lateinit var dynamicBottomSheetAdapter: DynamicBottomSheetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_BottomSheetDialog_Light)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDynamicBottomSheetBinding
            .inflate(inflater, container, false)
            .also {
                it.viewModel = viewModel
                it.lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initBinding()
        viewModel.start(emptyList())
    }

    private fun initView() {
        // behavior 초기화
        val behavior = (dialog as? BottomSheetDialog)?.behavior
        behavior?.skipCollapsed = true
        behavior?.state = BottomSheetBehavior.STATE_EXPANDED

        binding.itemList.apply {
            adapter = dynamicBottomSheetAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    private fun initBinding() {
        viewModel.bottomSheetItems.observeNotNull(viewLifecycleOwner) {
            dynamicBottomSheetAdapter.submitList(it)
        }
    }

    companion object {

        fun newInstance(): DynamicBottomSheetFragment {
            return DynamicBottomSheetFragment().apply {
                this.arguments = bundleOf()
            }
        }
    }
}