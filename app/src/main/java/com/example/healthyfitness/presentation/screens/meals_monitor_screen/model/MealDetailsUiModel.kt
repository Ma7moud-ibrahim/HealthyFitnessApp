package com.example.healthyfitness.presentation.screens.meals_monitor_screen.model

data class MealDetailsUiModel(
    val id: Int,
    val mealName: String,
    val totalCalories: Float,
    val recipe: RecipeBriefDetailsUiModel
)
