package com.chh.compose.core.domain

import com.chh.compose.core.data.repository.PokemonRepository
import com.chh.compose.core.model.PokemonInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    operator fun invoke(name: String): Flow<PokemonInfo> = flow {
        emit(pokemonRepository.getPokemonInfo(name))
    }

}
