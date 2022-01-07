package com.abrar.thecocktailapps.data.source.remote

import com.abrar.thecocktailapps.data.source.remote.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object{
        const val SEARCH = "search.php"
        const val FILTER = "filter.php"
        const val DETAIL = "lookup.php"
    }

    @GET(SEARCH)
    suspend fun searchByName(
        @Query("s") search: String
    ): ResponseModel

    @GET(FILTER)
    suspend fun filterByAlcoholic(
        @Query("a") alcoholic: String
    ): ResponseModel

    @GET(FILTER)
    suspend fun filterByCategory(
        @Query("c") category: String
    ): ResponseModel

    @GET(FILTER)
    suspend fun filterByGlass(
        @Query("g") glass: String
    ): ResponseModel

    @GET(DETAIL)
    suspend fun getDetails(
        @Query("i") detail: String
    ): ResponseModel
}