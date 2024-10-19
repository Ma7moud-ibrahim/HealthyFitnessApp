package com.example.healthyfitness.presentation.screens.recipe_details_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.IngredientUiModel
import com.example.healthyfitness.presentation.screens.utils.ALPHA
import com.example.healthyfitness.presentation.screens.utils.WIDTH

@Composable
fun IngredientsSection(
    ingredients: List<IngredientUiModel>,
    modifier: Modifier = Modifier,
    lemonGreenTextColor: Color = MaterialTheme.colorScheme.primary,
    whiteTextColor: Color = MaterialTheme.colorScheme.tertiary,
) {
    Row(
        modifier = modifier.fillMaxWidth(WIDTH),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Ingredients",
            color = lemonGreenTextColor
        )
        Text(
            text = "${ingredients.size} items",
            color = whiteTextColor.copy(alpha = ALPHA),
            style = MaterialTheme.typography.bodyMedium
        )
    }
    LazyRow(
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(ingredients) {
            IngredientChips(ingredient = it)
        }
    }
}