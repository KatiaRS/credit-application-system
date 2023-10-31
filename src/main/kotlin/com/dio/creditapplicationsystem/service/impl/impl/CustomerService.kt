package com.dio.creditapplicationsystem.service.impl.impl

import com.dio.creditapplicationsystem.domain.Customer
import com.dio.creditapplicationsystem.repository.CustomerRepository
import com.dio.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow{                 //caso não encontre, lança excessão
            throw RuntimeException("Id $id not found")
        }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)

}