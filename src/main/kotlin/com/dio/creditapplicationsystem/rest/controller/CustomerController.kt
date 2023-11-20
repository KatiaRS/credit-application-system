package com.dio.creditapplicationsystem.rest.controller

import com.dio.creditapplicationsystem.domain.Customer
import com.dio.creditapplicationsystem.rest.dto.CustomerDto
import com.dio.creditapplicationsystem.rest.dto.CustomerUpdateDto
import com.dio.creditapplicationsystem.rest.dto.CustomerView
import com.dio.creditapplicationsystem.service.impl.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustumer = this.customerService.save(customerDto.toEntity())
        return "Custumer ${savedCustumer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val getCustumer = this.customerService.findById(id)
        return CustomerView(getCustumer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        customerUpdateDto: CustomerUpdateDto
    ): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }
}