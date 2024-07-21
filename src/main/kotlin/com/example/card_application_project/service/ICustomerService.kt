package com.example.card_application_project.service

import com.example.card_application_project.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer
    fun findByID(id: Long): Customer
    fun delete(id: Long)

}