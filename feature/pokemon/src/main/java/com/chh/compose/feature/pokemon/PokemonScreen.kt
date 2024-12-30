package com.chh.compose.feature.pokemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.chh.compose.core.designsystem.R
import com.chh.compose.core.designsystem.component.CircularProgress
import com.chh.compose.core.designsystem.component.ErrorView
import com.chh.compose.core.designsystem.component.ThemePreviews
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.ui.PokemonItem
import kotlinx.coroutines.flow.flowOf

@Composable
internal fun PokemonScreen(
    onPokemonClick: (Pokemon) -> Unit,
    viewModel: PokemonViewModel = hiltViewModel()
) {
    val items = viewModel.pagingDataFlow.collectAsLazyPagingItems()

    when (val refresh = items.loadState.refresh) {
        is LoadState.Loading -> CircularProgress()
        is LoadState.Error -> {
            ErrorView(
                message = refresh.error.message,
                refresh = { items.retry() },
                modifier = Modifier.fillMaxSize()
            )
        }

        else -> PokemonList(
            items = items,
            onPokemonClick = onPokemonClick
        )
    }
}

@Composable
private fun PokemonList(
    items: LazyPagingItems<Pokemon>,
    onPokemonClick: (Pokemon) -> Unit,
    previewPainter: Painter? = null
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
                    item = item,
                    onPokemonClick = onPokemonClick,
                    previewPainter = previewPainter
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
                        refresh = { items.retry() },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            else -> Unit
        }
    }
}

@ThemePreviews
@Composable
private fun PokemonListPreview() {
    val item = Pokemon(
        name = "bulbasaur",
        url = "https://pokeapi.co/api/v2/pokemon/1/"
    )
    AACComposeTheme {
        PokemonList(
            items = flowOf(PagingData.from(listOf(item, item))).collectAsLazyPagingItems(),
            onPokemonClick = {},
            previewPainter = painterResource(R.drawable.preview_pokemon)
        )
    }
}