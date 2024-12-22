package com.chh.compose.core.data.repository

import androidx.paging.PagingData
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.Type
import com.chh.compose.core.model.TypePokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(): Flow<PagingData<Pokemon>>

    suspend fun getPokemonInfo(name: String): PokemonInfo

    suspend fun getPokemonTypeList(): List<Type>

    suspend fun getPokemonType(url: String): List<TypePokemon>

}
