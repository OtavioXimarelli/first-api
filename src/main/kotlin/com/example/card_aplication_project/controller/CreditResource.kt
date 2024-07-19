package com.example.card_aplication_project.controller

import com.example.card_aplication_project.dto.CustomerDto
import com.example.card_aplication_project.service.impl.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController

@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
    //testando o commit
) {



}