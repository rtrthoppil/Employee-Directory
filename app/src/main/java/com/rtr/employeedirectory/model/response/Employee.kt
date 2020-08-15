package com.rtr.employeedirectory.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Data class for employee data
 */
data class Employee(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("profile_image") val profileImage: String?,
    @SerializedName("address") val address: Address?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("website") val website: String?,
    @SerializedName("company") val company: Company?
)

/**
 * Data class for employee address
 */
data class Address(
    @SerializedName("street") val street: String?,
    @SerializedName("suite") val suite: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("zipcode") val zipCode: String?,
    @SerializedName("geo") val geo: Geo?
)

/**
 * Data class for employee company
 */
data class Company(
    @SerializedName("name") val name: String?,
    @SerializedName("catchPhrase") val catchPhrase: String?,
    @SerializedName("bs") val bs: String?
)

/**
 * Data class for employee geo data
 */
data class Geo(
    @SerializedName("lat") val lat: Double?,
    @SerializedName("lng") val lng: Double?
)