package com.abrar.thecocktailapps.domain.usecase

import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel
import com.abrar.thecocktailapps.domain.repository.ListCocktailRepository
import com.abrar.thecocktailapps.domain.usecase.base.UseCase

class ListCocktailUseCase(
    private val listCocktailRepository: ListCocktailRepository
) : UseCase<List<ResponseModel>, Any?>() {
    override suspend fun runSearchByName(params: Any?): ResponseModel {
        return listCocktailRepository.getSearchByName(params.toString())
    }

    override suspend fun runFilterByAlcoholic(params: Any?): ResponseModel {
        return listCocktailRepository.getFilterByAlcoholic(params.toString())
    }

    override suspend fun runFilterByCategory(params: Any?): ResponseModel {
        return listCocktailRepository.getFilterByCategory(params.toString())
    }

    override suspend fun runFilterByGlass(params: Any?): ResponseModel {
        return listCocktailRepository.getFilterByGlass(params.toString())
    }

    override suspend fun runGetDetail(params: Any?): ResponseModel {
        return listCocktailRepository.getDetail(params.toString())
    }
}