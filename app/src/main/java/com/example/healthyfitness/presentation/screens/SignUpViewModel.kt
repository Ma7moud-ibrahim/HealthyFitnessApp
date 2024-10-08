package com.example.healthyfitness.presentation.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.healthyfitness.data.data_source.repository.UserRepository

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel() {
    var fullName = mutableStateOf("")
    var email = mutableStateOf("")
    var emailError by mutableStateOf<String?>(null)

    var password = mutableStateOf("")
    var passwordError by mutableStateOf<String?>(null)

    var confirmPassword = mutableStateOf("")
    var confirmPasswordError by mutableStateOf<String?>(null)

    fun validateEmail() {
        emailError = when {
            email.value.isEmpty() -> "Email cannot be empty"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email.value).matches() -> "Invalid email address"
            else -> null  // Clear the error if valid
        }
    }

    fun validatePassword() {
        passwordError = when {
            password.value.isEmpty() -> "Password cannot be empty"
            password.value.length < 6 -> "Use at least 6 characters"
            else -> null  // Clear the error if valid
        }
    }

    fun validateConfirmPassword() {
        confirmPasswordError = when {
            confirmPassword.value.isEmpty() -> "Confirm your password"
            confirmPassword.value != password.value -> "Passwords do not match"
            else -> null  // Clear the error if valid
        }
    }

    fun validateFields(): Boolean {
        validateEmail()
        validatePassword()
        validateConfirmPassword()

        return emailError == null && passwordError == null && confirmPasswordError == null
    }

    fun onSignUp() {
        if (validateFields()) {
            // Proceed with the sign-up process
        }
    }
}




//    suspend fun onSignUp(): Boolean {
//        ValidationUtil.isValidEmail(email.toString())
//        ValidationUtil.isPasswordStrong(password.toString())
//        // Add basic validation logic here
//        if (password != confirmPassword) {
//            return false
//        }
//        val user = User(fullName.toString(), email.toString(), password.toString())
//        return userRepository.createUser(user)
//    }
