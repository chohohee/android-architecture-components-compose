package com.chh.compose.core.network.api

import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.network.model.PokemonPagedResponse
import com.chh.compose.core.network.model.PokemonTypeResponse
import com.chh.compose.core.network.model.PokemonTypesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApi {

    @GET
    suspend fun fetchPokemonPaged(
        @Url path: String
    ): PokemonPagedResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path("name") name: String
    ): PokemonInfo

    @GET("type")
    suspend fun fetchPokemonTypeList(): PokemonTypesResponse

    @GET
    suspend fun fetchPokemonType(
        @Url url: String
    ): PokemonTypeResponse

}
