package com.example.healthyfitness.presentation.screens.meals_monitor_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.preview_data.fakeMealDetails
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.view_model.MealMonitorViewModel
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun MealsMonitorScreen(
    onRecipeClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val mealPlannerViewModel: MealMonitorViewModel = hiltViewModel()
    val meal by mealPlannerViewModel.mealPlan.collectAsStateWithLifecycle()

    MealMonitorScreenContent(
        meal = meal,
        onRecipeClicked = onRecipeClicked,
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MealMonitorScreenPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        MealMonitorScreenContent(
            meal = listOf(
                fakeMealDetails,
                fakeMealDetails.copy(mealName = "Lunch", totalCalories = 338f),
                fakeMealDetails.copy(mealName = "Dinner", totalCalories = 200f)
            ),
            onRecipeClicked = {},
            modifier = Modifier.padding(bottom = 36.dp)
        )
    }
}