package com.project.justai.configuration

import com.project.justai.property.BotProperty
import com.project.justai.retrofit.interceptor.VkApiKeyInterceptor
import com.project.justai.retrofit.VkMessageApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class RetrofitConfiguration(
    private val botProperty: BotProperty
) {

    @Bean
    fun messageApi(): VkMessageApi = Retrofit.Builder()
        .baseUrl(botProperty.apiVk)
        .client(httpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(VkMessageApi::class.java)

    private fun httpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BASIC
            }
        )
        .addInterceptor(VkApiKeyInterceptor(botProperty.accessToken, botProperty.versionApi))
        .build()
}
