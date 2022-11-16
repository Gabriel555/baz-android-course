package com.course.wizeline_criptomonedas.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.data.model.BidsAsksModel

class BidsAsksAdapter() :
    ListAdapter<BidsAsksModel, BidsAsksViewHolder>(BidsAsksDiffUtilCalback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BidsAsksViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BidsAsksViewHolder(
            view = layoutInflater.inflate(R.layout.item_bids_asks, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BidsAsksViewHolder, position: Int) {
        holder.render(bidsAsks = getItem(position))
    }
}

private object BidsAsksDiffUtilCalback : DiffUtil.ItemCallback<BidsAsksModel>() {

    override fun areItemsTheSame(oldItem: BidsAsksModel, newItem: BidsAsksModel): Boolean =
        oldItem.book == newItem.book

    override fun areContentsTheSame(oldItem: BidsAsksModel, newItem: BidsAsksModel): Boolean =
        oldItem == newItem
}
