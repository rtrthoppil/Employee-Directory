package com.rtr.employeedirectory.repository

import androidx.databinding.ObservableField
import com.rtr.employeedirectory.model.EmployeeCardModel
import com.rtr.employeedirectory.model.response.Employee
import com.rtr.employeedirectory.utils.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Manager class for fetching employee data
 */
class EmployeeDataSource {

    /**
     * Method to arrange employee data
     */
    fun getArrangedData(data : MutableList<Employee>) : MutableList<EmployeeCardModel>? {
        val list = mutableListOf<EmployeeCardModel>()
        data.let {
            for(item in it){
                val address = item.address?.street ?: "" + " " +
                item.address?.city ?: "" + " " +
                item.address?.zipCode ?: ""
                list.add(EmployeeCardModel(
                    empId = ObservableField("" + item.id),
                    empUserName = ObservableField(item.username ?: ""),
                    empName = ObservableField(item.name ?: ""),
                    empCompany = ObservableField(item.company?.name ?:""),
                    empEmail = ObservableField(item.email ?: ""),
                    empMobile = ObservableField(item.phone ?: ""),
                    empAddress = ObservableField(address),
                    empImageUrl = ObservableField(item.profileImage ?: ""),
                    empWebSite = ObservableField(item.website ?: "")
                ))
            }
        }
        return list
    }

}