package com.example.healthyfitness.data.mapper

import com.example.healthyfitness.data.data_source.remote.retrofit.model.meal.GeneratedMealPlanDataModel
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.MealDetailsUiModel
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.RecipeBriefDetailsUiModel

fun GeneratedMealPlanDataModel.toMealDetailsUiModelList(eachMealCalories: List<Float>): List<MealDetailsUiModel> {
    return meals.mapIndexed { index, meal ->
        MealDetailsUiModel(
            id = meal.id,
            mealName = when (index) {
                0 -> "Breakfast"
                1 -> "Lunch"
                else -> "Dinner"
            },
            totalCalories = eachMealCalories[index],
            recipe = RecipeBriefDetailsUiModel(
                dishName = meal.title,
                readyInMinutes = meal.readyInMinutes,
                imageUrl = "https://img.spoonacular.com/recipes/${meal.id}-636x393.${meal.imageType}",
                calories = eachMealCalories[index],
                amount = meal.servings
            )
        )
    }
}