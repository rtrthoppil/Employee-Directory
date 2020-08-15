package com.rtr.employeedirectory.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rtr.employeedirectory.R
import com.rtr.employeedirectory.base.BaseActivity
import com.rtr.employeedirectory.databinding.ActivityHomeBinding
import com.rtr.employeedirectory.viewmodel.HomeScreenViewModel

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Activity class for Home screen
 */
class HomeActivity : BaseActivity() {

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)
        binding = setContentViewForActivity(R.layout.activity_home, viewModel) as ActivityHomeBinding
        viewModel.setUpHeaderForHome()
        viewModel.showProgressView(true)
    }
}