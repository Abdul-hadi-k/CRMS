package com.example.crms.repository

import com.example.crms.model.Result
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResultRepository : JpaRepository<Result, Int>