package com.example.card_aplication_project.repository

import com.example.card_aplication_project.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}