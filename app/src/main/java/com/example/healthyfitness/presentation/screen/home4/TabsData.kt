package com.example.healthyfitness.presentation.screen.home4

import com.example.healthyfitness.R

data class TabsData(val title: String)

val items = listOf(
    TabsData(title = "Created"),
    TabsData(title = "PRs"),
    TabsData(title = "Saved")
)

val contentOfTabs = listOf (
    R.drawable.myworkout_football,
    R.drawable.push_ups,
    R.drawable.drink_fruit
)
