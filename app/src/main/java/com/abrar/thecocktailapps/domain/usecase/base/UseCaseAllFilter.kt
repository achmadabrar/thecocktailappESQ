package com.abrar.thecocktailapps.domain.usecase.base

import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel
import com.abrar.thecocktailapps.domain.model.ApiError

interface UseCaseAllFilter <Type>{
    fun onSuccess(result: ResponseModel)
    fun onError(apiError: ApiError?)
}