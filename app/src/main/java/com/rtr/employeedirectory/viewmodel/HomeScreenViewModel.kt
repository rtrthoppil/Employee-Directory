package com.rtr.employeedirectory.viewmodel

import android.app.Application
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.rtr.employeedirectory.R
import com.rtr.employeedirectory.base.BaseViewModel
import com.rtr.employeedirectory.model.EmployeeCardModel
import com.rtr.employeedirectory.model.HeaderModel
import com.rtr.employeedirectory.model.response.Employee
import com.rtr.employeedirectory.repository.EmployeeDataSource
import com.rtr.employeedirectory.utils.ApiInterface
import com.rtr.employeedirectory.utils.AppConstUtils
import com.rtr.employeedirectory.utils.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * View model for home screen
 */
class HomeScreenViewModel(app : Application) : BaseViewModel(app) {

    var employeeList : MutableLiveData<MutableList<EmployeeCardModel>> = MutableLiveData()
    var isDataEmpty : ObservableBoolean = ObservableBoolean(true)

    fun setUpHeaderForHome(){
        addHeaderData(HeaderModel(title = ObservableField(appContext.getString(R.string.app_name))))
    }

    /**
     * Method to call get employee list API
     */
    fun getEmployeeList() {
        showProgressView(true)
        if(checkInternetConnectivity()){
            val retrofit = RetrofitHelper.getRetrofitInstance()
            val  apiInterface = retrofit.create(ApiInterface::class.java)
            val call = apiInterface.getEmployeeList()
            call.enqueue(object  : Callback<MutableList<Employee>?> {
                override fun onFailure(call: Call<MutableList<Employee>?>, error: Throwable) {
                    showErrorMessageView(true)
                }
                override fun onResponse(call: Call<MutableList<Employee>?>, response: Response<MutableList<Employee>?>) {
                    val refreshData = checkApiResponse(response.code())
                    if(refreshData == null){
                        handleApiResponse(response)
                    }else showErrorMessageView(true)
                }
            })
        }else showErrorMessageView(true)
    }

    /**
     * Method to handle API response
     */
    fun handleApiResponse(response: Response<MutableList<Employee>?>){
        if(response.body() is MutableList<Employee>){
            val responseData = response.body() as MutableList<Employee>
            employeeList.value = EmployeeDataSource().getArrangedData(responseData)
        }else employeeList.value = null
        showContentView(true)
    }

    override fun onClickRetryButton(view: View) {
        super.onClickRetryButton(view)
        getEmployeeList()
    }

}