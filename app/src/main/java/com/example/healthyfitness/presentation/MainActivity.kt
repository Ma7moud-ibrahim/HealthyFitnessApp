package com.example.healthyfitness.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomInput
import com.example.healthyfitness.presentation.screen.MyWorkoutsScreen
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthyFitnessTheme(dynamicColor = false) {
                MyWorkoutsScreen() {}

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
/*
    CustomButton(buttonText = "Sign Up", icon = { Icon("Sign Up") }, width = 300.0) {

    }
*/
    CustomInput("Enter your name", R.drawable.ic_lock_icon)

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HealthyFitnessTheme {
        Greeting("Android")
    }
}