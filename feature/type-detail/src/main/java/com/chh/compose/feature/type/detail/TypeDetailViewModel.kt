package com.chh.compose.feature.type.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.chh.compose.core.common.restart.RestartableStateFlow
import com.chh.compose.core.common.restart.restartableStateIn
import com.chh.compose.core.common.result.Result
import com.chh.compose.core.common.result.asResult
import com.chh.compose.core.domain.GetTypePokemonUseCase
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.model.Type
import com.chh.compose.core.model.UiState
import com.chh.compose.core.navigation.Route
import com.chh.compose.core.navigation.type.TypeNavType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.reflect.typeOf

@HiltViewModel
class TypeDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getTypePokemonUseCase: GetTypePokemonUseCase
) : ViewModel() {

    val type = savedStateHandle
        .toRoute<Route.TypeDetail>(
            mapOf(typeOf<Type>() to TypeNavType)
        ).type

    val detailUiState: RestartableStateFlow<UiState<List<Pokemon>>> =
        getTypePokemonUseCase(type.url)
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