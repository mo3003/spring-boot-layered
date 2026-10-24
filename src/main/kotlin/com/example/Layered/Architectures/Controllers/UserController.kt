
package com.example.Layered.Architectures.Controllers

import com.example.Layered.Architectures.DTOs.Request.CreateUserRequest
import com.example.Layered.Architectures.Models.User
import com.example.Layered.Architectures.Services.UserServices
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class UserController ( private val userServices: UserServices) {
    @GetMapping("/user")
    fun getUsers(): ResponseEntity<List<User>>{
        val user = userServices.getAll()
        return ResponseEntity.status(HttpStatus.OK).body(
            user
        )
    }
    @PostMapping("/user/create")
    fun create(@RequestBody user: User): ResponseEntity<User>{
        val createdUser = userServices.create(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(
                createdUser
            )
    }
    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Int): ResponseEntity<User>{
        val user = userServices.getById(id)
        return ResponseEntity.status(HttpStatus.OK).body(
            user
        )
    }
    @PutMapping("/user/update/{id}")
    fun update(@PathVariable id: Int, @RequestBody user: User): ResponseEntity<User>{
        val result = userServices.update(id, user)
        return ResponseEntity.status(HttpStatus.OK).body(
            result
        )
    }
    @DeleteMapping("/user/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        return if (userServices.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
















//@GetMapping("/user/{id}")
//fun getUserById(@PathVariable id: Int): ResponseEntity<User> {
//    val user = userServices.getById(id)
//    return if (user != null) ResponseEntity.ok(user)
//    else ResponseEntity.notFound().build()
//}
//@PutMapping("/user/update/{id}")
//fun update(@PathVariable id: Int, @RequestBody user: User): ResponseEntity<User> {
//    val result = userServices.update(id, user)
//    return if (result != null) ResponseEntity.ok(result)
//    else ResponseEntity.notFound().build()
//}