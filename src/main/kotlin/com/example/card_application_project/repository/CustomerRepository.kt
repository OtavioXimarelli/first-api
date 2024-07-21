package com.example.card_application_project.repository

import com.example.card_application_project.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}