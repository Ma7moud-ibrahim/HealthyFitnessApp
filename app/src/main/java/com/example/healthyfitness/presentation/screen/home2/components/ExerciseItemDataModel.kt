package com.example.healthyfitness.presentation.screen.home2.components

data class ExerciseItemDataModel(
    val imageId: Int,
    val bodyTextId: Int,
    val hours: Int,
    val minutes: Int,
    val onItemClicked: () -> Unit
)


