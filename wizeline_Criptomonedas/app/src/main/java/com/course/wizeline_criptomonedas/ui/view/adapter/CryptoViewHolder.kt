package com.course.wizeline_criptomonedas.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.databinding.ItemCoinBinding

class CryptoViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCoinBinding.bind(view)

    fun render(crypto: CryptoModel){
        binding.tvCoinName.text = crypto.book.replace("_mxn","").uppercase()
        val id = itemView.context.resources.getIdentifier(
            "ic_${crypto.book}",
            "drawable",
            binding.root.context.packageName
        )
        crypto.image = id
        binding.ivCoin.setImageResource(crypto.image)
    }
}