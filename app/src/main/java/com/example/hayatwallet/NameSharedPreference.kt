package com.example.hayatwallet

import android.content.Context
import android.content.SharedPreferences

object NameSharedPreference {
    private var sharedPreferences: SharedPreferences? = null
    fun init(context:Context) {
        sharedPreferences = context.getSharedPreferences("UserNamePref", Context.MODE_PRIVATE)
    }

    fun saveUsername(userName : String?){
        val editor = sharedPreferences?.edit()
        editor?.putString("username", userName)
        editor?.apply()
    }
    fun getUsername(): String? {
        return sharedPreferences?.getString("username", "")
    }
    fun clearUsername(){
        val editor = sharedPreferences?.edit()
        editor?.clear()
        editor?.apply()
    }
}