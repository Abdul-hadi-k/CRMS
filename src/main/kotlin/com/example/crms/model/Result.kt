package com.example.crms.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "Results")
data class Result(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val student_id: Int = 0,
    val subject: String = "",
    val marks: Int = 0,
    val total_marks: Int = 100,
    val exam_date: LocalDate? = null
)