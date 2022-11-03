package com.course.wizeline_criptomonedas.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.databinding.ActivityMainBinding
import com.course.wizeline_criptomonedas.ui.view.adapter.CryptoAdapter
import com.course.wizeline_criptomonedas.ui.viewmodel.BitsoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val bitsoViewModel : BitsoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bitsoViewModel.onCreate()

        bitsoViewModel.bookModel.observe(this, Observer {
            initRecyclerView(it)

        })

        bitsoViewModel.isLoading.observe(this,Observer{
            binding.progress.isVisible = it
        })


    }

    private fun initRecyclerView(cryptoList: List<CryptoModel>) {
        binding.rvCoins.layoutManager = LinearLayoutManager( this)
        binding.rvCoins.adapter = CryptoAdapter(cryptos = cryptoList){ crypto ->
            onItemSelected(
                crypto
            )
        }
    }

    private fun onItemSelected(crypto:CryptoModel){
        

    }
}