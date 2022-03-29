package com.lucasfagundes.ioasysbooks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.ioasysbooks.databinding.FragmentHomeBinding
import com.lucasfagundes.ioasysbooks.databinding.FragmentLoginBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding : FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  = FragmentHomeBinding.inflate(inflater,container,false).apply {
        _binding = this
    }.root


}