package com.dio.creditapplicationsystem.rest.dto

import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
){
//    fun toEntity(): Credit = Credit(
//        creditValue = this.
//    )
}
