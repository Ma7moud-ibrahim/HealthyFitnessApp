package com.example.healthyfitness.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthyfitness.R
import com.example.healthyfitness.data.data_source.repository.UserRepository
import com.example.healthyfitness.presentation.common_components.shimmer.CustomButton
import com.example.healthyfitness.presentation.common_components.shimmer.CustomInput
import com.example.healthyfitness.presentation.common_components.shimmer.Icon
import com.example.healthyfitness.presentation.screens.SignUpScreen
import com.example.healthyfitness.presentation.screens.SignUpViewModel
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

                    SignUpScreen(viewModel = SignUpViewModel(UserRepository()),modifier = Modifier.padding(innerPadding))
//                    AppNavHost()
                }
                
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HealthyFitnessTheme {
        SignUpScreen(viewModel = SignUpViewModel(UserRepository()))
    }
}