package com.example.healthyfitness.presentation.screens.recipe_details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screens.recipe_details_screen.components.IngredientsSection
import com.example.healthyfitness.presentation.screens.recipe_details_screen.components.NutritionChips
import com.example.healthyfitness.presentation.screens.recipe_details_screen.components.RecipeDetailsTopAppBar
import com.example.healthyfitness.presentation.screens.recipe_details_screen.components.StepsSection
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.RecipeDetailsUiModel
import com.example.healthyfitness.presentation.screens.recipe_details_screen.preview_data.fakeRecipeDetails
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreenContent(
    recipe: RecipeDetailsUiModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    lemonGreenColor: Color = MaterialTheme.colorScheme.primary,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    RecipeDetailsTopAppBar(
        recipeName = recipe.name,
        imageUrl = recipe.imageUrl,
        scrollBehavior = scrollBehavior,
        onBackClick = onBackClick,
        backgroundColor = backgroundColor,
        lemonGreenColor = lemonGreenColor
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .background(backgroundColor)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = paddingValues
        ) {
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    items(recipe.nutrition.size) {
                        NutritionChips(
                            modifier = Modifier.padding(4.dp),
                            nutritionText = recipe.nutrition[recipe.nutrition.keys.elementAt(
                                it
                            )] + recipe.nutrition.keys.elementAt(it)
                        )
                    }
                }
            }

            item { IngredientsSection(recipe.ingredients) }

            item {
                StepsSection(recipe.instructions, modifier = Modifier.fillParentMaxHeight())
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecipeDetailsScreenContentPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        RecipeDetailsScreenContent(
            recipe = fakeRecipeDetails,
            onBackClick = {},
        )
    }
}