package com.example.healthyfitness.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthyfitness.presentation.screens.LoginScreen
import com.example.healthyfitness.presentation.screens.SignUpScreen
import com.example.healthyfitness.presentation.screens.viewmodels.LoginViewModel
import com.example.healthyfitness.presentation.screens.viewmodels.SignUpViewModel


@Composable
fun AppNavHost(
    navController: NavHostController,
    signUpViewModel: SignUpViewModel,
    loginViewModel: LoginViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "signup"
    ) {
        // SignUpScreen Route
        composable("signup") {
            SignUpScreen(
                viewModel = signUpViewModel,
                onSignUpSuccess = {
                    // You can navigate to other screens on successful sign-up
                },
                onNavigateToLogin = {
                    navController.navigate("login")
                }
            )
        }

        // LoginScreen Route
        composable("login") {
            LoginScreen(
                viewModel = loginViewModel,
                onLoginSuccess = {
                    // Handle login success (you can navigate to another screen here)
                },
                onNavigateToSignUp = {
                    navController.navigate("signup") {
                        popUpTo("signup") { inclusive = true } // optional: clears backstack
                    }
                }
            )
        }
    }
}