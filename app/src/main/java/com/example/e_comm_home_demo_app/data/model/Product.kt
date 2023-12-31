package com.example.e_comm_home_demo_app.data.model

data class Product(
    val LabelCollection: List<Any>,
    val arTextureImages: List<Any>,
    val arType: String,
    val arUrl: String,
    val availability: String,
    val configurableData: ConfigurableData,
    val dominantColor: String,
    val entityId: String,
    val finalPrice: Double,
    val formattedFinalPrice: String,
    val formattedPrice: String,
    val formattedTierPrice: String,
    val hasRequiredOptions: Boolean,
    val isAvailable: Boolean,
    val isInRange: Boolean,
    val isInWishlist: Boolean,
    val isNew: Boolean,
    val isOfferApplicable: Boolean,
    val minAddToCartQty: Int,
    val name: String,
    val offerlabel: String,
    val price: Double,
    val rating: Int,
    val reviewCount: Int,
    val template_baseurl: String,
    val thumbNail: String,
    val tierPrice: String,
    val typeId: String,
    val wishlistItemId: Int
)