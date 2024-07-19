package com.example.card_aplication_project.service

import com.example.card_aplication_project.entity.Credit
import jakarta.persistence.Id
import org.aspectj.apache.bcel.classfile.Code
import java.util.UUID

interface ICreditService {


    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
    fun findCreditCode(customerId: Long, creditCode: UUID): Credit
}