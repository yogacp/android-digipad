package com.yogacp.digipad.helper

import android.view.View
import com.yogacp.digipad.R
import com.yogacp.digipad.extension.toArrayList

/**
 * Created by Yoga C. Pranata on 5/18/21.
 * Android Engineer
 */
class DigipadHelper {

    private val DELETE_NUMBER = -1
    private val UNKNOWN_NUMBER = -2

    fun getNumber(view: View?): Int {
        return when(view?.id) {
            R.id.digipad0 -> 0
            R.id.digipad1 -> 1
            R.id.digipad2 -> 2
            R.id.digipad3 -> 3
            R.id.digipad4 -> 4
            R.id.digipad5 -> 5
            R.id.digipad6 -> 6
            R.id.digipad7 -> 7
            R.id.digipad8 -> 8
            R.id.digipad9 -> 9
            R.id.digipadRight -> DELETE_NUMBER
            else -> UNKNOWN_NUMBER
        }
    }

    fun getNumbers(length: Int, numbers: List<Int>, input: Int): List<Int> {
        val inputNumbers = numbers.toArrayList()

        when(input) {
            UNKNOWN_NUMBER -> {
                //Do Nothing for unknown input
            }
            DELETE_NUMBER -> {
                if(inputNumbers.isNotEmpty()) {
                    inputNumbers.removeAt(inputNumbers.size - 1)
                }
            }
            else -> {
                if(length == -1 || (length > 0 && inputNumbers.size < length)) {
                    inputNumbers.add(input)
                }
            }
        }

        return inputNumbers.toList()
    }

}