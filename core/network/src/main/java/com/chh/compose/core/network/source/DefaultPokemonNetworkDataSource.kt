package com.chh.compose.core.network.source

import com.chh.compose.core.network.api.PokemonApi
import com.chh.compose.core.network.model.PokemonPagedResponse
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

}
