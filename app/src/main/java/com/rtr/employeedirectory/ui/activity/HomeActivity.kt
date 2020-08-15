package com.rtr.employeedirectory.ui.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rtr.employeedirectory.R
import com.rtr.employeedirectory.base.BaseActivity
import com.rtr.employeedirectory.databinding.ActivityHomeBinding
import com.rtr.employeedirectory.model.EmployeeCardModel
import com.rtr.employeedirectory.ui.adapter.EmployeeRecyclerViewAdapter
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
        binding.viewModel = viewModel
        addObserver()
        viewModel.setUpHeaderForHome()
        viewModel.getEmployeeList()
    }

    /**
     * Method to add observer
     */
    private fun addObserver(){
        viewModel.employeeList.observe(this, Observer<MutableList<EmployeeCardModel>> {
            if(it != null && it.size > 0) {
                viewModel.isDataEmpty.set(false)
                setAdapterForEmployeeListing(it)
            }else viewModel.isDataEmpty.set(true)
        })
    }

    /**
     * Method to set adapter
     */
    private fun setAdapterForEmployeeListing(list : MutableList<EmployeeCardModel>){
        binding.recyclerViewEmployee.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            adapter = EmployeeRecyclerViewAdapter(list)
        }
    }
}