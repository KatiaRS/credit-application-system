package com.dio.creditapplicationsystem.domain

import jakarta.persistence.*
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "Cliente")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var firstName: String = "",

    @Column(nullable = false)
    var lastName: String = "",

    @Column(nullable = false, unique = true)
    val cpf: String = "",

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    @Embedded
    var address:AddressCustomer = AddressCustomer(),

    @Column(nullable = false)
    @OneToMany(cascade =  arrayOf(CascadeType.REMOVE), mappedBy = "customer")
    var credits: List<Credit> = mutableListOf()
)
