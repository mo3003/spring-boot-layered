
package com.example.Layered.Architectures.Models

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank


data class User(
    var id: Int? = null,

    @field:NotBlank(message = "Name is required")
    var name: String,

    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Email must contain @ and be valid")
    var email: String,
) {
    fun add(newUser: User) {
        id = newUser.id
    }
}
