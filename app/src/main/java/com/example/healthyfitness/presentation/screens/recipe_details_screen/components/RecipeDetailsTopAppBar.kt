package com.example.healthyfitness.presentation.screens.recipe_details_screen.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screens.recipe_details_screen.preview_data.fakeRecipeDetails
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsTopAppBar(
    recipeName: String,
    imageUrl: String,
    scrollBehavior: TopAppBarScrollBehavior,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    lemonGreenColor: Color = MaterialTheme.colorScheme.primary,
    content: @Composable (PaddingValues) -> Unit,
) {
    val topAppBarHeight = LocalConfiguration.current.screenWidthDp.dp / 2
    val imageHeight by remember { mutableStateOf(topAppBarHeight) }
    val animatedImageHeight by animateDpAsState(
        targetValue = imageHeight - (topAppBarHeight * scrollBehavior.state.collapsedFraction),
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )
    val animatedAlpha by animateFloatAsState(
        targetValue = 1f - scrollBehavior.state.collapsedFraction, label = ""
    )

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            RecipeImage(
                imageUrl,
                modifier = Modifier
                    .height(animatedImageHeight)
                    .alpha(animatedAlpha)
            )
            LargeTopAppBar(
                title = {
                    Text(
                        text = recipeName,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = backgroundColor,
                    navigationIconContentColor = lemonGreenColor,
                    titleContentColor = lemonGreenColor
                ),
                expandedHeight = topAppBarHeight
            )
        },
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RecipeDetailsTopAppBarPreview() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    HealthyFitnessTheme(dynamicColor = false) {
        RecipeDetailsTopAppBar(
            recipeName = fakeRecipeDetails.name,
            imageUrl = fakeRecipeDetails.imageUrl,
            scrollBehavior = scrollBehavior,
            onBackClick = {},
            content = {}
        )
    }
}