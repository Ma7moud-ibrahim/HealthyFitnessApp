package com.example.healthyfitness.data.data_source.remote.retrofit.model.recipe

data class IngredientX(
    val amount: Double,
    val id: Int,
    val name: String,
    val nutrients: List<NutrientX>,
    val unit: String
)