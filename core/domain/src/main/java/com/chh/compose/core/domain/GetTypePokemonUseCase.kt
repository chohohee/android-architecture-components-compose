package com.chh.compose.core.domain

import com.chh.compose.core.data.repository.PokemonRepository
import com.chh.compose.core.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTypePokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    operator fun invoke(url: String): Flow<List<Pokemon>> = flow {
        val pokemon = pokemonRepository
            .getPokemonType(url)
            .map { it.pokemon }
            .toList()

        emit(pokemon)
    }
}
