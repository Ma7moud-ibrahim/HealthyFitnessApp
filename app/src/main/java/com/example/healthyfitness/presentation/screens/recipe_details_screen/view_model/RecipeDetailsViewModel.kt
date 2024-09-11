package com.example.healthyfitness.presentation.screens.recipe_details_screen.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfitness.data.repository.GeneratedMealRepository
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.RecipeDetailsUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val generatedMealRepository: GeneratedMealRepository
) : ViewModel() {

    private val _recipe: MutableStateFlow<RecipeDetailsUiModel> =
        MutableStateFlow(
            RecipeDetailsUiModel(
                imageUrl = "",
                name = "",
                ingredients = listOf(),
                nutrition = mapOf(),
                instructions = listOf()
            )
        )
    val recipe = _recipe.asStateFlow()

    fun getRecipeDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _recipe.value = generatedMealRepository.getRecipeDetails(id)
        }
    }
}