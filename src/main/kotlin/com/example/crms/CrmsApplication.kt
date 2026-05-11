package com.example.crms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrmsApplication

fun main(args: Array<String>) {
    runApplication<CrmsApplication>(*args)
}
