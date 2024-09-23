package com.example.healthyfitness.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthyfitness.presentation.WelcomeScreen
import com.example.healthyfitness.presentation.forgetPassword1.ForgetPassword1
import com.example.healthyfitness.presentation.forgetPassword2.ForgetPassword2
import com.example.healthyfitness.presentation.forgetPassword3.ForgetPassword3
import com.example.healthyfitness.presentation.login.LoginScreen
import com.example.healthyfitness.presentation.signUp.SignUpScreen


// NavHost for the app, will be implemented after the screens are created
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.WelcomeScreen.route) {

        composable(route = NavigationItem.WelcomeScreen.route) {
            WelcomeScreen(signUp = { navController.navigate(NavigationItem.SignUp.route) },
                signIn = { navController.navigate(NavigationItem.Login.route) })
        }

        composable(route = NavigationItem.Login.route) {
            LoginScreen(
                signIn = {navController.navigate(NavigationItem.Home.route)},
                forgetPassword = { navController.navigate(NavigationItem.ForgetPassword1.route) }
            )

        }
        composable(route = NavigationItem.SignUp.route) {
            SignUpScreen(
                signUp = {},
                signIn = { navController.navigate(NavigationItem.Login.route) }
            )

        }
        composable(route = NavigationItem.ForgetPassword1.route) {
            ForgetPassword1(
                send ={navController.navigate(NavigationItem.ForgetPassword2.route)}
            )

        }
        composable(route = NavigationItem.ForgetPassword2.route) {
            ForgetPassword2 (
                verify ={navController.navigate(NavigationItem.ForgetPassword3.route)}

            )

        }
        composable(route = NavigationItem.ForgetPassword3.route) {
            ForgetPassword3(
                save = {}
            )

        }
        composable(route = NavigationItem.Home.route) {

        }
        composable(route = NavigationItem.Home1.route) {

        }
        composable(route = NavigationItem.Home2.route) {

        }
        composable(route = NavigationItem.Home3.route) {

        }
        composable(route = NavigationItem.Home4.route) {

        }

    }
}