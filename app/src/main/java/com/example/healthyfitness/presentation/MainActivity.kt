package com.example.healthyfitness.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.healthyfitness.presentation.screens.meals_monitor_screen.MealsMonitorScreen
import com.example.healthyfitness.presentation.screens.recipe_details_screen.RecipeDetailsScreen
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthyFitnessTheme(dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MealsMonitorScreen(onRecipeClicked = {})
                    AppNavHost(innerPadding)
                }

            }
        }
    }
}

sealed class Screen(val route: String) {
    data object MealMonitorScreen : Screen("detail") {
        data object RecipeDetailsScreen : Screen("subDetail/{id}")
    }
}

@Composable
fun AppNavHost(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MealMonitorScreen.route) {
        composable(Screen.MealMonitorScreen.route) {
            MealsMonitorScreen(
                modifier = Modifier.padding(innerPadding),
                onRecipeClicked = {
                    navController.navigate(
                        Screen.MealMonitorScreen.RecipeDetailsScreen.route.replace(
                            "{id}",
                            "$it"
                        )
                    )
                }
            )
        }
        composable(
            Screen.MealMonitorScreen.RecipeDetailsScreen.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            RecipeDetailsScreen(
                it.arguments?.getInt("id") ?: 0,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}