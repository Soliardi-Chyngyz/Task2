package com.chyngyz.task2.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, Binding : ViewBinding>(
    private val holderLayoutId: Int,
    var data: MutableList<T>,
    private val inflater: (LayoutInflater) -> Binding,
) : RecyclerView.Adapter<BaseAdapter<T, Binding>.BaseViewHolder>() {
    private var _binding: Binding? = null
    val binding get() = _binding!!

    @SuppressLint("ServiceCast")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        _binding = inflater.invoke(LayoutInflater.from(parent.context))
        return BaseViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    abstract fun onBind(binding: Binding, model: T, pos: Int)

    inner class BaseViewHolder(val bindingViewHolder: Binding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: T) {
            onBind(bindingViewHolder, model, adapterPosition)
        }
    }
}