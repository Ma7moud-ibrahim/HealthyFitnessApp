package com.example.healthyfitness.presentation.screens.recipe_details_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.healthyfitness.presentation.screens.recipe_details_screen.view_model.RecipeDetailsViewModel
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme


@Composable
fun RecipeDetailsScreen(
    id: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val recipeDetailsViewModel: RecipeDetailsViewModel = hiltViewModel()
    val recipe by recipeDetailsViewModel.recipe.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        recipeDetailsViewModel.getRecipeDetails(id)
    }

    RecipeDetailsScreenContent(recipe = recipe, modifier = modifier, onBackClick = onBackClick)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RecipeDetailsScreenPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        RecipeDetailsScreen(id = 10, {})
    }

}