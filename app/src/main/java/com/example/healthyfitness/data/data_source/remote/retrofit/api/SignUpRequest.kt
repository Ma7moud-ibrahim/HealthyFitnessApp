package com.example.healthyfitness.data.data_source.remote.retrofit.api

data class SignUpRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)