package com.example.healthyfitness.presentation.screens.meals_monitor_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.components.CaloriesProgressIndicator
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.components.MealDetailsItem
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.MealDetailsUiModel

@Composable
fun MealMonitorScreenContent(
    meal: List<MealDetailsUiModel>,
    onRecipeClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.background
) {
    var expandedMealIndex by remember { mutableStateOf<Int?>(null) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = background),
        verticalArrangement = Arrangement.spacedBy(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 36.dp)
    ) {
        item {
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
        }
        itemsIndexed(meal) { index, meal ->
            MealDetailsItem(
                meal = meal,
                isExpanded = expandedMealIndex == index,
                onExpandClicked = {
                    expandedMealIndex = if (expandedMealIndex == index) null else index
                },
                onRecipeClicked = { onRecipeClicked(meal.id) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
        }
    }
}
