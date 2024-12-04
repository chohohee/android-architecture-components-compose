package com.chh.compose.core.data.repository

import androidx.paging.PagingData
import com.chh.compose.core.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(): Flow<PagingData<Pokemon>>

}
