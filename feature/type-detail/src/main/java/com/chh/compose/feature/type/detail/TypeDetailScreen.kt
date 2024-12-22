package com.chh.compose.feature.type.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chh.compose.core.designsystem.component.CircularProgress
import com.chh.compose.core.designsystem.component.ErrorView
import com.chh.compose.core.designsystem.component.TopAppBar
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.model.Type
import com.chh.compose.core.model.UiState
import com.chh.compose.core.ui.PokemonItem

@Composable
internal fun TypeDetailScreen(
    onUpClick: () -> Unit,
    onPokemonClick: (Pokemon) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TypeDetailViewModel = hiltViewModel()
) {
    val detailUiState by viewModel.detailUiState.collectAsStateWithLifecycle()

    when (val uiState = detailUiState) {
        is UiState.Loading -> {
            CircularProgress()
        }

        is UiState.Success -> {
            TypeDetailContent(
                type = viewModel.type,
                pokemon = uiState.data,
                onUpClick = onUpClick,
                onPokemonClick = onPokemonClick,
                modifier = modifier
            )
        }

        is UiState.Error -> {
            ErrorView(
                message = uiState.exception.message,
                modifier = Modifier.fillMaxSize(),
                refresh = viewModel.detailUiState::restart
            )
        }
    }
}

@Composable
internal fun TypeDetailContent(
    type: Type,
    pokemon: List<Pokemon>,
    onUpClick: () -> Unit,
    onPokemonClick: (Pokemon) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = type.name.replaceFirstChar { it.uppercase() },
            onNavigationClick = onUpClick
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 140.dp),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(pokemon.size) { index ->
                PokemonItem(
                    item = pokemon[index],
                    onPokemonClick = onPokemonClick
                )
            }
        }
    }
}