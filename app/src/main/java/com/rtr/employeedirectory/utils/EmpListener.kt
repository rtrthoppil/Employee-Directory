package com.rtr.employeedirectory.utils

import com.rtr.employeedirectory.model.EmployeeCardModel

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Interface for employee data clicks
 */
interface EmpListener {

    fun onClickEmpData(model : EmployeeCardModel)
}