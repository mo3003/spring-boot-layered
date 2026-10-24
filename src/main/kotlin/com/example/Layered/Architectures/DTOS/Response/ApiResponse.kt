package com.example.Layered.Architectures.DTOS.Response

class ApiResponse <T>(
    val success: Boolean,
    val message: String,
    val data: T? = null
)