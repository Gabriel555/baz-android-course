package com.course.wizeline_criptomonedas.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.databinding.FragmentDetailsBinding
import com.course.wizeline_criptomonedas.ui.view.adapter.BidsAsksAdapter
import com.course.wizeline_criptomonedas.ui.view.adapter.CryptoAdapter
import com.course.wizeline_criptomonedas.ui.viewmodel.BitsoViewModel
import java.text.DecimalFormat

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val bitsoViewModel : BitsoViewModel by activityViewModels()
    private val adapterbids = BidsAsksAdapter()
    private val adapterasks = BidsAsksAdapter()
    private val dec = DecimalFormat("#,###.##")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBids.adapter = adapterbids
        binding.rvAsks.adapter = adapterasks
        binding.tvTxtMaximumPrice.isSelected = true
        binding.tvTxtMinimunPrice.isSelected = true
        bitsoViewModel.getInfoBook()

        bitsoViewModel._data_book_model.observe(viewLifecycleOwner,Observer{
            binding.tvTxtTitle.text = it.infoBook.book.replace("_mxn","").uppercase()
            binding.tvMaximumPrice.text = "$ ${dec.format(it.infoBook.high.toFloat())}"
            binding.tvMinimunPrice.text = "$ ${dec.format(it.infoBook.low.toFloat())}"
            binding.tvLastPrice.text = "$ ${dec.format(it.infoBook.last.toFloat())}"
        })

        bitsoViewModel._bids_asks_model.observe(viewLifecycleOwner, Observer {
            adapterasks.submitList(it.infoBidsAsks.asks)
            adapterbids.submitList(it.infoBidsAsks.bids)
        })

        bitsoViewModel._selected_Item.observe(viewLifecycleOwner, Observer {
            binding.ivCoin.setImageResource(it.image)
        })
    }

}