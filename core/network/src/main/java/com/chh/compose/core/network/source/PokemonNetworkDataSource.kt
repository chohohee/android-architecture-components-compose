package com.chh.compose.core.network.source

import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.network.model.PokemonPagedResponse
import com.chh.compose.core.network.model.PokemonTypeResponse
import com.chh.compose.core.network.model.PokemonTypesResponse
import com.chh.compose.core.network.utils.Result

interface PokemonNetworkDataSource {

    suspend fun fetchPokemonPaged(path: String): Result<PokemonPagedResponse>

    suspend fun fetchPokemonInfo(name: String): Result<PokemonInfo>

    suspend fun fetchPokemonTypeList(): Result<PokemonTypesResponse>

    suspend fun fetchPokemonType(url: String): Result<PokemonTypeResponse>

}
