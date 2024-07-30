package com.example.hayatwallet.Network.Response

import android.widget.ImageView

data class LoginRequest(val userName:String?,val password:String?)
data class LoginResponse(val item:Item,val errorCode:Int?,val errorMessage:String?)
data class Item(val token:String?,
                val isSuccess:Boolean?,
                val redirectToTwoFactor:Boolean?,
                val enabledTwoFactorMethods:Boolean?,
                val message:String?)

data class PersonInformation(val item:Person,val errorCode:Int?,val errorMessage:String?)
data class Person(val userId:String?,
                  val userName:String?,
                  val email:String?,
                  val phoneNumber:String?,
                  val firstName:String?,
                  val lastName:String?,
                  val profileName:String?)

data class PersonDataControl(val isSuccess:Boolean?,val token:String?)

data class CampaignData(val img:ImageView?,val title :String?)
