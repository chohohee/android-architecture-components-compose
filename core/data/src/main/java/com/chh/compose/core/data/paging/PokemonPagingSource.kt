package com.chh.compose.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.network.source.PokemonNetworkDataSource
import com.chh.compose.core.network.utils.Result

internal class PokemonPagingSource(
    private val networkDataSource: PokemonNetworkDataSource
) : PagingSource<String, Pokemon>() {

    override fun getRefreshKey(state: PagingState<String, Pokemon>): String? =
        state.anchorPosition?.let { state.closestPageToPosition(it)?.nextKey }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Pokemon> {
        return when (val result = networkDataSource.fetchPokemonPaged(params.key ?: PATH)) {
            is Result.Success -> {
                LoadResult.Page(
                    data = result.data.results,
                    prevKey = null,
                    nextKey = result.data.next
                )
            }

            is Result.Error -> LoadResult.Error(result.error)
        }
    }

    companion object {
        const val PATH = "https://pokeapi.co/api/v2/pokemon"
    }
}
