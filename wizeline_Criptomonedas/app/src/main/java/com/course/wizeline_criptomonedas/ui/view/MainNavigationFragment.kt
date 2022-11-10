package com.course.wizeline_criptomonedas.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import androidx.navigation.fragment.findNavController
import com.course.wizeline_criptomonedas.databinding.FragmentMainNavigationBinding
import com.course.wizeline_criptomonedas.ui.view.adapter.CryptoAdapter
import com.course.wizeline_criptomonedas.ui.viewmodel.BitsoViewModel

class MainNavigationFragment : Fragment() {

    private lateinit var binding: FragmentMainNavigationBinding
    private val bitsoViewModel : BitsoViewModel by activityViewModels()
    private val adapter = CryptoAdapter { crypto ->
        onItemSelected(
            crypto
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainNavigationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCoins.adapter = adapter

        bitsoViewModel._book_model.observe(viewLifecycleOwner, Observer { cryptoList ->
            adapter.submitList(cryptoList)
        })

        bitsoViewModel.isLoading.observe(viewLifecycleOwner,Observer{
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
            binding.rvCoins.visibility = if (it) View.GONE else View.VISIBLE
        })

    }

    private fun onItemSelected(crypto: CryptoModel){
        bitsoViewModel.selectItem(crypto)
        findNavController().navigate(R.id.action_mainNavigationFragment_to_detailsFragment)
    }

}