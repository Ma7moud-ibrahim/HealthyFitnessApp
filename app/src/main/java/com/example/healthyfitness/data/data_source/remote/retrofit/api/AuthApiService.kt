package com.example.healthyfitness.data.data_source.remote.retrofit.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)
interface AuthApiService {

    @Headers(
        "X-RapidAPI-Key: f5c2a1285fmshd9145a7ea1c218fp1e912fjsnf6694311f1da",
        "X-RapidAPI-Host: register73.p.rapidapi.com",
        "Content-Type: application/json"
    )
    @POST("register")
    suspend fun registerUser(
        @Body request: RegisterRequest
    ): Response<Void>
}