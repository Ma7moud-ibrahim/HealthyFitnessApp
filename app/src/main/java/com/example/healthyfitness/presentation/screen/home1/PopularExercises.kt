package com.example.healthyfitness.presentation.screen.home1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screen.home1.components.ItemCard
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun PopularExercises(
    onClickViewAll: () -> Unit
) {
    // you should add Spacer(modifier = Modifier.height(87.dp)) to seperate our designs
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(286.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(start = 25.dp, end = 15.dp)
        ) {
            Text(
                text = "Popular Exercises",
                modifier = Modifier.size(width = 257.dp, height = 33.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
            Button(
                onClick = { onClickViewAll() },
                modifier = Modifier
                    .width(120.dp)
                    .height(44.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    text = "View All",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.size(width = 42.dp, height = 13.dp),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 9.sp,
                        lineHeight = 12.sp
                    ),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 38.dp)
        ) {
            ItemCard(
                modifier = Modifier.weight(1f),
                imageId = R.drawable.dumbbell,
                bodyText = "Dumbel Rows",
                hours = 1,
                minutes = 20
            ){}//onItemClicked
            ItemCard(
                modifier = Modifier.weight(1f),
                imageId = R.drawable.bicycle_solid,
                bodyText = "Cycling",
                hours = 1,
                minutes = 20
            ){}//onItemClicked
            ItemCard(
                modifier = Modifier.weight(1f),
                imageId = R.drawable.footsteps_outline,
                bodyText = "Walking",
                hours = 1,
                minutes = 20
            ){}//onItemClicked

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewPopularExercises() {
    HealthyFitnessTheme {
        PopularExercises() {}
    }
}