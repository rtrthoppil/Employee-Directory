package com.rtr.employeedirectory.utils

import com.rtr.employeedirectory.model.response.Employee
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * API interface class
 */
interface ApiInterface {

    @GET("v2/5d565297300000680030a986")
    fun getEmployeeList(): Call<MutableList<Employee>?>
}