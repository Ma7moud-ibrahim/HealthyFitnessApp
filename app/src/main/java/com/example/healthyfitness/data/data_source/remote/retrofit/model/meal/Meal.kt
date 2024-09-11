package com.example.healthyfitness.data.data_source.remote.retrofit.model.meal

data class Meal(
    val id: Int,
    val imageType: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val title: String
)