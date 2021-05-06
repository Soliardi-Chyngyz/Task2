package com.chyngyz.task2.ui.fragments.home.adapter

import android.graphics.Color
import com.chyngyz.task2.R
import com.chyngyz.task2.base.BaseAdapter
import com.chyngyz.task2.data.models.Category
import com.chyngyz.task2.databinding.ItemCategoryBinding

class CategoriesAdapter(val onItemClick: (Category) -> Unit) :
    BaseAdapter<Category, ItemCategoryBinding>(
        R.layout.item_category,
        mutableListOf(),
        inflater = ItemCategoryBinding::inflate
    ) {


    override fun onBind(binding: ItemCategoryBinding, model: Category, pos: Int) {
        model.photo?.let {
            binding.itemCatImg.setImageResource(R.drawable.p_one)
        }
        binding.itemCatTitle.text = model.name

        if (model.selected)
            binding.itemCatView.setBackgroundColor(Color.parseColor("#FBBC04"))
        else
            binding.itemCatView.setBackgroundColor(Color.parseColor("#00000000"))

        binding.root.setOnClickListener {
            model.selected = !model.selected
            onLogicProcess(model)
        }
    }

    private fun onLogicProcess(model: Category) {
        if (model.selected) {
            data.forEach {
                if(model != it)
                    it.selected = false
            }
            notifyDataSetChanged()
            onItemClick(model)
        }
    }
}