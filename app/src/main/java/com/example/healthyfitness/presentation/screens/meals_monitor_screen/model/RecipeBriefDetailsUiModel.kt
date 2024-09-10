package com.example.healthyfitness.presentation.screens.meals_monitor_screen.model

data class RecipeBriefDetailsUiModel(
    val dishName: String,
    val amount: Int,
    val readyInMinutes: Int,
    val calories: Float,
    val imageUrl: String
)
