package com.example.healthyfitness.presentation.screens.home_page1_screen

import androidx.lifecycle.ViewModel
import com.example.healthyfitness.presentation.screens.home_page1_screen.model.ActivityType
import com.example.healthyfitness.presentation.screens.home_page1_screen.model.FitnessActivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomePage1ViewModel : ViewModel() {

//Date

    private val _activities = MutableStateFlow(
        listOf(
            FitnessActivity(ActivityType.Walking, "3985","Steps" ,"Today 06:00 AM"),
            FitnessActivity(ActivityType.Cycling, "17","Km" ,"Today 09:00 AM"),
            FitnessActivity(ActivityType.Workout, "45","Minutes", "Today 08:00 PM"),
            FitnessActivity(ActivityType.Swimming, "35","Minutes", "Today 11:00 AM")
        )
    )
    val activities: StateFlow<List<FitnessActivity>> = _activities.asStateFlow()

//    fun updateSelectedDate(date: LocalDate)

}