package com.example.crms.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Teachers")
data class Teacher(

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int = 0,
    val name : String = "",
    val email : String = "",
    val password : String = "",

)