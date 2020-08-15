package com.rtr.employeedirectory.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import com.rtr.employeedirectory.R
import com.rtr.employeedirectory.base.BaseViewModel
import com.rtr.employeedirectory.model.HeaderModel

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * View model for home screen
 */
class HomeScreenViewModel(app : Application) : BaseViewModel(app) {

    fun setUpHeaderForHome(){
        addHeaderData(HeaderModel(title = ObservableField(appContext.getString(R.string.app_name))))
    }

}