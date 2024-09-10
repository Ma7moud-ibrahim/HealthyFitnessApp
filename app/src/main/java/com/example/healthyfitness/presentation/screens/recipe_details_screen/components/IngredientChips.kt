package com.example.healthyfitness.presentation.screens.recipe_details_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.IngredientUiModel
import com.example.healthyfitness.presentation.screens.recipe_details_screen.preview_data.fakeIngredients
import com.example.healthyfitness.presentation.screens.utils.ALPHA
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun IngredientChips(
    ingredient: IngredientUiModel,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    background: Color = MaterialTheme.colorScheme.onSecondary,
    titleTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    quantityTextStyle: TextStyle = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal),
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(shape)
                .background(background)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = ingredient.imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            crossfade(1000)
                            placeholder(R.drawable.drink_fruit)
                        })
                        .build()
                ),
                contentDescription = ingredient.name,
                modifier = Modifier.padding(18.dp)
            )
        }
        Text(
            text = ingredient.name,
            modifier = Modifier.width(IntrinsicSize.Min),
            color = textColor,
            style = titleTextStyle
        )
        Text(
            text = ingredient.amount + " " + ingredient.unit,
            color = textColor.copy(alpha = ALPHA),
            style = quantityTextStyle
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1C2126)
@Composable
private fun IngredientChipsPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        IngredientChips(fakeIngredients[0])
    }

}