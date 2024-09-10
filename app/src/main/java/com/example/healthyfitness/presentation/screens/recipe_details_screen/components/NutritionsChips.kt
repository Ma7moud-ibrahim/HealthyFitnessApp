package com.example.healthyfitness.presentation.screens.recipe_details_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NutritionChips(
    nutritionText: String,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    backgroundColor: Color = MaterialTheme.colorScheme.secondary,
    nutritionTextColor: Color = MaterialTheme.colorScheme.onSecondary,
    nutritionTextStyle: TextStyle = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal)
) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
    ) {
        Text(
            text = nutritionText,
            Modifier.padding(12.dp),
            style = nutritionTextStyle,
            color = nutritionTextColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NutritionChipsPreview() {
    NutritionChips("20g proteins")
}