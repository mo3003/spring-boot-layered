
package com.example.Layered.Architectures.Repositories

import com.example.Layered.Architectures.Models.User
import org.springframework.stereotype.Repository

@Repository
class  UserRepository{
    private val user =  mutableListOf<User>(
        User(id = 1, name = "Alice Johnson", email = "alice.johnson@example.com"),
        User(id = 2, name = "Bob Smith", email = "bob.smith@example.com"),
        User(id = 3, name = "Charlie Brown", email = "charlie.brown@example.com"),
        User(id = 4, name = "Diana Prince", email = "diana.prince@example.com"),
        User(id = 5, name = "Ethan Hunt", email = "ethan.hunt@example.com")
    )


    fun getAll(): List<User>{
        return user
    }
     fun create(user: User): User{
         var nextId = 6
         val newUser = user.copy( nextId++) // ignores any id from the client

         user.add(newUser)
         return user
     }
    fun getById(id: Int): User{
        return user.first { it.id == id }
    }
    fun update(id: Int): User{
        return user.first{ it.id == id }
    }

    fun save(existing: User): User? {
        return user.first{ it.id == existing.id }
    }
    fun delete(id: Int): Boolean = user.removeIf{ it.id == id }
    fun existsByEmail(email: String): Boolean = user.any{ it.email.equals(email, ignoreCase = true) }
}





//@Repository
//class UserRepository {
//    private val users = mutableListOf(
//        User(id = 1, name = "Alice Johnson", email = "alice.johnson@example.com"),
//        User(id = 2, name = "Bob Smith", email = "bob.smith@example.com"),
//        User(id = 3, name = "Charlie Brown", email = "charlie.brown@example.com"),
//        User(id = 4, name = "Diana Prince", email = "diana.prince@example.com"),
//        User(id = 5, name = "Ethan Hunt", email = "ethan.hunt@example.com")
//    )
//    private var nextId = 6   // outside the function, so it keeps counting
//    fun getAll(): List<User> = users.toList()
//    fun getById(id: Int): User? = users.firstOrNull { it.id == id }
//    fun create(user: User): User {
//        val newUser = user.copy(id = nextId++)
//        users.add(newUser)
//        return newUser
//    }
//    fun update(id: Int, updated: User): User? {
//        val index = users.indexOfFirst { it.id == id }
//        if (index == -1) return null
//        val result = updated.copy(id = id)
//        users[index] = result
//        return result
//    }
//    fun delete(id: Int): Boolean = users.removeIf { it.id == id }
//}