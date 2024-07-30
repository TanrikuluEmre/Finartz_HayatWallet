package com.example.hayatwallet.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private val BASEURL = "https://staging-api.cusp.link"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    internal val service = retrofit.create(APIInterface::class.java)
}