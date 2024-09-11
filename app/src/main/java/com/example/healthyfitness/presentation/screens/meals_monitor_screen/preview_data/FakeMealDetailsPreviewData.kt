package com.example.healthyfitness.presentation.screens.meals_monitor_screen.preview_data

import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.MealDetailsUiModel
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.RecipeBriefDetailsUiModel

val fakeMealDetails = MealDetailsUiModel(
    id = 1,
    mealName = "breakfast",
    totalCalories = 186f,
    recipe = RecipeBriefDetailsUiModel(
        dishName = "Boiled Rice Boiled Rice Boiled Rice",
        amount = 25,
        readyInMinutes = 15,
        calories = 136f,
        imageUrl = "https://img.spoonacular.com/recipes/646982-556x370.jpg"
    )
)