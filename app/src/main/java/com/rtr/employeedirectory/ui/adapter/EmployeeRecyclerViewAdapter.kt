package com.rtr.employeedirectory.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rtr.employeedirectory.databinding.LayoutEmployeeBinding
import com.rtr.employeedirectory.model.EmployeeCardModel
import com.rtr.employeedirectory.utils.EmpListener

/**
 * Created by RAHUL T R
 * Copyright (c) 2020 . All rights reserved.
 */

/**
 * Recycler view adapter class for listing employees
 */
class EmployeeRecyclerViewAdapter(var employeeList : MutableList<EmployeeCardModel>, var listener : EmpListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CartViewHolder(LayoutEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false), listener)
    }

    override fun getItemCount(): Int = employeeList.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CartViewHolder).setModel(employeeList[position])
    }

    /**
     * View holder class for employee listing
     */
    inner class CartViewHolder(var binding: LayoutEmployeeBinding,  var listener : EmpListener) :
        RecyclerView.ViewHolder(binding.root) {
        fun setModel(item: EmployeeCardModel) {
            item.listener = listener
            binding.model = item
        }
    }
}