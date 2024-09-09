package com.example.healthyfitness.presentation.screens.home_page1_screen

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.home_page1_screen.components.ActivityItem
import com.example.healthyfitness.presentation.screens.home_page1_screen.components.CalendarPager
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun HomePage1Screen(
    viewModel: HomePage1ViewModel,
    @DrawableRes userImgId: Int = R.drawable.ic_profile_icon
) {
    val activities by viewModel.activities.collectAsState()

    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 60.dp)
            .fillMaxSize()
    ) {
        item {
            CalendarPager(updateSelectedDay = {}, userImgId = userImgId)
            Spacer(modifier = Modifier.height(40.dp))
        }
        items(activities) { activity ->
            ActivityItem(activity = activity)
        }
    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenPreview() {
    HealthyFitnessTheme(darkTheme = true) {
        val homeViewModel: HomePage1ViewModel = viewModel()
        HomePage1Screen(homeViewModel)  // Display only the list of activities
    }
}