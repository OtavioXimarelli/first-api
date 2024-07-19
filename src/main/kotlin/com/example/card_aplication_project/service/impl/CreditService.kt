package com.example.card_aplication_project.service.impl

import com.example.card_aplication_project.entity.Credit
import com.example.card_aplication_project.entity.Customer
import com.example.card_aplication_project.repository.CreditRepository
import com.example.card_aplication_project.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*


@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    fun save(credit: Customer): Credit {
        credit.apply {
            customer = customerService.findByID(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomer(customerId)

    override fun findCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Code $creditCode not found in database..."))
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact support for more information...")
    }


}