package com.example.healthyfitness.presentation.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthyfitness.R
import com.example.healthyfitness.data.data_source.repository.UserRepository
import com.example.healthyfitness.presentation.common_components.PasswordFieldComponent
import com.example.healthyfitness.presentation.common_components.TextFieldComponent
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.theme.arvoFontFamily
import com.example.healthyfitness.presentation.theme.robotoFontFamily
import com.example.healthyfitness.presentation.utils.ValidationUtil.isValidEmail


@SuppressLint("RememberReturnType")
@Composable
fun SignUpScreen(modifier: Modifier = Modifier,
                 viewModel: SignUpViewModel = viewModel()) {
    val name = rememberSaveable { viewModel.fullName }
    val email = rememberSaveable { viewModel.email }
    val password = rememberSaveable { viewModel.password }
    val confirmPassword = rememberSaveable { viewModel.confirmPassword }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo), contentDescription = "Logo",
                modifier = Modifier
                    .height(115.dp)
                    .width(90.dp)
                    .padding(0.dp, 40.dp, 0.dp, 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Shape Your Muscles",
                fontSize = 40.sp,
                fontWeight = FontWeight.W700,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = arvoFontFamily,
                    color = MaterialTheme.colorScheme.primary,
                    lineHeight = 51.sp, shadow = Shadow(
                        color = MaterialTheme.colorScheme.primary,
                        offset = Offset(1f, 2f),
                        blurRadius = 26f
                    )
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .background(color = Color(0xFF2A3036))
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            text = "Sign up to create account",
                            style = TextStyle(
                                fontFamily = arvoFontFamily,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.W400,
                                textAlign = TextAlign.Center
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        TextFieldComponent(
                            icon = R.drawable.ic_profile_icon,
                            label = "Full Name",
                            value = name.value,
                            onValueChange = { name.value = it }
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        TextFieldComponent(
                            icon = R.drawable.ic_email_icon,
                            label = "Enter Email Address",
                            value = email.value,
                            onValueChange = {
                                email.value = it
                                viewModel.validateEmail()  // Validate email on change
                            }
                        )
                        viewModel.emailError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                style = TextStyle(fontSize = 12.sp),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        PasswordFieldComponent(
                            icon = R.drawable.ic_lock_icon,
                            label = "Password",
                            password = password.value,
                            onPasswordChange = {
                                password.value = it
                                viewModel.validatePassword()  // Validate password on change
                            }
                        )
                        viewModel.passwordError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                style = TextStyle(fontSize = 12.sp),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        PasswordFieldComponent(
                            icon = R.drawable.ic_lock_icon,
                            label = "Confirm Password",
                            password = confirmPassword.value,
                            onPasswordChange = {
                                confirmPassword.value = it
                                viewModel.validateConfirmPassword()  // Validate confirm password on change
                            }
                        )
                        viewModel.confirmPasswordError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                style = TextStyle(fontSize = 12.sp),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { viewModel.onSignUp() },
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier
                                .shadow(
                                    elevation = 16.dp,
                                    shape = RoundedCornerShape(12.dp),
                                    clip = true,
                                    spotColor = MaterialTheme.colorScheme.primary
                                )
                        ) {
                            Text(
                                text = "Sign Up",
                                style = TextStyle(
                                    fontFamily = arvoFontFamily,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W700,
                                    color = Color(0xFF1C2126)
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        TextButton(onClick = { /* Navigate to Sign In Screen */ }) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Already have an account? ",
                                    style = TextStyle(
                                        fontFamily = robotoFontFamily,
                                        fontSize = 16.sp,
                                        color = Color.White
                                    )
                                )
                                Text(
                                    text = "SIGN IN",
                                    style = TextStyle(
                                        fontFamily = robotoFontFamily,
                                        fontSize = 18.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun PreviewSignUpScreen() {
    HealthyFitnessTheme(darkTheme = true) {
        SignUpScreen(viewModel = SignUpViewModel(UserRepository()))
    }
}
