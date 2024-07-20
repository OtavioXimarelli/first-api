package com.example.card_aplication_project.dto

import com.example.card_aplication_project.entity.Credit
import org.aspectj.apache.bcel.classfile.Code
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList (
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int
) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallment
    )
}
