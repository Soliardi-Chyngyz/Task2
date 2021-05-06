package com.chyngyz.task2.data.models

import android.graphics.drawable.Drawable

data class Cafe(
    val photo: Drawable? = null,
    val title: String,
    val discount: String? = null,
    val open: String? = "OPEN",
    val rating: Double,
    val ratingCount: Int,
    val country: String,
    val meal: String? = "Burgers",
    val delivery: String = "Delivery: FREE",
    val minimumPrice: String = "Minimum: 10$",
    val duration: String,
    val location: String,
)
