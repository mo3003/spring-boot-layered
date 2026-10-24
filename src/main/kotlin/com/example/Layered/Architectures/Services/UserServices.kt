
package com.example.Layered.Architectures.Services

import com.example.Layered.Architectures.DTOs.Request.UpdateUserRequest
import com.example.Layered.Architectures.Models.User
import com.example.Layered.Architectures.Repositories.UserRepository
import org.springframework.data.annotation.Id
import org.springframework.stereotype.Service

@Service
class UserServices(private val userRepository: UserRepository) {
    fun getAll(): List<User> = userRepository.getAll()


    fun create(user: User): User {
        return userRepository.create(user)
    }

    fun getById(id: Int): User {
        return userRepository.getById(id)
    }

    fun update(id: Int, update: User): User? {
        val existing = userRepository.getById(id)
        existing.name = update.name
        existing.email = update.email
        return userRepository.save(existing)
    }

    fun delete(id: Int): Boolean = userRepository.delete(id)
}




//@Service
//class UserServices(private val userRepository: UserRepository) {
//    fun getAll(): List<User> = userRepository.getAll()
//    fun getById(id: Int): User? = userRepository.getById(id)
//    fun create(user: User): User = userRepository.create(user)
//    fun update(id: Int, update: User): User? = userRepository.update(id, update)
//    fun delete(id: Int): Boolean = userRepository.delete(id)
//}