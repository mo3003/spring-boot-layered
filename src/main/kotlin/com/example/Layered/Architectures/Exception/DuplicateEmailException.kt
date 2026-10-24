package com.example.Layered.Architectures.Exception

class DuplicateEmailException(id: Int): RuntimeException("User with id [$id] already exists")