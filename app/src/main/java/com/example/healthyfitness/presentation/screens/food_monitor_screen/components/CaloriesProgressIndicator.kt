package com.example.healthyfitness.presentation.screens.food_monitor_screen.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun CaloriesProgressIndicator(
    meal: String,
    progress: Float,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    containerColor: Color = MaterialTheme.colorScheme.secondary,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    strokeWidth: Float = 20f,
    trackColor: Color = MaterialTheme.colorScheme.tertiary,
    progressColor: Color = MaterialTheme.colorScheme.primary
) {
    var startAnimation by remember { mutableStateOf(false) }
    val animatedProgress = animateFloatAsState(
        targetValue = if (startAnimation) progress / 1000 else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessVeryLow
        ), label = "progress animation"
    )
    LaunchedEffect(Unit) {
        startAnimation = true
    }
    Card(
        modifier = modifier
            .aspectRatio(0.8f)
            .clickable(onClick = onClick),
        shape = shape,
        colors = CardDefaults.cardColors().copy(containerColor)
    ) {
        Text(
            text = meal.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.tertiary,
            style = textStyle
        )
        Box(
            Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            ProgressCircle(
                progress = animatedProgress,
                strokeWidth = strokeWidth,
                trackColor = trackColor,
                progressColor = progressColor,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${progress.toInt()} cal",
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center,
                style = textStyle
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProgressPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CaloriesProgressIndicator(
                meal = "Breakfast",
                progress = 186f,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            CaloriesProgressIndicator(
                meal = "Lunch",
                progress = 338f,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            CaloriesProgressIndicator(
                meal = "Dinner",
                progress = 200f,
                onClick = {},
                modifier = Modifier.weight(1f)
            )

        }
    }
}