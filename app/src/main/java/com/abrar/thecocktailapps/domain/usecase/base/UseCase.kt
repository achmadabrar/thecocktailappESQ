package com.abrar.thecocktailapps.domain.usecase.base

import android.util.Log
import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel
import com.abrar.thecocktailapps.domain.exception.traceErrorException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class UseCase<Type, in Params>() where Type : Any {

    abstract suspend fun runSearchByName(params: Params? = null): ResponseModel
    abstract suspend fun runFilterByAlcoholic(params: Params? = null): ResponseModel
    abstract suspend fun runFilterByCategory(params: Params? = null): ResponseModel
    abstract suspend fun runFilterByGlass(params: Params? = null): ResponseModel
    abstract suspend fun runGetDetail(params: Params? = null): ResponseModel

    fun invokeSearchByName(scope: CoroutineScope, params: Params?, onResult: UseCaseAllFilter<ResponseModel>) {

        scope.launch {
            try {
                val result = runSearchByName(params)
                onResult.onSuccess(result)
                Log.d("SEARCH_RESULT", result.toString())
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            }
        }
    }

    fun invokeFilterByAlcoholic(scope: CoroutineScope, params: Params?, onResult: UseCaseAllFilter<ResponseModel>) {

        scope.launch {
            try {
                val result = runFilterByAlcoholic(params)
                onResult.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            }
        }
    }

    fun invokeFilterByCategory(scope: CoroutineScope, params: Params?, onResult: UseCaseAllFilter<ResponseModel>) {

        scope.launch {
            try {
                val result = runFilterByCategory(params)
                onResult.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            }
        }
    }

    fun invokeFilterByGlass(scope: CoroutineScope, params: Params?, onResult: UseCaseAllFilter<ResponseModel>) {

        scope.launch {
            try {
                val result = runFilterByGlass(params)
                onResult.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            }
        }
    }

    fun invokeDetail(scope: CoroutineScope, params: Params?, onResult: UseCaseAllFilter<ResponseModel>) {

        scope.launch {
            try {
                val result = runGetDetail(params)
                onResult.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult.onError(traceErrorException(e))
            }
        }
    }

}