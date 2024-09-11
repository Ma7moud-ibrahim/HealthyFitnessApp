package com.example.healthyfitness.presentation.screens.meals_monitor_screen.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfitness.data.repository.GeneratedMealRepository
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.model.MealDetailsUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealMonitorViewModel @Inject constructor(
    private val generatedMealRepository: GeneratedMealRepository
) : ViewModel() {
    init {
        generateMealPlan()
    }

    private val _mealPlan: MutableStateFlow<List<MealDetailsUiModel>> =
        MutableStateFlow(emptyList())
    val mealPlan: StateFlow<List<MealDetailsUiModel>> = _mealPlan.asStateFlow()

    private fun generateMealPlan() {
        viewModelScope.launch(Dispatchers.IO) {
            _mealPlan.value = generatedMealRepository.generateMealPlan()
        }
    }
}