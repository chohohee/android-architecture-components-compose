package com.chh.compose.core.domain

import androidx.paging.PagingData
import com.chh.compose.core.data.repository.PokemonRepository
import com.chh.compose.core.model.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    operator fun invoke(): Flow<PagingData<Pokemon>> =
        pokemonRepository.getPokemonList()

}
