package com.monica.ec3_monica_gonzales_.data.retrofit

import com.monica.ec3_monica_gonzales_.data.response.ListEcResponse
import retrofit2.http.GET

interface ListService {
    @GET("hug?amount=50")
    suspend fun gatAllList(): ListEcResponse
}