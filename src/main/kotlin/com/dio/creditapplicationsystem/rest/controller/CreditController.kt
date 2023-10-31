package com.dio.creditapplicationsystem.rest.controller

import com.dio.creditapplicationsystem.rest.dto.CreditDto
import com.dio.creditapplicationsystem.service.impl.impl.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {
//    @PostMapping
//    fun saveCredit(@RequestBody creditDto: CreditDto): String{
//    this.creditService.save()
//    }

}