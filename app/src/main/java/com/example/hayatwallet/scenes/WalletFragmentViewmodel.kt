package com.example.hayatwallet.scenes

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hayatwallet.Network.Response.TransactionSummary
import com.example.hayatwallet.R

class WalletFragmentViewmodel : ViewModel() {
    private var transactionListAll: MutableList<TransactionSummary> = mutableListOf()

    fun getTransactionList() : MutableList<TransactionSummary>{
        transactionListAll.add(TransactionSummary((R.mipmap.ic_launcher),"Migros","14:22","₺251,28"))
        transactionListAll.add(TransactionSummary((R.mipmap.ic_launcher),"Bim","17:22","₺421,28"))
        transactionListAll.add(TransactionSummary((R.mipmap.ic_launcher),"A101","17:22","₺421,28"))
        transactionListAll.add(TransactionSummary((R.mipmap.ic_launcher),"McDonalds","17:22","₺421,28"))
        transactionListAll.add(TransactionSummary((R.mipmap.ic_launcher),"Burger King","17:22","₺421,28"))
        transactionListAll.add(TransactionSummary((R.mipmap.ic_launcher),"Starbucks","17:22","₺421,28"))
        transactionListAll.add(TransactionSummary((R.mipmap.ic_launcher),"Şok","17:22","₺421,28"))
        transactionListAll.add(TransactionSummary((R.drawable.apple_logo_svgrepo_com),"Apple","13:22","₺875,23"))
        transactionListAll.add(TransactionSummary((R.drawable.google),"Google","12:52","₺195,53"))
        transactionListAll.add(TransactionSummary((R.drawable.netflix),"Netflix","17:22","₺421,28"))

        return transactionListAll
    }
    fun changeSize(text:String) : SpannableString{
        val spannable = SpannableString(text)
        var newText = text.split(",").toTypedArray()
        spannable.setSpan(
            RelativeSizeSpan(10f),
            0,
            newText[0].length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            RelativeSizeSpan(2f),
            newText[0].length+1,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        Log.d("SpannableString", "Generated SpannableString: $spannable")
        return spannable
    }
}