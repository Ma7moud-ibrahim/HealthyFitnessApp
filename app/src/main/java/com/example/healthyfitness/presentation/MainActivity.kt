package com.example.healthyfitness.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomButton
import com.example.healthyfitness.presentation.common_components.shimmer.CustomInput
import com.example.healthyfitness.presentation.screens.ExerciseUi
import com.example.healthyfitness.presentation.screens.home_page1_screen.HomePage1Screen
//import com.example.healthyfitness.presentation.common_components.shimmer.Icon
//import com.example.healthyfitness.presentation.screens.home_page1_screen.HomePage1Screen
//import com.example.healthyfitness.presentation.screens.home_page1_screen.components.ActivityItem
//import com.example.healthyfitness.presentation.screens.home_page1_screen.model.ActivityType
//import com.example.healthyfitness.presentation.screens.home_page1_screen.model.FitnessActivity
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthyFitnessTheme(dynamicColor = false) {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
////                    AppNavHost()
//                }
                HomePage1Screen()

            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HealthyFitnessTheme {
//        Greeting("Android")
//    }
