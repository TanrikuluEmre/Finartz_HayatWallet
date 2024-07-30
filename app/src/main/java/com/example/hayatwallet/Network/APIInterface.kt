package com.example.hayatwallet.Network


import com.example.hayatwallet.Network.Response.LoginRequest
import com.example.hayatwallet.Network.Response.LoginResponse
import com.example.hayatwallet.Network.Response.PersonInformation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface APIInterface {
    @POST("/User/signin")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("/user/viewuser")
    fun viewUser(@Header("Authorization") auth: String?): Call<PersonInformation>

}