package com.chh.compose.feature.pokemon.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chh.compose.core.designsystem.component.CircularProgress
import com.chh.compose.core.designsystem.component.ErrorView
import com.chh.compose.core.designsystem.component.TopAppBar
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.UiState
import com.chh.compose.feature.pokemon.detail.component.PokemonDetailHeader

@Composable
internal fun PokemonDetailScreen(
    onUpClick: () -> Unit,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val detailUiState by viewModel.detailUiState.collectAsStateWithLifecycle()

    when (val uiState = detailUiState) {
        is UiState.Loading -> {
            CircularProgress()
        }

        is UiState.Success -> {
            PokemonDetailContent(
                pokemon = viewModel.pokemon,
                pokemonInfo = uiState.data,
                onUpClick = onUpClick
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
internal fun PokemonDetailContent(
    pokemon: Pokemon,
    pokemonInfo: PokemonInfo,
    onUpClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            title = pokemon.name.replaceFirstChar { it.uppercase() },
            onNavigationClick = onUpClick
        )

        PokemonDetailHeader(pokemon)

        Text(
            text = "height: " + pokemonInfo.height + ", weight: " + pokemonInfo.weight,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge
        )
    }
}