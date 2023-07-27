package br.com.alexfelipe.authapp.models

import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    val image: String? = null
)