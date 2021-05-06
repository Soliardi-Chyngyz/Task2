package com.chyngyz.task2.ui.fragments.home

import android.annotation.SuppressLint
import android.graphics.Color
import by.kirich1409.viewbindingdelegate.viewBinding
import com.chyngyz.task2.R
import com.chyngyz.task2.base.BaseFragment
import com.chyngyz.task2.data.models.Cafe
import com.chyngyz.task2.data.models.Category
import com.chyngyz.task2.databinding.HomeFragmentBinding
import com.chyngyz.task2.ui.fragments.home.adapter.CafeAdapter
import com.chyngyz.task2.ui.fragments.home.adapter.CategoriesAdapter
import com.google.android.material.button.MaterialButton
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("DEPRECATION")
class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(R.layout.home_fragment) {

    override val binding: HomeFragmentBinding by viewBinding()
    override val viewModel: HomeViewModel by viewModel()
    private val adapter = CategoriesAdapter(this::onItemClick)
    private val adapterCafe = CafeAdapter()
    private var lastSelected: MaterialButton? = null
    private var value: Boolean = false

    override fun setupRequests() {
        super.setupRequests()
        viewModel.onCategoriesRequest()
    }

    override fun setupViews() {
        super.setupViews()

        categories()

        cafe()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun cafe() {
        val listOfCafe = arrayListOf<Cafe>()
        val img = resources.getDrawable(R.drawable.photo)
        val item = Cafe(
            img,
            "Burger Craze",
            "Spend 25$, save 5$",
            "OPEN",
            4.6,
            601,
            "American",
            "Burgers",
            "Delivery: FREE",
            "Minimum: 10$",
            "15-20 min",
            "1.5 km away"
        )

        val item2 = Cafe(
            img,
            "Burger Craze",
            null,
            "OPEN",
            4.6,
            601,
            "American",
            "Burgers",
            "Delivery: FREE",
            "Minimum: 10$",
            "15-20 min",
            "1.5 km away"
        )
        listOfCafe.add(item)
        listOfCafe.add(item2)
        adapterCafe.data = listOfCafe
        binding.homeCafeRec.adapter = adapterCafe

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun categories() {
        val list = arrayListOf<Category>()

        val img = resources.getDrawable(R.drawable.p_one)
        val model = Category(img, "Takeaways")
        list.add(model)

        val model2 = Category(img, "Grocery")
        list.add(model2)

        val model3 = Category(img, "Convenience")
        list.add(model3)

        val model4 = Category(img, "Pharmacy")
        list.add(model4)

        adapter.data = list
        binding.homeRecycler.adapter = adapter
    }

    override fun setupListeners() {
        super.setupListeners()

        binding.homeBtnDelivery.setOnClickListener {
            value = true
            onBackgroundChanging(binding.homeBtnDelivery)
        }
        binding.homeBtnCatering.setOnClickListener {
            value = true
            onBackgroundChanging(binding.homeBtnCatering)
        }
        binding.homeBtnCurbside.setOnClickListener {
            value = true
            onBackgroundChanging(binding.homeBtnCurbside)
        }
        binding.homeBtnPickup.setOnClickListener {
            value = true
            onBackgroundChanging(binding.homeBtnPickup)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun onBackgroundChanging(view: MaterialButton) {
        lastSelected?.let {
            if (lastSelected != view) {
                it.setBackgroundColor(Color.parseColor("#00000000"))
                it.icon = null
                it.setTextColor(Color.parseColor("#82C446"))
            }
        }
        if (value) {
            view.setBackgroundColor(Color.parseColor("#FBBC04"))
            view.icon = resources.getDrawable(R.drawable.ic_del)
            view.setTextColor(Color.WHITE)
            lastSelected = view
            value = false
        }
    }

    private fun onItemClick(model: Category) {
        //TODO
    }
}