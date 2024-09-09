package com.example.healthyfitness.presentation.screens.food_monitor_screen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.food_monitor_screen.fakeMealDetails
import com.example.healthyfitness.presentation.screens.food_monitor_screen.model.MealDetailsUiModel
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.theme.arvoFontFamily

@Composable
fun MealDetailsItem(
    meal: MealDetailsUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    background: Color = MaterialTheme.colorScheme.secondary,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    shape: Shape = MaterialTheme.shapes.medium,
    mealTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        fontSize = 30.sp,
        fontWeight = FontWeight.Light
    ),
    caloriesTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Light),
    amountTextStyle: TextStyle = MaterialTheme.typography.titleLarge.copy(fontFamily = arvoFontFamily),
    tintColor: Color = MaterialTheme.colorScheme.primary
) {
    val angle by animateFloatAsState(
        targetValue = if (isExpanded) 90f else 0f, label = "expand arrow"
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(shape = shape)
            .background(color = background)
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = meal.mealName.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase() else it.toString()
                    },
                    modifier = Modifier.alignByBaseline(),
                    color = textColor,
                    style = mealTextStyle
                )
                Text(
                    text = ": ",
                    modifier = Modifier.alignByBaseline(),
                    color = textColor,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(300),
                    )
                )
                Text(
                    text = "${meal.totalCalories.toInt()} ",
                    modifier = Modifier.alignByBaseline(),
                    color = tintColor,
                    style = amountTextStyle
                )
                Text(
                    text = "cal",
                    modifier = Modifier.alignByBaseline(),
                    color = textColor,
                    style = caloriesTextStyle
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_green_right_icon),
                contentDescription = "Expand Arrow",
                modifier = Modifier.rotate(angle),
                tint = tintColor
            )
        }
        if (isExpanded) {
            meal.dishes.forEach {
                DishDetailsItem(modifier = Modifier.padding(top = 16.dp), dish = it)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MealDetailsPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MealDetailsItem(
                meal = fakeMealDetails,
                onClick = {},
                isExpanded = false,
                modifier = Modifier
                    .fillMaxWidth(.95f)
                    .padding(vertical = 16.dp)
            )
        }
    }

}