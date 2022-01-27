package com.lucasfagundes.ioasysbooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lucasfagundes.ioasysbooks.databinding.FragmentBookDetailsBottomSheetBinding

class BookDetailsBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBookDetailsBottomSheetBinding? = null
    private val binding: FragmentBookDetailsBottomSheetBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =  FragmentBookDetailsBottomSheetBinding.inflate(inflater,container,false).apply {
        _binding = this
    }.root


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}