package com.example.healthyfitness.presentation.screens.food_monitor_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screens.food_monitor_screen.components.CaloriesProgressIndicator
import com.example.healthyfitness.presentation.screens.food_monitor_screen.components.MealDetailsItem
import com.example.healthyfitness.presentation.screens.food_monitor_screen.model.MealDetailsUiModel
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun FoodMonitorScreen(
    meal: List<MealDetailsUiModel>,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.background
) {
    var expandedMealIndex by remember { mutableStateOf<Int?>(null) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = background)
            .padding(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            meal.forEachIndexed { index, meal ->
                CaloriesProgressIndicator(
                    meal = meal.mealName,
                    progress = meal.totalCalories,
                    onClick = {
                        expandedMealIndex = if (expandedMealIndex == index) null else index
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            meal.forEachIndexed { index, meal ->
                MealDetailsItem(
                    meal = meal,
                    isExpanded = expandedMealIndex == index,
                    onClick = {
                        expandedMealIndex = if (expandedMealIndex == index) null else index
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FoodMonitorScreenPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        FoodMonitorScreen(
            meal = listOf(
                fakeMealDetails,
                fakeMealDetails.copy(mealName = "Lunch", totalCalories = 338f),
                fakeMealDetails.copy(mealName = "Dinner", totalCalories = 200f)
            ),
            modifier = Modifier.padding(bottom = 36.dp)
        )
    }

}