package com.example.healthyfitness.presentation.screens.recipe_details_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun RecipeImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = imageUrl)
                .apply(block = fun ImageRequest.Builder.() { crossfade(true) })
                .build()
        ),
        contentDescription = "",
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth
    )
}