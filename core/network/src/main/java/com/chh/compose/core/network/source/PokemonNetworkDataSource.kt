package com.chh.compose.core.network.source

import com.chh.compose.core.network.model.PokemonPagedResponse
import com.chh.compose.core.network.utils.Result

interface PokemonNetworkDataSource {

    suspend fun fetchPokemonPaged(path: String): Result<PokemonPagedResponse>

}
