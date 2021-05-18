package com.yogacp.digipad.listener

import android.view.View
import com.yogacp.digipad.helper.DigipadHelper

/**
 * Created by Yoga C. Pranata on 5/18/21.
 * Android Engineer
 */
class OnDigipadClickedImpl(private val listener: OnDigipadClicked, private val length: Int = -1) : View.OnClickListener {

    private val digipadHelper = DigipadHelper()
    private var numbers = listOf<Int>()

    override fun onClick(view: View?) {
        view?.let {
            val number = digipadHelper.getNumber(it)
            numbers = digipadHelper.getNumbers(length, numbers, number)
            val stringNumbers = numbers.joinToString("")
            listener.onClicked(stringNumbers)
        } ?: run {
            throw NullPointerException("No view attached to Digipad")
        }
    }
}