package com.chh.compose.feature.pokemon.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.chh.compose.core.common.restart.RestartableStateFlow
import com.chh.compose.core.common.restart.restartableStateIn
import com.chh.compose.core.common.result.asResult
import com.chh.compose.core.common.result.Result
import com.chh.compose.core.domain.GetPokemonInfoUseCase
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.UiState
import com.chh.compose.core.navigation.Route
import com.chh.compose.core.navigation.type.PokemonType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.reflect.typeOf

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getPokemonListUseCase: GetPokemonInfoUseCase
) : ViewModel() {

    val pokemon = savedStateHandle
        .toRoute<Route.PokemonDetail>(
            mapOf(typeOf<Pokemon>() to PokemonType)
        ).pokemon

    val detailUiState: RestartableStateFlow<UiState<PokemonInfo>> =
        getPokemonListUseCase(pokemon.name)
            .asResult()
            .map { result ->
                when (result) {
                    is Result.Loading -> UiState.Loading
                    is Result.Success -> UiState.Success(result.data)
                    is Result.Error -> UiState.Error(result.exception)
                }
            }
            .restartableStateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading
            )
}