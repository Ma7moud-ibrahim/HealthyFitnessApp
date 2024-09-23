package com.example.healthyfitness.presentation.navigation

// Screens for the app
enum class Screens {
    WelcomeScreen,
    Login,
    SignUp,
    ForgetPassword1,
    ForgetPassword2,
    ForgetPassword3,
    Home,
    Home1,
    Home2,
    Home3,
    Home4,
}

sealed class NavigationItem(val route :String){
    data object WelcomeScreen : NavigationItem(Screens.WelcomeScreen.name)
    data object SignUp : NavigationItem(Screens.SignUp.name)
    data object Login : NavigationItem(Screens.Login.name)
    data object ForgetPassword1 : NavigationItem(Screens.ForgetPassword1.name)
    data object ForgetPassword2 : NavigationItem(Screens.ForgetPassword2.name)
    data object ForgetPassword3 : NavigationItem(Screens.ForgetPassword3.name)
    data object Home : NavigationItem(Screens.Home.name)
    data object Home1 : NavigationItem(Screens.Home1.name)
    data object Home2: NavigationItem(Screens.Home2.name)
    data object Home3: NavigationItem(Screens.Home3.name)
    data object Home4 : NavigationItem(Screens.Home4.name)

}