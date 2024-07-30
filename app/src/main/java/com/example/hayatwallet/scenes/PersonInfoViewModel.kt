package com.example.hayatwallet.scenes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hayatwallet.Network.Network.service
import com.example.hayatwallet.Network.Response.LoginResponse
import com.example.hayatwallet.Network.Response.PersonInformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonInfoViewModel : ViewModel() {

    val personInfo = MutableLiveData<PersonInformation?>()

    fun getPersonInfo(token:String?){
        service.viewUser(token).enqueue(object : Callback<PersonInformation> {
            override fun onResponse(call: Call<PersonInformation>, response: Response<PersonInformation>) {
                handleResponse(response.body())
            }
            override fun onFailure(call: Call<PersonInformation>, t: Throwable) {
                handleResponse(response = null)
            }

        })
    }
    fun handleResponse(response: PersonInformation?){
        personInfo.value = response
    }
}