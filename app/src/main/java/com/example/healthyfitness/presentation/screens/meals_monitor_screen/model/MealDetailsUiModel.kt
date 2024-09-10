package com.example.healthyfitness.presentation.screens.meals_monitor_screen.model

data class MealDetailsUiModel(
    val mealName: String,
    val totalCalories: Float,
    val recipe: RecipeBriefDetailsUiModel
)
