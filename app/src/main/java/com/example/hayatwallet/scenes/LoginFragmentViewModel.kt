package com.example.hayatwallet.scenes

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hayatwallet.Network.Network.service
import com.example.hayatwallet.Network.Response.Item
import com.example.hayatwallet.Network.Response.LoginRequest
import com.example.hayatwallet.Network.Response.LoginResponse
import com.example.hayatwallet.Network.Response.PersonDataControl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class LoginFragmentViewModel() : ViewModel(){

    val isLogged = MutableLiveData<PersonDataControl?>()

    public fun login(userName:String?,password:String?){
        val credentials : LoginRequest = LoginRequest(userName,password)
        service.login(credentials).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    val persondatacontrol = PersonDataControl(response.body()?.item?.isSuccess,response.body()?.item?.token)
                    handleResponse(persondatacontrol)

                    Log.d("response",response.body().toString())
                }else{
                    val persondatacontrol = PersonDataControl(response.body()?.item?.isSuccess,response.body()?.item?.token)
                    handleResponse(persondatacontrol)
                    Log.e("response",response.body().toString())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                Log.e("response",t.message.toString())
            }
        })
    }
    public fun handleResponse(response: PersonDataControl?){
        isLogged.value = response
    }

}