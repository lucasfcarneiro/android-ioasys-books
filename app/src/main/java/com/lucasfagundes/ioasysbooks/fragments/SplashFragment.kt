package com.lucasfagundes.ioasysbooks.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lucasfagundes.ioasysbooks.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper())
            .postDelayed(
                {
                    findNavController().navigate(
                        com.lucasfagundes.ioasysbooks.fragments.SplashFragmentDirections.actionSplashFragmentToLoginFragment()
                    )
                }, 1000
            )
    }
}