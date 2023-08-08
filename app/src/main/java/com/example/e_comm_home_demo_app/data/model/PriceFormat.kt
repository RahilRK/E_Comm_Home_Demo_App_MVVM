package com.example.e_comm_home_demo_app.data.model

data class PriceFormat(
    val decimalSymbol: String,
    val groupLength: Int,
    val groupSymbol: String,
    val integerRequired: Boolean,
    val pattern: String,
    val precision: Int,
    val requiredPrecision: Int
)