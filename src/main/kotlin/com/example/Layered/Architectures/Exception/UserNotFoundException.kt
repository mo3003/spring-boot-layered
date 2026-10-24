package com.example.Layered.Architectures.Exception

import org.springframework.http.ResponseEntity

class UserNotFoundException(id: Int): RuntimeException("User with id [$id] not found")