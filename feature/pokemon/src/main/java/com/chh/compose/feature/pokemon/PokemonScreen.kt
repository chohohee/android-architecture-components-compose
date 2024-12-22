package com.chh.compose.feature.pokemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.chh.compose.core.designsystem.component.CircularProgress
import com.chh.compose.core.designsystem.component.ErrorView
import com.chh.compose.core.model.Pokemon
import com.chh.compose.feature.pokemon.component.PokemonItem

@Composable
internal fun PokemonScreen(
    viewModel: PokemonViewModel = hiltViewModel(),
    onPokemonClick: (Pokemon) -> Unit
) {
    val items = viewModel.pagingDataFlow.collectAsLazyPagingItems()

    when (val refresh = items.loadState.refresh) {
        is LoadState.Loading -> CircularProgress()
        is LoadState.Error -> {
            ErrorView(
                message = refresh.error.message,
                modifier = Modifier.fillMaxSize(),
                refresh = { items.retry() }
            )
        }

        else -> PokemonList(items, onPokemonClick)
    }
}

@Composable
private fun PokemonList(
    items: LazyPagingItems<Pokemon>,
    onPokemonClick: (Pokemon) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        contentPadding = PaddingValues(
            start = 4.dp,
            top = 4.dp,
            end = 4.dp,
            bottom = 74.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items.itemCount) { index ->
            val item = items[index]
            item?.let {
                PokemonItem(
                    item,
                    onPokemonClick
                )
            }
        }

        when (val append = items.loadState.append) {
            is LoadState.Loading -> {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    CircularProgress()
                }
            }

            is LoadState.Error -> {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    ErrorView(
                        message = append.error.message,
                        modifier = Modifier.fillMaxSize(),
                        refresh = { items.retry() }
                    )
                }
            }

            else -> Unit
        }
    }
}