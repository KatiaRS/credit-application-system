package com.dio.creditapplicationsystem.rest.dto

import com.dio.creditapplicationsystem.domain.Credit
import com.dio.creditapplicationsystem.domain.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field: NotNull(message = "Invalid input")
    val creditValue: BigDecimal,

    @field: Future(message = "Invalid input")
    val dayFirstOfInstallment: LocalDate,

    @field:Min(value = 1) @field: Max(value = 48)
    val numberOfInstallments: Int,

    @field: NotNull(message = "Invalid input")
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstOfInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
