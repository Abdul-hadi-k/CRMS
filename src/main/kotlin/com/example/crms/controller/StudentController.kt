package com.example.crms.controller

import com.example.crms.model.Student
import com.example.crms.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
class StudentController(@Autowired val repo: StudentRepository) {

    @GetMapping
    fun getAll(): List<Student> {
        return repo.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Student> {
        val student = repo.findById(id)
        return if (student.isPresent) {
            ResponseEntity.ok(student.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun create(@RequestBody student: Student): Student {
        return repo.save(student)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody student: Student
    ): ResponseEntity<Student> {
        return if (repo.existsById(id)) {
            ResponseEntity.ok(repo.save(student.copy(id = id)))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        return if (repo.existsById(id)) {
            repo.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}