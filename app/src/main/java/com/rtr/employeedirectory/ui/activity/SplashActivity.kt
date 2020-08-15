package com.rtr.employeedirectory.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rtr.employeedirectory.R
import com.rtr.employeedirectory.base.BaseActivity
import com.rtr.employeedirectory.databinding.ActivitySplashBinding
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
    }
}