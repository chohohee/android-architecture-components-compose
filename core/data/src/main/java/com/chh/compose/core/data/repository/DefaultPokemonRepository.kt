package com.chh.compose.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.chh.compose.core.data.paging.PokemonPagingSource
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.Type
import com.chh.compose.core.model.TypePokemon
import com.chh.compose.core.network.source.PokemonNetworkDataSource
import com.chh.compose.core.network.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DefaultPokemonRepository @Inject constructor(
    private val networkDataSource: PokemonNetworkDataSource,
) : PokemonRepository {

    override fun getPokemonList(): Flow<PagingData<Pokemon>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = { PokemonPagingSource(networkDataSource) },
    ).flow

    override suspend fun getPokemonInfo(name: String): PokemonInfo {
        return when (val result = networkDataSource.fetchPokemonInfo(name)) {
            is Result.Success -> result.data
            is Result.Error -> error(result.error)
        }
    }

    override suspend fun getPokemonTypeList(): List<Type> {
        return when (val result = networkDataSource.fetchPokemonTypeList()) {
            is Result.Success -> result.data.results
            is Result.Error -> error(result.error)
        }
    }

    override suspend fun getPokemonType(url: String): List<TypePokemon> {
        return when (val result = networkDataSource.fetchPokemonType(url)) {
            is Result.Success -> result.data.pokemon
            is Result.Error -> error(result.error)
        }
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}
