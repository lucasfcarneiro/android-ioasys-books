package com.lucasfagundes.ioasysbooks.feature.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.lucasfagundes.ioasysbooks.databinding.FragmentLoginBinding
import com.lucasfagundes.ioasysbooks.utils.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding : FragmentLoginBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()  //by lazy { getViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  = FragmentLoginBinding.inflate(inflater,container,false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickEnterListener()
        addObserver()
    }

    private fun clickEnterListener() {
        binding.loginButton.setOnClickListener {
            binding.apply {
                loginViewModel.login(
                    mailTextInput.text.toString(),
                    passwordTextInput.text.toString()
                )

                passwordTextInput.addTextChangedListener{
                    errorTextView.visibility = View.GONE
                }
                passwordTextInput.addTextChangedListener{
                    errorTextView.visibility = View.GONE
                }
            }
        }
    }

    private fun addObserver(){
        loginViewModel.loggerUserViewState.observe(viewLifecycleOwner){ state->

            when(state){
                is ViewState.Success ->{
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToSearchBooksFragment(state.data))
                }

                is ViewState.Error ->{
                    binding.errorTextView.text = state.throwable.message
                    binding.progressDialod.visibility = View.GONE
                    binding.errorTextView.visibility = View.VISIBLE
                }
                is ViewState.Loading ->{
                    binding.progressDialod.visibility = View.VISIBLE
                }
                else -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }
}