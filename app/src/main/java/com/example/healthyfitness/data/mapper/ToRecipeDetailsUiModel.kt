package com.example.healthyfitness.data.mapper

import com.example.healthyfitness.data.data_source.remote.retrofit.model.recipe.RecipeDetailsDataModel
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.IngredientUiModel
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.RecipeDetailsUiModel
import org.jsoup.Jsoup

fun RecipeDetailsDataModel.toRecipeDetailsUiModel(): RecipeDetailsUiModel {
    return RecipeDetailsUiModel(
        name = title,
        imageUrl = "https://img.spoonacular.com/recipes/${id}-636x393.${imageType}",
        instructions = analyzedInstructions.map {
            it.steps.map { it.step }.toString()
        },
        ingredients = extendedIngredients.map {
            IngredientUiModel(
                name = it.name,
                amount = it.measures.us.amount.toString(),
                unit = it.measures.us.unitShort,
                image = it.image
            )
        },
        description = Jsoup.parse(summary).toString(),
        nutrition = nutrition.nutrients.associate {
            it.name to it.amount.toInt().toString() + " " + it.unit
        }
    )
}