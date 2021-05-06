package com.chyngyz.task2.ui.fragments.home.adapter

import android.annotation.SuppressLint
import android.view.View
import com.chyngyz.task2.R
import com.chyngyz.task2.data.models.Cafe
import com.chyngyz.task2.databinding.ItemCafeBinding

class CafeAdapter : com.chyngyz.task2.base.BaseAdapter<Cafe, ItemCafeBinding>(
    R.layout.item_cafe,
    mutableListOf(),
    inflater = ItemCafeBinding::inflate
) {
    @SuppressLint("SetTextI18n")
    override fun onBind(binding: ItemCafeBinding, model: Cafe, pos: Int) {
        binding.itemCafeImg.setImageDrawable(model.photo)
        model.discount?.let {
            binding.cafeDiscount.visibility = View.VISIBLE
            binding.cafeDiscount.text = model.discount
        }
        binding.itemCafeTitle.text = model.title
        binding.cafeOpen.text = model.open
        binding.cafeRating.text = model.rating.toString()
        binding.cafeRating2.text = "(${model.ratingCount})"
        binding.cafeCountry.text = model.country
        binding.cafeBurger.text = model.meal
        binding.cafeDelivery.text = model.delivery
        binding.cafeMinimumCost.text = model.minimumPrice
        binding.cafeDurationTime.text = model.duration
        binding.cafeLocation.text = model.location
    }
}