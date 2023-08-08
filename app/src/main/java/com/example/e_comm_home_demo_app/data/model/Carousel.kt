package com.example.e_comm_home_demo_app.data.model

data class Carousel(
    val banners: List<Banner>,
    val id: String,
    val label: String,
    val productList: List<Product>,
    val type: String
)