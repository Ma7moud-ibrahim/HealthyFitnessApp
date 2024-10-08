package com.example.healthyfitness.data.data_source.repository

import com.example.healthyfitness.data.data_source.User
import kotlinx.coroutines.delay

class UserRepository {
    suspend fun createUser(user: User): Boolean {
        // Simulate network delay
        delay(1000)
        return if ((0..10).random() > 2) {
            println("User created successfully")
            true
        } else {
            println("Failed to create user")
            false
        }
    }
}