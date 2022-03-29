package com.lucasfagundes.ioasysbooks.feature.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.lucasfagundes.ioasysbooks.common.utils.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.lucasfagundes.ioasysbooks.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleClickListener()
        clearError()
        addObserver()
    }

    private fun handleClickListener() {
        with(binding) {
            loginButton.setOnClickListener {
                viewModel.login(
                    emailTextInput.text.toString(),
                    passwordTextInput.text.toString()
                )
            }
        }
    }

    private fun clearError() {
        with(binding) {
            passwordTextInput.addTextChangedListener {
                errorTextView.visibility = View.GONE
            }
            emailTextInput.addTextChangedListener {
                errorTextView.visibility = View.GONE
            }
        }
    }

    private fun addObserver() {
        viewModel.loginLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                when (state) {
                    is ViewState.Loading ->
                        progressDialog.visibility = View.VISIBLE
                    is ViewState.Success -> {
                        findNavController().navigate(
                            LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                    }
                    is ViewState.Error -> {
                        progressDialog.visibility = View.GONE
                        errorTextView.visibility = View.VISIBLE
                        errorTextView.text = state.throwable.message
                    }
                    else -> Unit
                }
            }
        }
    }
}