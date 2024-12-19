package com.chh.compose.core.domain

import com.chh.compose.core.data.repository.PokemonRepository
import com.chh.compose.core.model.Type
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonTypeListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    operator fun invoke(): Flow<List<Type>> = flow {
        emit(pokemonRepository.getPokemonTypeList())
    }

}
