package com.abrar.thecocktailapps.presentation.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel
import com.abrar.thecocktailapps.domain.model.ApiError
import com.abrar.thecocktailapps.domain.usecase.ListCocktailUseCase
import com.abrar.thecocktailapps.domain.usecase.base.UseCaseAllFilter

class DetailCockTailViewModel constructor(private val getDetailUseCase: ListCocktailUseCase) :
    ViewModel() {

    val details = MutableLiveData<ResponseModel>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getDetail(id: String?) {
        showProgressbar.value = true
        getDetailUseCase.invokeDetail(
            viewModelScope, id,
            object : UseCaseAllFilter<ResponseModel> {
                override fun onSuccess(result: ResponseModel) {
                    Log.i(TAG, "result: $result")
                    details.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    companion object {
        private val TAG = DetailCockTailViewModel::class.java.name
    }
}