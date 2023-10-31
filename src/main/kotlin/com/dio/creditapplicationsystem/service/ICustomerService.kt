package com.dio.creditapplicationsystem.service

import com.dio.creditapplicationsystem.domain.Customer
import java.util.UUID

//conceito de solid - agregação de interface, dividir as funcionalidades em interface e depois
//implementa as classes completa.



interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}