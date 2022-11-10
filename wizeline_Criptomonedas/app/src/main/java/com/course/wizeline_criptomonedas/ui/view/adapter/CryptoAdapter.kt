package com.course.wizeline_criptomonedas.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.data.model.CryptoModel

class CryptoAdapter(private val onClickListener:(CryptoModel) -> Unit) :
    ListAdapter<CryptoModel,CryptoViewHolder>(DiffUtilCalback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CryptoViewHolder(
            view = layoutInflater.inflate(R.layout.item_coin,parent,false))
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.render(crypto = getItem(position))
        holder.itemView.setOnClickListener { onClickListener(getItem(position)) }
    }
}

private object DiffUtilCalback : DiffUtil.ItemCallback<CryptoModel>(){

    override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean =
        oldItem.book == newItem.book

    override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean =
        oldItem == newItem
}