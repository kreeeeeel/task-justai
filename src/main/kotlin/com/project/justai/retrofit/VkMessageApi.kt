package com.project.justai.retrofit

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface VkMessageApi {

    @POST("messages.send")
    suspend fun sendMessage(
        @Query("user_id") userId: Long,
        @Query("message") message: String,
        @Query("random_id") randomId: Int = 0
    ): Response<Void>
}
