package com.rtr.employeedirectory.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rtr.employeedirectory.R
import com.rtr.employeedirectory.base.BaseActivity
import com.rtr.employeedirectory.databinding.ActivityDetailsBinding
import com.rtr.employeedirectory.model.EmployeeCardModel
import com.rtr.employeedirectory.utils.AppConstUtils.INTENT_KEY_MODEL
import com.rtr.employeedirectory.viewmodel.EmpDetailsViewModel

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Details activity for employee details
 */
class EmpDetailsActivity : BaseActivity() {

    private lateinit var viewModel: EmpDetailsViewModel
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmpDetailsViewModel::class.java)
        binding = setContentViewForActivity(R.layout.activity_details, viewModel) as ActivityDetailsBinding
        binding.model = intent?.extras?.getParcelable(INTENT_KEY_MODEL) as EmployeeCardModel?
    }
}