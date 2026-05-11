package com.example.crms.repository

import com.example.crms.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeacherRepository : JpaRepository<Teacher, Int>{
    fun findByEmailAndPassword(
        email: String,
        password: String
    ): Teacher?
}