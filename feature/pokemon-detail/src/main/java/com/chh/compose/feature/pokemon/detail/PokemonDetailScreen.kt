package com.chh.compose.feature.pokemon.detail

import androidx.compose.foundation.layout.fillMaxSize
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
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.UiState

@Composable
internal fun PokemonDetailScreen(
    onUpClick: () -> Unit,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val detailUiState by viewModel.detailUiState.collectAsStateWithLifecycle()

    when (val uiState = detailUiState) {
        is UiState.Loading -> CircularProgress()
        is UiState.Success -> PokemonDetailContent(uiState.data)
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
    item: PokemonInfo
) {
    Text(
        text = item.name + ", height: " + item.height + ", weight: " + item.weight,
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleLarge
    )
}