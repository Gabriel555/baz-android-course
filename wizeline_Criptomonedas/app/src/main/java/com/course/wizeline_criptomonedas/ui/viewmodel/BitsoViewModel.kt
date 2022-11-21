package com.course.wizeline_criptomonedas.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.course.wizeline_criptomonedas.data.database.entities.toDatabase
import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.repositories.BookRepository
import com.course.wizeline_criptomonedas.domain.model.Crypto
import com.course.wizeline_criptomonedas.domain.model.toDomain
import com.course.wizeline_criptomonedas.domain.usecases.GetBidsAsksBooksUseCase
import com.course.wizeline_criptomonedas.domain.usecases.GetInfoBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BitsoViewModel @Inject constructor(
    private val bookRepository: BookRepository,
    private val getInfoBooksUseCase: GetInfoBooksUseCase,
    private val getBidsAsksBooksUseCase: GetBidsAsksBooksUseCase
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val mutableBookModel = MutableLiveData<List<Crypto>?>()
    val _book_model: MutableLiveData<List<Crypto>?> get() = mutableBookModel
    private val mutableSelectedItem = MutableLiveData<Crypto>()
    val _selected_Item: LiveData<Crypto> get() = mutableSelectedItem
    private val mutableDataBookModel = MutableLiveData<InfoBookModel>()
    val _data_book_model: MutableLiveData<InfoBookModel> get() = mutableDataBookModel
    private val mutablebidsAsksModel = MutableLiveData<BidsAsksBookModel>()
    val _bids_asks_model: MutableLiveData<BidsAsksBookModel> get() = mutablebidsAsksModel

    val isLoading = MutableLiveData<Boolean>()
    val isLoadingDetails = MutableLiveData<Boolean>()

    fun selectItem(item: Crypto) {
        mutableSelectedItem.value = item
    }

    init {
        onCreate()
    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            compositeDisposable.add(
                bookRepository.getAllBooksFromApi()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ cryptos ->
                        suspend { bookRepository.clearCryptos() }
                        val resultBooksFilter = mutableListOf<Crypto>()
                        cryptos.forEach {
                            if (it.book.contains("mxn")) {
                                resultBooksFilter.add(it.toDomain())
                            }
                        }
                        suspend { bookRepository.insertBooks(resultBooksFilter.map { it.toDatabase() }) }
                    }, {
                    })
            )
            mutableBookModel.postValue(bookRepository.getAllBooksFromDatabase())
            isLoading.postValue(false)
        }
    }

    fun getInfoBook() {
        CoroutineScope(IO).launch {
            isLoadingDetails.postValue(true)
            val infoBooksUseCase = async {
                mutableSelectedItem.value?.let { getInfoBooksUseCase(book = it.book) }
            }
            val bidsaAsksUseCase = async {
                mutableSelectedItem.value?.let { getBidsAsksBooksUseCase(book = it.book) }
            }

            mutableDataBookModel.postValue(infoBooksUseCase.await())
            mutablebidsAsksModel.postValue(bidsaAsksUseCase.await())
            isLoadingDetails.postValue(false)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
