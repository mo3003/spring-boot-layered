
package com.example.Layered.Architectures.DTOs.Request

data class CreateUserRequest(
    val id: Int? = null,
    val name: String,
    val email: String,
//    val password: String
)
