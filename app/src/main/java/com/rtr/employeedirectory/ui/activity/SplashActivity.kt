package com.rtr.employeedirectory.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import com.rtr.employeedirectory.R
import com.rtr.employeedirectory.base.BaseActivity
import com.rtr.employeedirectory.databinding.ActivitySplashBinding
import com.rtr.employeedirectory.utils.AppConstUtils.CONST_TIMER_2500
import com.rtr.employeedirectory.viewmodel.SplashViewModel

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Activity class for splash screen
 */
class SplashActivity : BaseActivity() {

    private lateinit var viewModel: SplashViewModel
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        binding = setContentViewForActivity(R.layout.activity_splash, viewModel) as ActivitySplashBinding
        Handler(Looper.getMainLooper()).postDelayed({ navigateToHomeScreen() }, CONST_TIMER_2500)
    }

    /**
     * Method to navigate to home screen
     */
    private fun navigateToHomeScreen(){
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}