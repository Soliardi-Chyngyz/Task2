package com.chyngyz.task2.data.models

import android.graphics.drawable.Drawable

data class Category(
    val photo: Drawable? = null,
    val name: String,
    var selected: Boolean = false,
)
