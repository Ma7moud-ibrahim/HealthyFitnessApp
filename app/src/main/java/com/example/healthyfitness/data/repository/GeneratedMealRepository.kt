package com.example.healthyfitness.data.repository

import com.example.healthyfitness.data.data_source.remote.retrofit.MealPlannerRemoteDataSource
import com.example.healthyfitness.data.mapper.toMealDetailsUiModelList
import com.example.healthyfitness.data.mapper.toRecipeDetailsUiModel
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.MealDetailsUiModel
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.RecipeDetailsUiModel
import javax.inject.Inject


class GeneratedMealRepository @Inject constructor(
    private val mealPlannerRemoteDataSource: MealPlannerRemoteDataSource
) {
    suspend fun generateMealPlan(): List<MealDetailsUiModel> {
        return mealPlannerRemoteDataSource.generateMealPlan().toMealDetailsUiModelList()
    }

    suspend fun getRecipeDetails(id: Int): RecipeDetailsUiModel {
        return mealPlannerRemoteDataSource.getRecipeDetails(id).toRecipeDetailsUiModel()
    }

}