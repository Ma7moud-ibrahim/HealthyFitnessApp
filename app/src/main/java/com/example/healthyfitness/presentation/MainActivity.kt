package com.example.healthyfitness.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.healthyfitness.data.data_source.remote.retrofit.RetrofitInstance
import com.example.healthyfitness.data.data_source.repository.LoginRepository
import com.example.healthyfitness.data.data_source.repository.SignUpRepository
import com.example.healthyfitness.presentation.navigation.AppNavHost
import com.example.healthyfitness.presentation.screens.LoginScreen
import com.example.healthyfitness.presentation.screens.viewmodels.LoginViewModel
import com.example.healthyfitness.presentation.screens.viewmodels.SignUpViewModel
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.utils.LogInViewModelFactory
import com.example.healthyfitness.presentation.utils.SignUpViewModelFactory


class MainActivity : ComponentActivity() {
    private val apiService = RetrofitInstance.create()
    private val repository = SignUpRepository(apiService)
    private val logrepository = LoginRepository(apiService)

    private val signViewModel: SignUpViewModel by viewModels {
        SignUpViewModelFactory(repository)
    }
    private val logViewModel: LoginViewModel by viewModels {
        LogInViewModelFactory(logrepository)
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HealthyFitnessTheme(dynamicColor = false) {
                val navController = rememberNavController()
                AppNavHost(
                    navController = rememberNavController(),
                    signUpViewModel = signViewModel,
                    loginViewModel = logViewModel
                )
                }

            //                val navController = rememberNavController()
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    AppNavHost(
//                        navController = navController,
//                        signUpViewModel = signViewModel,
//                        loginViewModel = logViewModel
//                    )

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