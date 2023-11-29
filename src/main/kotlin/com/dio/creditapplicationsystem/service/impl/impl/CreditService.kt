package com.dio.creditapplicationsystem.service.impl.impl

import com.dio.creditapplicationsystem.domain.Credit
import com.dio.creditapplicationsystem.exception.BusinessException
import com.dio.creditapplicationsystem.repository.CreditRepository
import com.dio.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*


@Service
class CreditService(
    private val creditRepository: CreditRepository, private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)        //Using @Query


    override  fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {     //o retorno do crédito tem que ser somente o meu
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)     //Named Queries (JPA)- findBy
            ?: throw BusinessException("Creditcode $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw BusinessException(" Contact admin")
    }
}