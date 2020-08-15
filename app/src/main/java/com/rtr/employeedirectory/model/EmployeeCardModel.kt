package com.rtr.employeedirectory.model

import android.os.Parcelable
import android.view.View
import androidx.databinding.ObservableField
import com.rtr.employeedirectory.utils.EmpListener
import kotlinx.android.parcel.Parcelize

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Data class for employee data
 */
@Parcelize
data class EmployeeCardModel(
    var empId : ObservableField<String> = ObservableField(""),
    var empUserName : ObservableField<String> = ObservableField(""),
    var empName : ObservableField<String> = ObservableField(""),
    var empCompany : ObservableField<String> = ObservableField(""),
    var empEmail : ObservableField<String> = ObservableField(""),
    var empMobile : ObservableField<String> = ObservableField(""),
    var empAddress : ObservableField<String> = ObservableField(""),
    var empImageUrl : ObservableField<String> = ObservableField(""),
    var empWebSite : ObservableField<String> = ObservableField("")
) : Parcelable {

    var listener : EmpListener? = null

    fun onClickEmployeeCard(view : View){
        listener?.onClickEmpData(this)
    }
}