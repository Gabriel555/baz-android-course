package com.course.wizeline_criptomonedas.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.course.wizeline_criptomonedas.data.model.BidsAsksModel
import com.course.wizeline_criptomonedas.databinding.ItemBidsAsksBinding
import java.text.DecimalFormat

class BidsAsksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemBidsAsksBinding.bind(view)
    private val dec = DecimalFormat("#,###.##")

    fun render(bidsAsks: BidsAsksModel) {
        binding.tvBookValue.text = bidsAsks.book.replace("_mxn", "").uppercase()
        binding.tvAmountValue.text = dec.format(bidsAsks.amount.toFloat())
        binding.tvPriceValue.text = dec.format(bidsAsks.price.toFloat())
        binding.tvBook.isSelected = true
        binding.tvAmount.isSelected = true
        binding.tvPrice.isSelected = true
    }
}
