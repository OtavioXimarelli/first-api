package com.example.card_aplication_project.service.impl

import com.example.card_aplication_project.entity.Customer
import com.example.card_aplication_project.repository.CustomerRepository
import com.example.card_aplication_project.service.ICustomerService
import org.springframework.stereotype.Service


@Service
class CustomerService(
    private val customerRepository: CustomerRepository

) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findByID(id: Long): Customer = this.customerRepository.findById(id).orElseThrow() {
        throw RuntimeException("Id $id not found!")
    }


    override fun delete(id: Long): Unit = this.customerRepository.deleteById(id)
}