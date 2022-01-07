package com.abrar.thecocktailapps.presentation.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel
import com.abrar.thecocktailapps.domain.model.ApiError
import com.abrar.thecocktailapps.domain.usecase.ListCocktailUseCase
import com.abrar.thecocktailapps.domain.usecase.base.UseCaseAllFilter
import kotlinx.coroutines.cancel

class ListCocktailViewModel constructor(private val getListUseCase: ListCocktailUseCase) :
    ViewModel() {

    val listCocktail = MutableLiveData<ResponseModel>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getListCocktailByName(paramData: String?) {
        showProgressbar.value = true
        getListUseCase.invokeSearchByName(
            viewModelScope, paramData,
            object : UseCaseAllFilter<ResponseModel> {
                override fun onSuccess(result: ResponseModel) {
                    Log.i(TAG, "result: $result")
                    listCocktail.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    fun getListCocktailByAlcoholic(paramData: String?) {
        showProgressbar.value = true
        getListUseCase.invokeFilterByAlcoholic(
            viewModelScope, paramData,
            object : UseCaseAllFilter<ResponseModel> {
                override fun onSuccess(result: ResponseModel) {
                    Log.i(TAG, "result: $result")
                    listCocktail.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    fun getListCocktailByCategory(paramData: String?) {
        showProgressbar.value = true
        getListUseCase.invokeFilterByCategory(
            viewModelScope, paramData,
            object : UseCaseAllFilter<ResponseModel> {
                override fun onSuccess(result: ResponseModel) {
                    Log.i(TAG, "result: $result")
                    listCocktail.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }


    fun getListCocktailByGlass(paramData: String?) {
        showProgressbar.value = true
        getListUseCase.invokeFilterByGlass(
            viewModelScope, paramData,
            object : UseCaseAllFilter<ResponseModel> {
                override fun onSuccess(result: ResponseModel) {
                    Log.i(TAG, "result: $result")
                    listCocktail.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private val TAG = ListCocktailViewModel::class.java.name
    }
}
