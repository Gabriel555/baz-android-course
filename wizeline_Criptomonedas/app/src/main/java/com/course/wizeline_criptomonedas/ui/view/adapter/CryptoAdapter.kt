package com.course.wizeline_criptomonedas.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.data.model.CryptoModel

class CryptoAdapter(private val cryptos: List<CryptoModel>, private val onClickListener:(CryptoModel) -> Unit) : RecyclerView.Adapter<CryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CryptoViewHolder(view = layoutInflater.inflate(R.layout.item_coin,parent,false))
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.render(crypto = cryptos[position], onClickListener = onClickListener)

    }

    override fun getItemCount(): Int = cryptos.size
}