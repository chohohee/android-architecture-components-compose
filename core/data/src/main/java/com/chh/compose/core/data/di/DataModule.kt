package com.chh.compose.core.data.di

import com.chh.compose.core.data.repository.DefaultPokemonRepository
import com.chh.compose.core.data.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindPokemonRepository(
        pokemonRepository: DefaultPokemonRepository
    ): PokemonRepository

}
