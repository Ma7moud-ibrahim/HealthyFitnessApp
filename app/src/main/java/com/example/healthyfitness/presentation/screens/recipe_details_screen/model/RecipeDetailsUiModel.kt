package com.example.healthyfitness.presentation.screens.recipe_details_screen.model

data class RecipeDetailsUiModel(
    val name: String,
    val imageUrl: String,
    val ingredients: List<IngredientUiModel>,
    val instructions: List<String>,
    val nutrition: Map<String, String>
)