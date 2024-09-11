package com.example.healthyfitness.data.data_source.remote.retrofit.api

import com.example.healthyfitness.data.data_source.remote.RemoteConstants.Companion.API_KEY
import com.example.healthyfitness.data.data_source.remote.retrofit.model.meal.GeneratedMealPlanDataModel
import com.example.healthyfitness.data.data_source.remote.retrofit.model.recipe.RecipeDetailsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealPlannerApi {
    @GET("mealplanner/generate")
    suspend fun generateMealPlan(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("timeFrame") timeFrame: String = "dat",
        @Query("targetCalories") targetCalories: Int = 2000,
        @Query("diet") diet: String = "veryHealthy"
    ): Response<GeneratedMealPlanDataModel>

    @GET("recipes/:id/")
    suspend fun getRecipeDetails(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("id") id: Int,
        @Query("includeNutrition") includeNutrition: Boolean = true
    ): Response<RecipeDetailsDataModel>

}