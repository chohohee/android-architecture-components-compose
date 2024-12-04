package com.chh.compose.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.chh.compose.core.data.paging.PokemonPagingSource
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.network.source.PokemonNetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DefaultPokemonRepository @Inject constructor(
    private val networkDataSource: PokemonNetworkDataSource,
) : PokemonRepository {

    override fun getPokemonList(): Flow<PagingData<Pokemon>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = { PokemonPagingSource(networkDataSource) },
    ).flow

    companion object {
        private const val PAGE_SIZE = 20
    }
}
