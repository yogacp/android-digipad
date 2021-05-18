package com.yogacp.digipad.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.yogacp.digipad.databinding.LayoutDigipadBinding
import com.yogacp.digipad.extension.viewBinding
import com.yogacp.digipad.listener.OnDigipadClicked
import com.yogacp.digipad.listener.OnDigipadClickedImpl

/**
 * Created by Yoga C. Pranata on 5/18/21.
 * Android Engineer
 */
class Digipad(context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context, attrs) {

    private var length = -1
    private var listener : OnDigipadClickedImpl? = null
    private var binding: LayoutDigipadBinding? = null

    init {
        initView()
    }

    private fun initView() {
        binding = this.viewBinding(LayoutDigipadBinding::inflate)
        binding?.let {
            val constraintSet = ConstraintSet()
            addView(it.root)
            constraintSet.clone(this)
            constraintSet.match(it.root, this)
        }
    }


    /**
     * Setup Constrainset view to match parent
     */
    private fun ConstraintSet.match(view: View, parentView: View) {
        this.connect(view.id, ConstraintSet.TOP, parentView.id, ConstraintSet.TOP)
        this.connect(view.id, ConstraintSet.START, parentView.id, ConstraintSet.START)
        this.connect(view.id, ConstraintSet.END, parentView.id, ConstraintSet.END)
        this.connect(view.id, ConstraintSet.BOTTOM, parentView.id, ConstraintSet.BOTTOM)
    }


    /**
     * [setMaxLength] is optional, if you need to add max of your input length,
     * you can set the max input length using this method.
     *
     * @param length
     */
    fun setMaxLength(length: Int) {
        this.length = length
    }


    /**
     * [setOnDigipadClicked] is a listener for Digipad onscreen numbers
     *
     * @param listener
     */
    fun setOnDigipadClicked(listener: OnDigipadClicked) {
        this.listener = OnDigipadClickedImpl(listener, length)
        setupListener()
    }

    private fun setupListener() {
        binding?.digipad0?.setOnClickListener(listener)
        binding?.digipad1?.setOnClickListener(listener)
        binding?.digipad2?.setOnClickListener(listener)
        binding?.digipad3?.setOnClickListener(listener)
        binding?.digipad4?.setOnClickListener(listener)
        binding?.digipad5?.setOnClickListener(listener)
        binding?.digipad6?.setOnClickListener(listener)
        binding?.digipad7?.setOnClickListener(listener)
        binding?.digipad8?.setOnClickListener(listener)
        binding?.digipad9?.setOnClickListener(listener)
        binding?.digipadLeft?.setOnClickListener(listener)
        binding?.digipadRight?.setOnClickListener(listener)
    }


    /**
     * [setThemeColor] You can use this method if you want to custom your Digipad text colors
     * By default it will use the black text color
     *
     * @param context
     * @param resourceColor
     */
    fun setThemeColor(context: Context, @ColorRes resourceColor: Int = android.R.color.black) {
        binding?.digipad0?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad1?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad2?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad3?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad4?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad5?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad6?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad7?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad8?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipad9?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.digipadLeft?.setTextColor(ContextCompat.getColor(context, resourceColor))
        binding?.imageDelete?.setColorFilter(ContextCompat.getColor(context, resourceColor), android.graphics.PorterDuff.Mode.SRC_IN)
    }
}