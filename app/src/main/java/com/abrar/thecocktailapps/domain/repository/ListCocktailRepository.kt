package com.abrar.thecocktailapps.domain.repository

import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel

interface ListCocktailRepository {

    suspend fun getSearchByName(s: String): ResponseModel

    suspend fun getFilterByAlcoholic(a: String): ResponseModel

    suspend fun getFilterByCategory(c: String): ResponseModel

    suspend fun getFilterByGlass(g: String): ResponseModel

    suspend fun getDetail(i:String): ResponseModel
}