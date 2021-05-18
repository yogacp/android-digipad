package com.digipad.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import com.digipad.sample.databinding.ActivityMainBinding
import com.yogacp.digipad.listener.OnDigipadClicked

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private val inputMaxLength = 10
    private var inputNumbers = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDigipad()
        alwaysHideSoftKeyboard()
    }

    private fun alwaysHideSoftKeyboard() {
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }

    /**
     * Default setup for Digipad
     */
    private fun setupDigipad() {

        //Set input max length
        binding.digipad.setMaxLength(inputMaxLength)

        //Set the theme color
        binding.digipad.setThemeColor(this, android.R.color.holo_blue_dark)

        //Set the listener
        binding.digipad.setOnDigipadClicked(object : OnDigipadClicked {
            override fun onClicked(numbers: String) {
                inputNumbers = numbers
                binding.etNumbers.setText(inputNumbers)

                if (inputNumbers.length == inputMaxLength) {
                    showMessage("Numbers: $inputNumbers")
                }
            }
        })
    }

    private fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}