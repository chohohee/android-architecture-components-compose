package com.chh.compose.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.chh.compose.core.domain.GetPokemonListUseCase
import com.chh.compose.core.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPokemonListUseCase: GetPokemonListUseCase,
) : ViewModel() {

    val pagingDataFlow: Flow<PagingData<Pokemon>> =
        getPokemonListUseCase().cachedIn(viewModelScope)
}