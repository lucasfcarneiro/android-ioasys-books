package com.lucasfagundes.ioasysbooks.base_app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.lucasfagundes.ioasysbooks.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            )
        }, 1000)
    }
}