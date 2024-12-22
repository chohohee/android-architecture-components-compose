package com.chh.compose.core.network.source

import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.network.api.PokemonApi
import com.chh.compose.core.network.model.PokemonPagedResponse
import com.chh.compose.core.network.model.PokemonTypeResponse
import com.chh.compose.core.network.model.PokemonTypesResponse
import com.chh.compose.core.network.utils.Result
import com.chh.compose.core.network.utils.safeApiCall
import javax.inject.Inject

internal class DefaultPokemonNetworkDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonNetworkDataSource {

    override suspend fun fetchPokemonPaged(path: String): Result<PokemonPagedResponse> =
        safeApiCall {
            pokemonApi.fetchPokemonPaged(path)
        }

    override suspend fun fetchPokemonInfo(name: String): Result<PokemonInfo> =
        safeApiCall {
            pokemonApi.fetchPokemonInfo(name)
        }

    override suspend fun fetchPokemonTypeList(): Result<PokemonTypesResponse> =
        safeApiCall {
            pokemonApi.fetchPokemonTypeList()
        }

    override suspend fun fetchPokemonType(url: String): Result<PokemonTypeResponse> =
        safeApiCall {
            pokemonApi.fetchPokemonType(url)
        }

}
