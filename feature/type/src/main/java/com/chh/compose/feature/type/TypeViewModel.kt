package com.chh.compose.feature.type

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chh.compose.core.common.restart.RestartableStateFlow
import com.chh.compose.core.common.restart.restartableStateIn
import com.chh.compose.core.common.result.asResult
import com.chh.compose.core.common.result.Result
import com.chh.compose.core.domain.GetPokemonTypeListUseCase
import com.chh.compose.core.model.Type
import com.chh.compose.core.model.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class TypeViewModel @Inject constructor(
    getPokemonTypeListUseCase: GetPokemonTypeListUseCase
) : ViewModel() {

    val typeUiState: RestartableStateFlow<UiState<List<Type>>> =
        getPokemonTypeListUseCase()
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