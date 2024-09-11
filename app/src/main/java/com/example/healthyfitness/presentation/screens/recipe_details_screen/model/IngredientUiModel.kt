package com.example.healthyfitness.presentation.screens.recipe_details_screen.model

data class IngredientUiModel(
    val name: String,
    val amount: String,
    val unit: String,
    val image: String,
    val imageUrl: String = "https://img.spoonacular.com/ingredients_500x500/$image"
)
