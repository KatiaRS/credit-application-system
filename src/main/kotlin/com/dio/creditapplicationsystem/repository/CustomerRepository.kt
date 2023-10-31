package com.dio.creditapplicationsystem.repository

import com.dio.creditapplicationsystem.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CustomerRepository: JpaRepository<Customer, Long>