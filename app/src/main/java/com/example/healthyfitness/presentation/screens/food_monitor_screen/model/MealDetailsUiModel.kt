package com.example.healthyfitness.presentation.screens.food_monitor_screen.model

data class MealDetailsUiModel(
    val mealName: String,
    val totalCalories: Float,
    val dishes: List<DishDetailsUiModel>
)
