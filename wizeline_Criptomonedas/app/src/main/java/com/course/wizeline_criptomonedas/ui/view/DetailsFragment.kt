package com.course.wizeline_criptomonedas.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.databinding.FragmentDetailsBinding
import com.course.wizeline_criptomonedas.ui.view.adapter.BidsAsksAdapter
import com.course.wizeline_criptomonedas.ui.viewmodel.BitsoViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

@AndroidEntryPoint
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
        binding.swipeDetails.setProgressBackgroundColorSchemeColor(resources.getColor(R.color.splash_color))

        binding.swipeDetails.setOnRefreshListener {
            bitsoViewModel.getInfoBook()
            binding.swipeDetails.isRefreshing = false
        }

        bitsoViewModel.getInfoBook()


        bitsoViewModel.isLoadingDetails.observe(viewLifecycleOwner,Observer{
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
            binding.llyDetails.visibility = if (it) View.INVISIBLE else View.VISIBLE
        })

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