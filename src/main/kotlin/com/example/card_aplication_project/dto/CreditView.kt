package com.example.card_aplication_project.dto

import com.example.card_aplication_project.entity.Credit
import com.example.card_aplication_project.entity.Customer
import com.example.card_aplication_project.enums.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerEmail: String,
    val incomeCustomer: BigDecimal?,
    val status: Status,
    val customer: Customer?,
    val id: Long?
) {

    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        dayFirstInstallment = credit.dayFirstInstallment,
        numberOfInstallments = credit.numberOfInstallment,
        customerEmail = credit.customer?.email.toString(),
        incomeCustomer = credit.customer?.income,
        status = credit.status,
        customer = credit.customer,
        id = credit.id
    )
}