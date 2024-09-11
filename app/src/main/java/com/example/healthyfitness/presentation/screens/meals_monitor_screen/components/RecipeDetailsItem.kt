package com.example.healthyfitness.presentation.screens.meals_monitor_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.RecipeBriefDetailsUiModel
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.preview_data.fakeMealDetails
import com.example.healthyfitness.presentation.screens.utils.ALPHA
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun RecipeDetailsItem(
    recipe: RecipeBriefDetailsUiModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    dishTextStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    amountTextStyle: TextStyle = MaterialTheme.typography.labelSmall
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
                .clickable(onClick = onClick)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = recipe.imageUrl)
                        .build()
                ),
                contentDescription = "Dish Image",
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .size(LocalConfiguration.current.screenWidthDp.dp / 4),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = recipe.dishName,
                    modifier = Modifier.width(IntrinsicSize.Max),
                    style = dishTextStyle,
                    color = textColor,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${recipe.amount} servings | ${recipe.readyInMinutes} min",
                    modifier = Modifier.alpha(ALPHA),
                    style = amountTextStyle,
                    color = textColor
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RecipeDetailsPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        RecipeDetailsItem(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color(0xFF2A3036)),
            onClick = {},
            recipe = fakeMealDetails.recipe
        )
    }

}