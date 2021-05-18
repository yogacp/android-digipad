package com.yogacp.digipad.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * Created by Yoga C. Pranata on 5/18/21.
 * Android Engineer
 */
fun <T> List<T>?.toArrayList(): ArrayList<T> {
    val list = arrayListOf<T>()
    this?.forEach { list.add(it) }
    return list
}

inline fun <T : ViewBinding> ViewGroup.viewBinding(binding: (LayoutInflater, ViewGroup, Boolean) -> T): T {
    return binding(LayoutInflater.from(context), this, false)
}