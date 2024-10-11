package com.example.healthyfitness.data.data_source.remote.retrofit.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>

//    @POST("login")
//    fun login(@Body request: SignUpRequest): Call<SignUpResponse>
}