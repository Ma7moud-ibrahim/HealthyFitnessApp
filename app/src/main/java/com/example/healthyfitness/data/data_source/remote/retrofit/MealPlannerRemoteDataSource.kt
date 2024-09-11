package com.example.healthyfitness.data.data_source.remote.retrofit

import com.example.healthyfitness.data.data_source.remote.retrofit.api.MealPlannerApi
import com.example.healthyfitness.data.data_source.remote.retrofit.model.meal.GeneratedMealPlanDataModel
import com.example.healthyfitness.data.data_source.remote.retrofit.model.recipe.RecipeDetailsDataModel
import javax.inject.Inject

class MealPlannerRemoteDataSource @Inject constructor(
    private val mealPlannerApi: MealPlannerApi
) {
    suspend fun generateMealPlan(): GeneratedMealPlanDataModel {
        return mealPlannerApi.generateMealPlan().body() as GeneratedMealPlanDataModel
    }

    suspend fun getRecipeDetails(id: Int): RecipeDetailsDataModel {
        return mealPlannerApi.getRecipeDetails(id = id).body() as RecipeDetailsDataModel
    }
}