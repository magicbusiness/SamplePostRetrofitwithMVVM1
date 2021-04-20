package com.example.samplepostretrofitwithmvvm.network

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorRetro: Interceptor
{
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authentication", "Sample Auth")
            .addHeader("Token", "Sample Token")
            .build()

        return chain.proceed(request)
    }
}