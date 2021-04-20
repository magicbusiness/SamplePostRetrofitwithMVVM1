package com.example.samplepostretrofitwithmvvm.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ObjectRetro
{
    // Interceptor
    private val client = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorRetro())
    }.build()

    // Setting Retro Link
    private val data by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Init Setting for Interface
    val getData: InterfaceRetro by lazy {
        data.create(InterfaceRetro::class.java)
    }
}