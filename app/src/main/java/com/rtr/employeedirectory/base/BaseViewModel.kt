package com.rtr.employeedirectory.base

import android.app.Application
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.rtr.employeedirectory.model.HeaderModel
import com.rtr.employeedirectory.model.RefreshModel

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Base ViewModel class for implementing common features of ViewModel classes
 */
open class BaseViewModel(var appContext: Application) : AndroidViewModel(appContext) {

    var showContent: ObservableBoolean = ObservableBoolean(true)
    var showProgress: ObservableBoolean = ObservableBoolean(false)
    var showHeader: ObservableBoolean = ObservableBoolean(false)
    var showErrorMessage: ObservableBoolean = ObservableBoolean(false)
    var refreshModel: ObservableField<RefreshModel> = ObservableField()
    var headerModel: ObservableField<HeaderModel> = ObservableField()

    /**
     * Method to display header
     */
    fun displayHeader(status: Boolean = true) {
        showHeader.set(status)
    }

    /**
     * Method to show content view
     * @param status : Boolean value for show and hide
     */
    fun showContentView(status: Boolean) {
        showContent.set(status)
        showProgress.set(!status)
        showErrorMessage.set(!status)
    }

    /**
     * Method to show error message view
     * @param status : Boolean value for show and hide
     */
    fun showErrorMessageView(status: Boolean) {
        refreshModel.set(getDefaultErrorMessageDetails())
        showContent.set(!status)
        showProgress.set(!status)
        showErrorMessage.set(status)
    }

    /**
     * Method to get default error message details
     */
    private fun getDefaultErrorMessageDetails(): RefreshModel = RefreshModel()

    /**
     * Method to show progress view
     */
    fun showProgressView(status: Boolean) {
        showContent.set(status)
        showProgress.set(status)
        showErrorMessage.set(!status)
    }

    /**
     * open click listener for retry button on error message view
     */
    open fun onClickRetryButton(view: View) { /*  Do not delete this method */ }

    /**
     * Click listener for header left icon
     */
    open fun onClickHeaderLeftIcon(view: View) { /*  Do not delete this method */ }
}