package com.project.justai.retrofit.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class VkApiKeyInterceptor(
    private val apiKey: String,
    private val version: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url.newBuilder()
            .addQueryParameter("access_token", apiKey)
            .addQueryParameter("v", version)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}
