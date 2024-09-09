package com.example.healthyfitness.presentation.screens.food_monitor_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.food_monitor_screen.fakeMealDetails
import com.example.healthyfitness.presentation.screens.food_monitor_screen.model.DishDetailsUiModel
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun DishDetailsItem(
    dish: DishDetailsUiModel,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    dishTextStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    amountTextStyle: TextStyle = MaterialTheme.typography.labelSmall,
    caloriesTextStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    tintColor: Color = MaterialTheme.colorScheme.primary
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(.95f),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outline
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(.85f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.rice),
                contentDescription = "Dish Image",
                modifier = Modifier.size(36.dp),
                colorFilter = ColorFilter.tint(tintColor)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = dish.dishName,
                    style = dishTextStyle,
                    color = textColor
                )
                Text(
                    text = dish.amount,
                    style = amountTextStyle,
                    color = textColor
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${dish.calories.toInt()}",
                style = caloriesTextStyle,
                color = tintColor
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DishDetailsPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        DishDetailsItem(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color(0xFF2A3036)),
            dish = fakeMealDetails.dishes[0]
        )
    }

}