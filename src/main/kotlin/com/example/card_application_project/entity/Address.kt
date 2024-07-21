package com.example.card_application_project.entity

import jakarta.persistence.*


@Embeddable
data class Address(
    @Column(nullable = false) var zipCode: String = "",
    @Column(nullable = false) var street: String = "",
    @Column(nullable = false) var houseNumber: Long = 0
)