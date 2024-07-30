package com.example.hayatwallet.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.PersonInfoLayoutBinding


class   CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: PersonInfoLayoutBinding

    init {
        binding = PersonInfoLayoutBinding.inflate(LayoutInflater.from(context), this, true)
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.PersonInfoAttrs)
        try {
            val title = ta.getString(R.styleable.PersonInfoAttrs_title)
            val desc = ta.getString(R.styleable.PersonInfoAttrs_desc)
            binding.title.text = title
            binding.desc.text = desc
        } finally {
            ta.recycle()
        }
    }

    fun updateUI(title: String, desc: String) {
        binding.title.text = title
        binding.desc.text = desc
    }
}
