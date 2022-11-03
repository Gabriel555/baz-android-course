package com.course.wizeline_criptomonedas.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.databinding.ItemCoinBinding

class CryptoViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val binding = ItemCoinBinding.bind(view)

    fun render(crypto: CryptoModel, onClickListener: (CryptoModel) -> Unit){
        binding.tvCoinName.text = crypto.book.replace("_mxn","").uppercase()
        binding.tvMaximumPrice.text = crypto.precioMaximo
        binding.tvMinimunPrice.text = crypto.precioMinimo
        binding.tvTxtMaximumPrice.isSelected = true
        binding.tvTxtMinimunPrice.isSelected = true
        binding.ivCoin.setImageResource(crypto.imagen)
        itemView.setOnClickListener { onClickListener(crypto) }
    }
}