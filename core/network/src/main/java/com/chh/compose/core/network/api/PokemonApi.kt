package com.chh.compose.core.network.api

import com.chh.compose.core.network.model.PokemonPagedResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonApi {

    @GET
    suspend fun fetchPokemonPaged(
        @Url path: String
    ): PokemonPagedResponse

}
