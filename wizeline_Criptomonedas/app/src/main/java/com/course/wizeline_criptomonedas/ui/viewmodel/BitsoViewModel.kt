package com.course.wizeline_criptomonedas.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.domain.usecases.GetBidsAsksBooksUseCase
import com.course.wizeline_criptomonedas.domain.usecases.GetBooksUseCase
import com.course.wizeline_criptomonedas.domain.usecases.GetInfoBooksUseCase
import kotlinx.coroutines.launch

class BitsoViewModel: ViewModel() {

    val bookModel = MutableLiveData<List<CryptoModel>>()
    val isLoading = MutableLiveData<Boolean>()


    val getBooksUseCase = GetBooksUseCase()
    val getInfoBooksUseCase = GetInfoBooksUseCase()
    val getBidsAsksBooksUseCase = GetBidsAsksBooksUseCase()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            bookModel.postValue(getBooksUseCase()!!)
            isLoading.postValue(false)


            val resultInfoBooks = getInfoBooksUseCase()
            println(resultInfoBooks)


            val resultBidsAsksBooks = getBidsAsksBooksUseCase()
            println(resultBidsAsksBooks)
        }

    }
}