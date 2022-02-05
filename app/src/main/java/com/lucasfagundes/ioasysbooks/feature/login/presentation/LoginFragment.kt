package com.lucasfagundes.ioasysbooks.feature.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.ioasysbooks.R
import com.lucasfagundes.ioasysbooks.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleClickListener()
        addObserver()
    }

    private fun handleClickListener() {
        with(binding){
            loginButton.setOnClickListener{

            }
        }
    }

    private fun addObserver() {

    }
}