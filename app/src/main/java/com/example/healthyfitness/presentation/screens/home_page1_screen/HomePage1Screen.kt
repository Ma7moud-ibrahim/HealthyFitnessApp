package com.example.healthyfitness.presentation.screens.home_page1_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthyfitness.presentation.screens.home_page1_screen.components.ActivityItem

@Composable
fun HomePage1Screen(viewModel: HomePage1ViewModel = viewModel()) {
    val activities by viewModel.activities.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background )
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(activities) { activity ->
                ActivityItem(activity = activity)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HomePage1Screen()  // Display only the list of activities
        Spacer(modifier = Modifier.height(8.dp))
    }
}