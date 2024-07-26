package com.example.hayatwallet.scenes

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.TextView

class WelcomeFragmentViewModel {

    fun bold(startBold:Int,endBold:Int,text:String,textView: TextView){
        val spannable = SpannableString(text)

        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            startBold,
            endBold,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannable
    }
    fun normal(start:Int,end:Int,text:String,textView: TextView){
        val spannable = SpannableString(text)

        spannable.setSpan(
            StyleSpan(Typeface.NORMAL),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannable
    }

}