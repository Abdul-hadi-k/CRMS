package com.example.crms.controller

import com.example.crms.repository.TeacherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


data class LoginRequest(
    val email : String = "",
    val password : String = "",
)

data class LoginResponse(
    val id : Int,
    val name : String,
    val email : String
)

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
class AuthController(@Autowired val repository: TeacherRepository){

    @PostMapping("/login")
    fun login(@RequestBody req : LoginRequest) : ResponseEntity<Any>{
        val teacher = repository.findByEmailAndPassword(req.email, req.password)
        return if (teacher != null) {
            ResponseEntity.ok(
                LoginResponse(
                    id = teacher.id,
                    name = teacher.name,
                    email = teacher.email

                )
            )
        }
        else {
            ResponseEntity.status(401)
                .body(mapOf("error" to "Invalid Credentials"))

        }
    }
}