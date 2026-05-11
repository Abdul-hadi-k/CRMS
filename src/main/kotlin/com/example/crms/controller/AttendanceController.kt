package com.example.crms.controller

import com.example.crms.model.Attendance
import com.example.crms.repository.AttendanceRepository
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
@RequestMapping("/api/attendance")
@CrossOrigin("*")
class AttendanceController(@Autowired val repo: AttendanceRepository) {

    @GetMapping
    fun getAll(): List<Attendance> {
        return repo.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Attendance> {
        val att = repo.findById(id)
        return if (att.isPresent) {
            ResponseEntity.ok(att.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun create(@RequestBody att: Attendance): Attendance {
        return repo.save(att)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody att: Attendance
    ): ResponseEntity<Attendance> {
        return if (repo.existsById(id)) {
            ResponseEntity.ok(repo.save(att.copy(id = id)))
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