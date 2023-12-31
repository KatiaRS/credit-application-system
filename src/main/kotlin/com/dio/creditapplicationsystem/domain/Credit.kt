package com.dio.creditapplicationsystem.domain

import com.dio.creditapplicationsystem.enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Credit")
data class Credit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val creditCode: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    val dayFirstOfInstallment: LocalDate,                     //data primeira parcela

    @Column(nullable = false)
    val numberOfInstallments: Int = 0,

    @Enumerated
    val status: Status = Status.IN_PROGRESS,

    @ManyToOne
    @JoinColumn(name = "customer")
    var customer: Customer? = null                         //ver se existe no banco de dados

)
