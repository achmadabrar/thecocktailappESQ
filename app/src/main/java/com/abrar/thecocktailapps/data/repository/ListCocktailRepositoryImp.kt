package com.abrar.thecocktailapps.data.repository

import com.abrar.thecocktailapps.data.source.remote.ApiService
import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel
import com.abrar.thecocktailapps.domain.repository.ListCocktailRepository

class ListCocktailRepositoryImp(private val apiService: ApiService) : ListCocktailRepository {

    override suspend fun getSearchByName(s: String): ResponseModel {
        return apiService.searchByName(s)
    }

    override suspend fun getFilterByAlcoholic(a: String): ResponseModel {
        return  apiService.filterByAlcoholic(a)
    }

    override suspend fun getFilterByCategory(c: String): ResponseModel {
        return apiService.filterByCategory(c)
    }

    override suspend fun getFilterByGlass(g: String): ResponseModel {
        return apiService.filterByGlass(g)
    }

    override suspend fun getDetail(i: String): ResponseModel {
        return apiService.getDetails(i)
    }
}