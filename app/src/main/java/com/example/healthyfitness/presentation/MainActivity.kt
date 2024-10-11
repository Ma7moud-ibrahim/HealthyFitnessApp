package com.example.healthyfitness.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.healthyfitness.data.data_source.remote.retrofit.RetrofitInstance
import com.example.healthyfitness.data.data_source.repository.UserRepository
import com.example.healthyfitness.presentation.screens.SignUpScreen
import com.example.healthyfitness.presentation.screens.SignUpViewModel
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.utils.SignUpViewModelFactory


class MainActivity : ComponentActivity() {
    private val apiService = RetrofitInstance.create()
    private val repository = UserRepository(apiService)

    // Use the factory to create the ViewModel
    private val viewModel: SignUpViewModel by viewModels {
        SignUpViewModelFactory(repository)
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HealthyFitnessTheme(dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    SignUpScreen(viewModel, onSignUpSuccess = {})
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HealthyFitnessTheme {
//        SignUpScreen(viewModel = SignUpViewModel(UserRepository()))
//    }
//}