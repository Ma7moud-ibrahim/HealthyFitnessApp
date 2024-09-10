package com.example.healthyfitness.presentation.screens.recipe_details_screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.recipe_details_screen.components.IngredientChips
import com.example.healthyfitness.presentation.screens.recipe_details_screen.components.InstructionStep
import com.example.healthyfitness.presentation.screens.recipe_details_screen.components.NutritionChips
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.RecipeDetailsUiModel
import com.example.healthyfitness.presentation.screens.recipe_details_screen.preview_data.fakeRecipeDetails
import com.example.healthyfitness.presentation.screens.utils.ALPHA
import com.example.healthyfitness.presentation.screens.utils.WIDTH
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme


@Composable
fun RecipeDetailsScreen(
    recipe: RecipeDetailsUiModel,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    whiteTextColor: Color = MaterialTheme.colorScheme.tertiary,
    lemonGreenTextColor: Color = MaterialTheme.colorScheme.primary,
) {
    val scrollState = rememberScrollState()
    val imageHeight = (LocalConfiguration.current.screenWidthDp / 2).dp
    val targetImageHeight = animateDpAsState(
        targetValue = if (scrollState.value > 0) 0.dp else imageHeight,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessHigh
        ), label = ""
    )
    val imageVisibility = animateFloatAsState(
        targetValue = if (scrollState.value > 0) 0f else 1f, label = ""
    )
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = recipe.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(1000)
                        placeholder(R.drawable.notifications_man)
                    })
                    .build()
            ),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(targetImageHeight.value)
                .alpha(alpha = imageVisibility.value),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = recipe.name,
                modifier = Modifier.fillMaxWidth(WIDTH),
                color = lemonGreenTextColor,
                style = MaterialTheme.typography.titleLarge
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items(recipe.nutrition.size) {
                    NutritionChips(
                        nutritionText = recipe.nutrition[recipe.nutrition.keys.elementAt(
                            it
                        )] + recipe.nutrition.keys.elementAt(it)
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(WIDTH),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Descriptions",
                    color = lemonGreenTextColor
                )
                Text(
                    text = recipe.description,
                    maxLines = if (expanded) Int.MAX_VALUE else 4,
                    overflow = TextOverflow.Ellipsis,
                    color = whiteTextColor.copy(alpha = ALPHA),
                    style = MaterialTheme.typography.bodyMedium
                )
                if (!expanded) {
                    Text(
                        text = "Read more",
                        modifier = Modifier.clickable { expanded = true },
                        color = whiteTextColor,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(WIDTH),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Ingredients",
                        color = lemonGreenTextColor
                    )
                    Text(
                        text = "${recipe.ingredients.size} items",
                        color = whiteTextColor.copy(alpha = ALPHA),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                LazyRow(
                    contentPadding = PaddingValues(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(recipe.ingredients.size) {
                        IngredientChips(ingredient = recipe.ingredients[it])
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(WIDTH),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Step by Step",
                        modifier = Modifier.width(IntrinsicSize.Max),
                        color = lemonGreenTextColor
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(WIDTH),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        recipe.instructions.forEachIndexed { index, item ->
                            InstructionStep(
                                stepNumber = index + 1,
                                stepInstruction = item,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RecipeDetailsScreenPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        RecipeDetailsScreen(recipe = fakeRecipeDetails)
    }

}