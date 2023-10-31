package com.dio.creditapplicationsystem.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class AddressCustomer(
    @Column(nullable = false)
    var zipCode: String = "",

    @Column(nullable = false)
    var street: String = ""
)
